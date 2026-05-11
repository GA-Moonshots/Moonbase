---
description: The files that drive SolversLib
---

# Under the Hood

Before looking under the hood of our code, programmers should study the Command pattern's goals of organized, non-blocking code. We've done that ✅. You don't need to go past this point. We hardly ever need to touch these files. Programmers can contribute to a team by knowing how `Command` and `Subsystem` work together and how to run their code. Proceeding on means you want the next level. You're comfortable and open-minded about how this all works.&#x20;

<figure><img src="../../.gitbook/assets/nod.gif" alt=""><figcaption></figcaption></figure>

## **Robot.java and CommandOpMode: The Behind-the-Scenes Magic**

The secret to understanding how we turned FTC's code into a Command pattern is how the following two files connect. They sit in our utils folder, working their magic—we may never need to touch them. Let's start with Robot.java.

### **Robot.java**

```java
public abstract class Robot {

    public static boolean isDisabled = false;

    /**
     * Cancels all previous commands
     */
    public void reset() {
        CommandScheduler.getInstance().reset();
    }

    /**
     * Runs the {@link CommandScheduler} instance
     */
    public void run() {
        CommandScheduler.getInstance().run();
    }

    /**
     * Schedules {@link com.seattlesolvers.solverslib.command.Command} objects to the scheduler
     */
    public void schedule(Command... commands) {
        CommandScheduler.getInstance().schedule(commands);
    }

    /**
     * Registers {@link com.seattlesolvers.solverslib.command.Subsystem} objects to the scheduler
     */
    public void register(Subsystem... subsystems) {
        CommandScheduler.getInstance().registerSubsystem(subsystems);
    }

    public static void disable() {
        isDisabled = true;
    }

    public static void enable() {
        isDisabled = false;
    }
}
```

This file acts as an invisible layer between your robot code and SolversLib's command system, providing essential functionalities:

**Shared State**: The `isDisabled` static variable is a central flag accessible throughout your code, indicating robot state (enabled/disabled). The `disable()` and `enable()` methods allow external control over the robot's state during transitions between autonomous and teleop periods.

**Command Control Center**: Methods like `reset()`, `run()`, `schedule()`, and `register()` grant access to the `CommandScheduler`, the mastermind behind command execution and resource management. Think of it as the conductor of your robot's actions. Every time you call `register(drive)` in your MyRobot constructor, you're actually calling `CommandScheduler.getInstance().registerSubsystem(drive)` through this abstraction layer.

### **Why This Abstraction Matters**

Without Robot.java, every place in your code that needs to interact with the scheduler would need to call `CommandScheduler.getInstance()` explicitly. That's verbose and couples your code tightly to SolversLib's implementation details. Robot.java provides a cleaner API: instead of `CommandScheduler.getInstance().schedule(new MyCommand())`, you just call `schedule(new MyCommand())` on your robot instance.

**Beyond isDisabled: Expanding State Variables**

The way the `isDisabled` variable controls state demonstrates a pattern you'll use extensively, but it's not the only state you'll track. You're not restricted to booleans or static variables—you'll use custom state variables of all sorts. Here's an example that uses enums to represent various robot conditions:

```java
public class MyRobot extends Robot {
    // ... other code
    
    public enum AprilTagToAlign {
        LEFT, CENTER, RIGHT, NONE
    }
    public AprilTagToAlign targetApril = AprilTagToAlign.NONE;

    public enum IntakeState {
        IDLE, INTAKING, EJECTING, JAMMED
    }
    public IntakeState intakeState = IntakeState.IDLE;

    // Any subsystem or command can check these states:
    // if (robot.targetApril == AprilTagToAlign.CENTER) { ... }
}
```

These instance variables in your MyRobot class become globally accessible state that all your subsystems and commands can reference. This is much cleaner than passing state through constructor parameters or maintaining duplicate state in multiple places.

***

## **CommandOpMode**

Here's the most crucial connection point between the Command pattern and FTC. This file is our translator:

```java
public abstract class CommandOpMode extends LinearOpMode {
    /**
     * Cancels all previous commands
     */
    public void reset() {
        CommandScheduler.getInstance().reset();
    }

    /**
     * Runs the {@link CommandScheduler} instance
     */
    public void run() {
        CommandScheduler.getInstance().run();
    }

    /**
     * Schedules {@link com.seattlesolvers.solverslib.command.Command} objects to the scheduler
     */
    public void schedule(Command... commands) {
        CommandScheduler.getInstance().schedule(commands);
    }

    /**
     * Registers {@link com.seattlesolvers.solverslib.command.Subsystem} objects to the scheduler
     */
    public void register(Subsystem... subsystems) {
        CommandScheduler.getInstance().registerSubsystem(subsystems);
    }

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        initialize();

        waitForStart();

        // run the scheduler
        while (!isStopRequested() && opModeIsActive()) {
            run();
        }
        reset();
    }

    public abstract void initialize();

    public static void disable() {
        Robot.disable();
    }

    public static void enable() {
        Robot.enable();
    }
}
```

### **Lifecycle Integration**

CommandOpMode extends FTC's `LinearOpMode` and overrides the critical `runOpMode()` method. That's the entire magic trick. Let's break down what happens:

