package org.firstinspires.ftc.teamcode;

import com.pedropathing.geometry.Pose;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.Robot;
import com.seattlesolvers.solverslib.command.button.GamepadButton;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.Drive;
import org.firstinspires.ftc.teamcode.commands.DriveToPark;
import org.firstinspires.ftc.teamcode.subsystems.PedroDrive;
import org.firstinspires.ftc.teamcode.subsystems.Sensors;
import org.firstinspires.ftc.teamcode.utils.Constants;
import org.firstinspires.ftc.teamcode.utils.PersistentPoseManager;

/**
 * Main robot class — the single object that wires everything together.
 *
 * It owns subsystems, registers them with the command scheduler, and
 * sets up button bindings. Game-specific mechanisms (launcher, intake,
 * turret) and autonomous sequences from the 2025-26 season live in
 * archive/season-2025-26/ for reference.
 *
 * Each year:
 *   1. Add new subsystem fields below (e.g., Lift lift; Claw claw;)
 *   2. Instantiate them in initTeleOp() / initAuto()
 *   3. Add them to register(...)
 *   4. Bind driver 2 buttons in initTeleOp()
 *   5. Build autonomous sequences in initAuto()
 */
public class Moonbase extends Robot {

    // ============================================================
    //                    CORE OPMODE REFERENCES
    // ============================================================

    public LinearOpMode opMode;
    public GamepadEx player1;
    public GamepadEx player2;  // wire up when mechanisms are added

    // ============================================================
    //                    MATCH CONFIGURATION
    // ============================================================

    /** Set by AutoOpMain from driver selection; loaded from file in TeleOp. */
    public boolean isRed;

    // ============================================================
    //                    SUBSYSTEMS
    //   Add game-specific mechanism subsystems here each year:
    //     public Lift lift;
    //     public Claw claw;
    // ============================================================

    public PedroDrive drive;
    public Sensors sensors;

    // ============================================================
    //                    CONVENIENCE REFERENCES
    // ============================================================

    public Telemetry telemetry;
    public HardwareMap hardwareMap;
    public Pose startPose;

    // ============================================================
    //                    TELEOP CONSTRUCTOR
    // ============================================================

    /**
     * Loads alliance and pose from the file saved at the end of autonomous,
     * then runs initTeleOp().
     */
    public Moonbase(LinearOpMode opMode) {
        this.opMode      = opMode;
        this.telemetry   = opMode.telemetry;
        this.hardwareMap = opMode.hardwareMap;

        player1 = new GamepadEx(opMode.gamepad1);
        player2 = new GamepadEx(opMode.gamepad2);

        startPose = PersistentPoseManager.loadPose();
        isRed     = PersistentPoseManager.loadIsRed();

        initTeleOp();
    }

    // ============================================================
    //                    AUTONOMOUS CONSTRUCTOR
    // ============================================================

    /**
     * Sets the starting pose from alliance selection, then runs initAuto().
     * Add more position parameters here if the game has multiple starting tiles
     * (e.g., boolean isNearSide).
     */
    public Moonbase(LinearOpMode opMode, boolean isRed) {
        this.opMode      = opMode;
        this.telemetry   = opMode.telemetry;
        this.hardwareMap = opMode.hardwareMap;
        this.isRed       = isRed;

        player1 = new GamepadEx(opMode.gamepad1);
        player2 = new GamepadEx(opMode.gamepad2);

        // TODO: Set starting poses to match this year's field layout.
        // Pose(x inches, y inches, heading radians) — 0 rad faces right (+X).
        // Pedro's coordinate origin is the near-left corner of your alliance tile.
        if (isRed) {
            startPose = new Pose(0, 0, 0);  // TODO: red alliance starting pose
        } else {
            startPose = new Pose(0, 0, 0);  // TODO: blue alliance starting pose
        }

        initAuto();
    }

    // ============================================================
    //                    TELEOP INIT
    // ============================================================

    public void initTeleOp() {
        drive   = new PedroDrive(this, startPose);
        sensors = new Sensors(this);

        // Add new subsystems to this register call so the scheduler updates them:
        //   register(drive, sensors, lift, claw);
        register(drive, sensors);

        drive.follower.startTeleopDrive();
        drive.setDefaultCommand(new Drive(this));

        bindDriverButtons();
    }

    // ============================================================
    //                    AUTONOMOUS INIT
    // ============================================================

    public void initAuto() {
        drive   = new PedroDrive(this, startPose);
        sensors = new Sensors(this);
        register(drive, sensors);

        drive.update();  // seed localization before first path

        // TODO: Build this year's autonomous command sequence here.
        // See archive/season-2025-26/Moonbase.java for the full MOTIF-based
        // DECODE autonomous with SequentialCommandGroup / ParallelCommandGroup.
        //
        // Pattern:
        //   new SequentialCommandGroup(
        //       new DriveToPose(this, targetPose, timeoutSeconds),
        //       new InstantCommand(() -> mechanism.doThing()),
        //       ...
        //   ).schedule();
    }

    // ============================================================
    //                    DRIVER 1 BUTTON BINDINGS
    // ============================================================

    private void bindDriverButtons() {

        /*
                .__                                      ____
        ______  |  |  _____   ___.__.  ____ _______     /_   |
        \____ \ |  |  \__  \ <   |  |_/ __ \\_  __ \     |   |
        |  |_> >|  |__ / __ \_\___  |\  ___/ |  | \/     |   |
        |   __/ |____/(____  // ____| \___  >|__|        |___|
        |__|               \/ \/          \/
        */

        // A — reset field-centric heading (use when robot drifts out of alignment)
        new GamepadButton(player1, GamepadKeys.Button.A)
                .whenPressed(() -> drive.resetHeading());

        // B — toggle between field-centric and robot-centric drive
        new GamepadButton(player1, GamepadKeys.Button.B)
                .whenPressed(() -> drive.toggleFieldCentric());

        // X — drive to the alliance parking zone (end-game)
        new GamepadButton(player1, GamepadKeys.Button.X)
                .whenPressed(() -> new DriveToPark(this, 30).schedule());

        // BACK — emergency relocalize: snap pose to a known field landmark.
        // Update the pose constants here to match a reliable spot on next year's field.
        new GamepadButton(player1, GamepadKeys.Button.BACK)
                .whenPressed(new InstantCommand(() -> {
                    Pose knownLandmark = isRed
                            ? new Pose(Constants.RED_PARK_X,  Constants.RED_PARK_Y,  0)
                            : new Pose(Constants.BLUE_PARK_X, Constants.BLUE_PARK_Y, 0);
                    drive.setPose(knownLandmark);
                    sensors.addTelemetry("✓ Relocalized", isRed ? "Red zone" : "Blue zone");
                }));

        // DPAD UP — cancel any active path and resume manual driving
        new GamepadButton(player1, GamepadKeys.Button.DPAD_UP)
                .whenPressed(() -> {
                    drive.follower.breakFollowing();
                    drive.follower.startTeleopDrive();
                });

        // ============================================================
        //                    DRIVER 2 BUTTON BINDINGS
        //   Add mechanism commands for player 2 here each year.
        //   See archive/season-2025-26/Moonbase.java for examples of:
        //     - whenPressed / whenHeld / whileActiveContinuous
        //     - InstantCommand for instant servo/state changes
        //     - Trigger for analog inputs (getTrigger)
        //     - LauncherRPM-style stateful commands with a feed state machine
        // ============================================================
    }
}
