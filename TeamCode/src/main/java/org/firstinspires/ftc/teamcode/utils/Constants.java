package org.firstinspires.ftc.teamcode.utils;

import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.constants.PinpointConstants;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.control.FilteredPIDFCoefficients;
import com.pedropathing.control.PIDFCoefficients;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Constants {

    // ============================================================
    //                    DRIVE MOTOR NAMES
    //   Must match the hardware map in the Robot Controller app.
    // ============================================================

    public static final String LEFT_FRONT_NAME  = "leftFront";
    public static final String RIGHT_FRONT_NAME = "rightFront";
    public static final String LEFT_BACK_NAME   = "leftBack";
    public static final String RIGHT_BACK_NAME  = "rightBack";

    // ============================================================
    //                    MECHANISM HARDWARE NAMES
    //   Add motor/servo names here for each mechanism on this
    //   year's robot. See archive/season-2025-26/ for examples.
    //
    //   Pattern:
    //     public static final String LIFT_NAME = "lift";
    //     public static final String CLAW_SERVO_NAME = "claw";
    // ============================================================

    // ============================================================
    //                    SENSOR NAMES
    // ============================================================

    public static final String IMU_NAME      = "imu";
    public static final String COLOR_SENSOR  = "colorSensor";
    public static final String LIMELIGHT_NAME = "limelight";

    // ============================================================
    //                    MOTOR DIRECTIONS
    //   Verify with TeleOp while robot is propped up on a block.
    //   If a wheel spins backward, flip its direction here.
    // ============================================================

    public static final DcMotorSimple.Direction LEFT_FRONT_DIRECTION  = DcMotorSimple.Direction.REVERSE;
    public static final DcMotorSimple.Direction LEFT_BACK_DIRECTION   = DcMotorSimple.Direction.FORWARD;
    public static final DcMotorSimple.Direction RIGHT_FRONT_DIRECTION = DcMotorSimple.Direction.REVERSE;
    public static final DcMotorSimple.Direction RIGHT_BACK_DIRECTION  = DcMotorSimple.Direction.FORWARD;

    /** BRAKE = resist movement at zero power. FLOAT = free spin. */
    public static final DcMotor.ZeroPowerBehavior DRIVE_ZERO_POWER_BEHAVIOR =
            DcMotor.ZeroPowerBehavior.BRAKE;

    // ============================================================
    //                    DRIVE SPEED & TOLERANCES
    // ============================================================

    public static final double MAX_DRIVE_POWER       = 1.0;
    public static final double MIN_DRIVE_SPEED       = 0.2;
    public static final double MAX_DRIVE_SPEED       = 1.0;
    public static final double DEFAULT_DRIVE_SPEED   = 1.0;
    /** Multiplier applied when slow-mode button is held (right bumper). */
    public static final double SLOW_MODE_MULTIPLIER  = 0.3;

    /** Gamepad stick inputs below this threshold are ignored (prevents drift). */
    public static final double INPUT_THRESHOLD        = 0.1;
    /** How close (inches) the robot must be to a target pose to consider it reached. */
    public static final double POSE_TOLERANCE         = 0.5;
    /** How close (degrees) the heading must be to consider a turn complete. */
    public static final double HEADING_TOLERANCE_DEGREES = 10.0;

    /** Start in field-centric mode by default. */
    public static final boolean DEFAULT_FIELD_CENTRIC = true;

    // ============================================================
    //                    FIELD GEOMETRY
    //   Update these bounds for the new game's field dimensions.
    //   Used by Panels for field visualization.
    // ============================================================

    public static final double FIELD_BOTTOM_LEFT_X = 0;
    public static final double FIELD_BOTTOM_LEFT_Y = -86;
    public static final double FIELD_TOP_RIGHT_X   = 230;
    public static final double FIELD_TOP_RIGHT_Y   = 144;

    // ============================================================
    //                    PARKING COORDINATES
    //   Update these for the new game's observation/parking zone.
    //   Used by DriveToPark — one set per alliance.
    // ============================================================

    public static final double RED_PARK_X  = 40.0;
    public static final double RED_PARK_Y  = 32.0;
    public static final double BLUE_PARK_X = 105.0;
    public static final double BLUE_PARK_Y = 32.0;

    // ============================================================
    //                    GAME-SPECIFIC CONSTANTS
    //   This is where scoring targets, game piece positions, and
    //   mechanism tuning values live. They change every season.
    //   See archive/season-2025-26/utils/ for a complete example.
    //
    //   Common patterns to add back each year:
    //
    //   // Scoring target for each alliance:
    //   public static final double RED_TARGET_X  = ...;
    //   public static final double RED_TARGET_Y  = ...;
    //   public static final double BLUE_TARGET_X = ...;
    //   public static final double BLUE_TARGET_Y = ...;
    //
    //   // Game piece field positions:
    //   public static final Pose FIRST_RED_PIECE  = new Pose(...);
    //   public static final Pose SECOND_RED_PIECE = new Pose(...);
    //
    //   // Mechanism power/RPM tuning:
    //   public static final double LAUNCHER_IDLE_POWER  = 0.3;
    //   public static final double LAUNCHER_FEED_RPM    = 150.0;
    //   public static final double[][] RPM_TABLE = { {dist, rpm}, ... };
    //   public static double lookupRPM(double dist) { ... }
    // ============================================================

    // ============================================================
    //                    IMU ORIENTATION
    //   Change these if the REV Hub is remounted in a new position.
    // ============================================================

    public static final RevHubOrientationOnRobot.LogoFacingDirection IMU_LOGO_DIRECTION =
            RevHubOrientationOnRobot.LogoFacingDirection.DOWN;
    public static final RevHubOrientationOnRobot.UsbFacingDirection IMU_USB_DIRECTION =
            RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD;

    // ============================================================
    //                    PEDRO FOLLOWER CONSTANTS
    //
    //   NOTE: If upgrading to Pedro Pathing v2.1+, the PIDF
    //   coefficients below are replaced by predictive braking.
    //   See: pedropathing.com/docs/pathing/tuning/drive-algorithm/predictive
    //
    //   Tuning order (do once at the start of each season after re-mounting odometry):
    //     1. Forward Zero Power Acceleration (automatic tuner)
    //     2. Lateral Zero Power Acceleration (automatic tuner)
    //     3. Forward Velocity / Lateral Velocity (automatic tuner)
    //     4. Translational PIDF (manual — push sideways, adjust until smooth)
    //     5. Heading PIDF (manual — rotate robot, adjust until smooth)
    //     6. Drive PIDF (optional fine-tuning)
    //     7. Centripetal scaling (run circles, typical 0.001–0.01)
    // ============================================================

    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(13.607)
            .useSecondaryTranslationalPIDF(false)
            .useSecondaryHeadingPIDF(false)
            .useSecondaryDrivePIDF(false)
            // https://pedropathing.com/docs/pathing/tuning/automatic#forward-zero-power-acceleration
            .forwardZeroPowerAcceleration(-49.49417)
            // https://pedropathing.com/docs/pathing/tuning/automatic#lateral-zero-power-acceleration
            .lateralZeroPowerAcceleration(-96.90029)
            // https://pedropathing.com/docs/pathing/tuning/pids/translational
            .translationalPIDFCoefficients(new PIDFCoefficients(0.08, 0, 0.005, 0.035))
            // https://pedropathing.com/docs/pathing/tuning/pids/heading
            .headingPIDFCoefficients(new PIDFCoefficients(0.9, 0, 0.02, 0.03))
            // https://pedropathing.com/docs/pathing/tuning/pids/drive
            .drivePIDFCoefficients(new FilteredPIDFCoefficients(0.003, 0, 0.0001, 0, 0.3))
            // https://pedropathing.com/docs/pathing/tuning/pids/centripetal
            .centripetalScaling(0.0005);

    // ============================================================
    //                    MECANUM DRIVETRAIN CONSTANTS
    //   Re-tune xVelocity and yVelocity if the drivetrain changes.
    //   https://pedropathing.com/docs/pathing/tuning/automatic#forward-velocity-tuner
    // ============================================================

    public static MecanumConstants mecanumConstants = new MecanumConstants()
            .xVelocity(62.72988)
            .yVelocity(49.42162)
            .maxPower(MAX_DRIVE_POWER)
            .rightRearMotorName(RIGHT_BACK_NAME)
            .rightFrontMotorName(RIGHT_FRONT_NAME)
            .leftRearMotorName(LEFT_BACK_NAME)
            .leftFrontMotorName(LEFT_FRONT_NAME)
            .leftFrontMotorDirection(LEFT_FRONT_DIRECTION)
            .leftRearMotorDirection(LEFT_BACK_DIRECTION)
            .rightFrontMotorDirection(RIGHT_FRONT_DIRECTION)
            .rightRearMotorDirection(RIGHT_BACK_DIRECTION);

    /**
     * Path completion criteria — tighten tolerances after basic tuning is done.
     *   End T-value: increase if path stops before the endpoint
     *   Timeout ms:  increase if path cuts corners at full speed
     */
    public static PathConstraints pathConstraints = new PathConstraints(
            0.99,  // End T-value
            100,   // Timeout ms
            1,     // Position tolerance inches
            1      // Heading tolerance radians
    );

    // ============================================================
    //                    PINPOINT LOCALIZATION
    //   Pod offsets are measured from robot center to each pod.
    //   Re-measure and re-tune if pods are remounted.
    //   Use the Pedro automatic offset tuner (v2.1+) to skip manual measurement.
    //   https://pedropathing.com/docs/pathing/tuning/localization/pinpoint
    // ============================================================

    public static PinpointConstants localizerConstants = new PinpointConstants()
            .forwardPodY(3)    // inches forward of center (positive = forward)
            .strafePodX(-9)    // inches left of center (negative = left)
            .distanceUnit(DistanceUnit.INCH)
            .encoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_SWINGARM_POD)
            .forwardEncoderDirection(GoBildaPinpointDriver.EncoderDirection.REVERSED)
            .strafeEncoderDirection(GoBildaPinpointDriver.EncoderDirection.REVERSED);

    // ============================================================
    //                    FOLLOWER FACTORY
    // ============================================================

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pathConstraints(pathConstraints)
                .mecanumDrivetrain(mecanumConstants)
                .pinpointLocalizer(localizerConstants)
                .build();
    }
}