1. **Telemetry Setup**: Wraps standard telemetry with `MultipleTelemetry` so data goes to both the Driver Station and FTC Dashboard simultaneously.
2. **Your Initialization**: Calls the abstract `initialize()` method that you implement in your OpMode files (AutoMcAutty, DriveyMcDriverson, etc.). This is where you construct your robot and register subsystems.
3. **Wait for Start**: Standard FTC—waits for the start button press.
4. **The Magic Loop**:

```java
while (!isStopRequested() && opModeIsActive()) {
    run();
}
```

That single `run()` call is doing all the work. It calls `CommandScheduler.getInstance().run()`, which:

* Calls `periodic()` on every registered subsystem (which is where `follower.update()` happens!)
* Executes the `execute()` method of all active commands
* Checks `isFinished()` on all active commands
* Calls `end()` on commands that just finished
* Starts any newly scheduled commands
* Handles command interruptions based on subsystem requirements

This means you never manually call `periodic()`, `execute()`, `isFinished()`, or `end()` in your own code. The scheduler handles all of it automatically, every loop, in the correct order. This is why your command's `execute()` method can be empty when using Pedro Pathing—the subsystem's `periodic()` is already updating the follower.

5. **Cleanup**: After the OpMode stops (match ends or emergency stop), `reset()` clears all commands and subsystems, preparing for the next match.

**Why This Matters**

Without CommandOpMode, you'd need to manually:

* Track which commands are running
* Call their execute methods
* Check if they're finished
* Handle interruptions when subsystems conflict
* Update all subsystems every loop
* Manage command lifecycle from initialize through end

CommandOpMode does all of this with that single `run()` call. This is why the command-based pattern is so powerful—the infrastructure handles the orchestration, and you just write simple commands that focus on specific tasks.

### **What You Don't See**

Here's what's happening inside that `run()` call during a typical loop:

1. Subsystem periodic updates:
   * `drive.periodic()` → calls `follower.update()` → updates pose, calculates motor powers
   * `arm.periodic()` → updates encoder readings, checks limit switches
2. Command execution:
   * `DriveCommand.execute()` → passes joystick values to follower
   * `ArmMoveTo.execute()` → maybe empty, motor control happens in subsystem
3. Command lifecycle checks:
   * Checks if `ArmMoveTo.isFinished()` returns true
   * If so, calls `ArmMoveTo.end(false)` to clean up
   * Resumes `arm`'s default command if one exists
4. Command scheduling:
   * Checks if any new commands were scheduled via `schedule()`
   * If a new command requires a subsystem already in use, interrupts the current command
   * Calls `end(true)` on the interrupted command
   * Starts the new command's `initialize()` method

All of this happens automatically, every 20 milliseconds (or however fast your loop runs), without you writing any orchestration code.

***

## **The Reset Method**

The `reset()` method within both Robot and CommandOpMode plays a crucial role in managing commands during various FTC gameplay scenarios. Here are some practical examples of when you might utilize it:

**1. Autonomous Period Transitions:**

**Switching Strategies**: During autonomous, imagine your robot first performs a pre-determined path using pre-scheduled commands. If your vision system detects the prop in an unexpected position, you could call `reset()` to clear all running commands and initiate a new command sequence for the alternate path.

**Recovering from Errors**: If a sensor reading indicates your robot is hopelessly lost (pose suddenly jumps to negative coordinates), calling `reset()` can clear the current path-following command and allow you to initiate a recovery sequence—perhaps using AprilTags to relocalize or simply driving to a safe parking position.

**2. Teleop Period:**

**Emergency Stop Button**: Consider a button press on your gamepad that triggers `reset()`. This could be used to:

* Cancel an ongoing automated scoring sequence if the driver sees danger
* Immediately stop all subsystems and return to manual control
* Clear a stuck command that's preventing the robot from responding

**Mode Switches**: If you have different driving modes (e.g., slow mode for precision, fast mode for traversal), you might use `reset()` when switching modes to ensure no lingering commands interfere with the new control scheme.

**3. Competition Edge Cases:**

**Post-Autonomous Cleanup**: Although CommandOpMode calls `reset()` automatically when the OpMode stops, you might manually call it at the end of your autonomous `initAuto()` method to ensure a clean slate before the teleop period begins. This guarantees no autonomous commands are still running when drivers take control.

**Penalty Recovery**: If your robot receives a penalty and needs to return to a specific position, you could bind `reset()` to a specific button combination that cancels current actions and schedules a "return to safe position" command sequence.

**4. Testing and Debugging:**

**Isolating Command Behavior**: During testing, you might add a reset button that clears everything between test runs. This lets you repeatedly test a specific command without restarting the entire OpMode.

**Reproducing Issues**: If your robot exhibits unexpected behavior, you can add strategic `reset()` calls in your code to determine if the issue is caused by command state persisting between actions. If the problem disappears after a reset, you know a command isn't cleaning up properly in its `end()` method.

**A Word of Caution**

While `reset()` is powerful, it's also somewhat nuclear—it cancels _everything_. All running commands stop immediately, calling their `end(true)` methods. All subsystems lose their default commands temporarily. Use it when you need a clean slate, but understand that it's a hard reset, not a gentle transition. For normal operation, letting commands finish naturally or be interrupted by higher-priority commands is usually better than manually resetting the entire scheduler.
