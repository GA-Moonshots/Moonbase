package org.firstinspires.ftc.teamcode.subsystems;

import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Moonbase;
import org.firstinspires.ftc.teamcode.utils.Constants;

/**
 * Manages all sensors: color detection, Limelight vision, and telemetry output.
 *
 * Telemetry note: this subsystem owns the single TelemetryManager update call
 * for the whole project (see periodic()). Every other subsystem posts data via
 * robot.sensors.addTelemetry() so updates are batched here. For next year,
 * consider extracting this into a standalone Dashboard utility class so sensors
 * and telemetry are decoupled.
 *
 * Vision signal detection note: game-specific autonomous signal logic (e.g., MOTIF
 * detection) should NOT live here. Instead, implement an AutoSignalDetector and
 * register it before auto starts — see archive/season-2025-26/subsystems/ for the
 * MOTIF example. Pattern:
 *
 *   interface AutoSignalDetector { String detect(LLResult result); }
 *   sensors.setSignalDetector(result -> { ... });
 */
public class Sensors extends SubsystemBase {

    private final Telemetry telemetry;
    private final TelemetryManager telemetryM;
    private final Moonbase robot;

    /** null when the Limelight is not connected or failed to initialize. */
    private Limelight3A limelight;

    public RevColorSensorV3 colorSensor;

    // ============================================================
    //              COLOR DETECTION CONSTANTS
    //   These HSV thresholds were tuned for the 2025-26 game balls.
    //   Re-tune for next year's game pieces using the color telemetry
    //   output during a test OpMode with the sensor aimed at each object.
    //
    //   Improvement opportunity: add DEBOUNCE_CYCLES (e.g., 3) and only
    //   report a color after that many consecutive matching reads to
    //   reduce false positives from sensor noise or brief occlusions.
    // ============================================================

    private static final float GREEN_HUE_MIN        = 145f;
    private static final float GREEN_HUE_MAX        = 160f;
    private static final float MIN_SATURATION       = 0.3f;
    private static final float MIN_VALUE            = 0.15f;
    private static final float GREEN_RATIO_THRESHOLD = 1.3f;
    private static final float COLOR_SENSOR_GAIN    = 2.0f;

    // ============================================================
    //              BALL COLOR ENUM
    //   Rename/extend this for next year's game pieces.
    // ============================================================

    public enum BallColor {
        GREEN,
        PURPLE,
        NONE
    }

    // ============================================================
    //                        CONSTRUCTOR
    // ============================================================

    public Sensors(Moonbase robot) {
        this.robot = robot;
        telemetry  = robot.telemetry;
        telemetryM = PanelsTelemetry.INSTANCE.getTelemetry();

        colorSensor = robot.hardwareMap.get(RevColorSensorV3.class, Constants.COLOR_SENSOR);
        colorSensor.setGain(COLOR_SENSOR_GAIN);

        try {
            limelight = robot.hardwareMap.get(Limelight3A.class, Constants.LIMELIGHT_NAME);
            limelight.setPollRateHz(30);
            limelight.start();
            limelight.pipelineSwitch(0);  // Pipeline 0 = AprilTag detection
        } catch (Exception e) {
            limelight = null;
            addTelemetry("Limelight", "OFFLINE: " + e.getMessage());
        }
    }

    // ============================================================
    //              PERIODIC UPDATE
    // ============================================================

    @Override
    public void periodic() {
        addTelemetry("═══ LIMELIGHT ═══", "");

        if (limelight != null) {
            try {
                LLResult result = limelight.getLatestResult();
                boolean valid = result != null && result.isValid();
                addTelemetry("LL Connected", String.valueOf(limelight.isConnected()));
                addTelemetry("LL Result", valid
                        ? String.format("valid | %d fiducials | age %dms",
                                result.getFiducialResults().size(),
                                limelight.getTimeSinceLastUpdate())
                        : String.format("NO DATA | age %dms",
                                limelight.getTimeSinceLastUpdate()));

                // Game-specific autonomous signal detection goes here each year.
                // Example pattern: if (signalDetector != null) robot.autoSignal = signalDetector.detect(result);
                // See archive/season-2025-26/subsystems/Sensors.java for the MOTIF implementation.

            } catch (Exception e) {
                limelight = null;
                addTelemetry("LL Connected", "LOST");
            }
        } else {
            addTelemetry("LL Connected", "OFFLINE");
        }

        addColorTelemetry();

        // THIS IS THE ONLY TELEMETRY UPDATE CALL IN THE PROJECT.
        // All subsystems write via addTelemetry(); this flushes to the dashboard.
        telemetryM.update(telemetry);
    }

    // ============================================================
    //              TELEMETRY HELPERS
    // ============================================================

    public void addTelemetry(String key, String value) {
        telemetryM.addData(key, value);
    }

    public void addTelemetry(String key, String format, Object... args) {
        telemetryM.addData(key, String.format(format, args));
    }

    private void addColorTelemetry() {
        addTelemetry("Ball Color", detectBallColor().toString());
    }

    // ============================================================
    //              COLOR DETECTION
    //   isGreen() and isPurple() are designed for two-color sorting.
    //   For a different game, replace the HSV thresholds above and
    //   add new detection methods (e.g., isYellow(), isRed()) following
    //   the same HSV + ratio pattern used in isGreen().
    // ============================================================

    public boolean isGreen() {
        NormalizedRGBA sample = colorSensor.getNormalizedColors();

        if (sample.alpha < MIN_VALUE) return false;

        float[] hsv = rgbToHsv(sample.red, sample.green, sample.blue);
        boolean hsvGreen = (hsv[0] >= GREEN_HUE_MIN && hsv[0] <= GREEN_HUE_MAX)
                && hsv[1] >= MIN_SATURATION
                && hsv[2] >= MIN_VALUE;

        float greenRatio = sample.green / Math.max(sample.red, sample.blue);
        boolean rgbGreen = greenRatio > GREEN_RATIO_THRESHOLD
                && sample.green > sample.red
                && sample.green > sample.blue;

        return hsvGreen || rgbGreen;
    }

    public boolean isPurple() {
        NormalizedRGBA sample = colorSensor.getNormalizedColors();
        return sample.alpha >= MIN_VALUE && !isGreen();
    }

    public BallColor detectBallColor() {
        NormalizedRGBA sample = colorSensor.getNormalizedColors();
        if (sample.alpha < MIN_VALUE) return BallColor.NONE;
        return isGreen() ? BallColor.GREEN : BallColor.PURPLE;
    }

    // ============================================================
    //              RGB → HSV CONVERSION
    //   Standard conversion — no need to change this between games.
    // ============================================================

    private float[] rgbToHsv(float r, float g, float b) {
        float max   = Math.max(r, Math.max(g, b));
        float min   = Math.min(r, Math.min(g, b));
        float delta = max - min;

        float hue        = 0;
        float saturation = (max == 0) ? 0 : delta / max;
        float value      = max;

        if (delta != 0) {
            if      (max == r) hue = 60 * (((g - b) / delta) % 6);
            else if (max == g) hue = 60 * (((b - r) / delta) + 2);
            else               hue = 60 * (((r - g) / delta) + 4);
            if (hue < 0) hue += 360;
        }

        return new float[]{hue, saturation, value};
    }
}
