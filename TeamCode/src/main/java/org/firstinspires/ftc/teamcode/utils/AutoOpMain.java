package org.firstinspires.ftc.teamcode.utils;

import com.pedropathing.geometry.Pose;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Moonbase;
import org.firstinspires.ftc.teamcode.commands.SavePoseCommand;

/**
 * Autonomous OpMode entry point.
 *
 * During init, the driver selects alliance color (B = RED, X = BLUE).
 * Add more selection options here if the game has multiple starting positions —
 * see archive/season-2025-26/utils/AutoOpMain.java for a near/far example.
 *
 * The selected configuration is passed to the Moonbase constructor, which
 * sets the starting pose and schedules the autonomous sequence.
 *
 * SavePoseCommand runs at the end of auto and writes the final pose + alliance
 * to a file so TeleOp can pick up from where auto left off.
 */
@Autonomous(name = "Autonomous - Main", group = "Competition")
public class AutoOpMain extends CommandOpMode {

    private boolean isRed = true;
    private Moonbase robot;

    @Override
    public void initialize() {
        // Selection loop — runs until START is pressed
        while (opModeInInit()) {
            if      (gamepad1.x || gamepad2.x) isRed = false;
            else if (gamepad1.b || gamepad2.b) isRed = true;

            telemetry.addLine("═══════════════════════════════");
            telemetry.addLine("   AUTONOMOUS CONFIGURATION");
            telemetry.addLine("═══════════════════════════════");
            telemetry.addLine();
            telemetry.addData("Alliance", isRed ? "RED  (B)" : "BLUE (X)");
            // TODO: Add position selection lines here if the game has multiple starting tiles.
            telemetry.addLine();
            telemetry.addLine("Press START when ready!");
            telemetry.update();
        }

        robot = new Moonbase(this, isRed);
        schedule(new SavePoseCommand(robot));
    }

    @Override
    public void run() {
        super.run();
    }

    /** Saves the robot's final pose and alliance color so TeleOp can resume correctly. */
    @Override
    public void reset() {
        super.reset();
        if (robot != null && robot.drive != null) {
            PersistentPoseManager.savePose(robot.drive.getPose(), isRed);
        }
    }
}
