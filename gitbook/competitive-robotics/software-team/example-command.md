---
description: A function-by-function discussion of a Command's essential components
---

# Example Command

Commands are the heart of SolversLib, promoting clean and organized robot code. Before we get too technical, let's dissect a basic Command example, exploring its critical sections.&#x20;

```java
public class ExampleCommand extends CommandBase {

    private final double timeout;
    private Timing.Timer timer;

    // Constructor
    public ExampleCommand(double timeout) {
        this.timeout = timeout;
        // configure any other instance variables that may be helpful
        
        // which subsystem(s) are required for this command? 
        addRequirements(subsystem);
    }

    // Initialization
    @Override
    public void initialize() {
        timer.start(); // Start the timer
        
        // set any other starting variables required
    }

    // Execution loop
    @Override
    public void execute() {
        // command logic may as simple as keep power on and update sensors
 
    }

    // Check for completion
    @Override
    public boolean isFinished() {
        return timer.elapsedTime() > timeout;
        // add additional conditions to this to see if you're done
    }

    // Post-execution actions
    @Override
    public void end(boolean interrupted) {
        // cut power and clean up
    }
}

```

## **Constructor**

When crafting a Command, the constructor serves as its architect, defining essential elements before the Command's execution:

**1. Establishing Requirements:**

* **Timeout**: Specifies the maximum duration for the Command's execution, ensuring it doesn't run indefinitely. This is a default feature but can be eliminated for commands that run by default (like the DriveCommand).
* **Subsystem Dependencies**: Identifies which robot subsystems (e.g., drive, arm, elevator) are crucial for the Command's operation. This declaration is accomplished through the `addRequirements(subsystem)` call. That subsystem will cancel any other commands when this one is run.
* **Handy References**: Creates shortcuts to frequently used robot components, streamlining code and enhancing readability. Connection to our robot object allows us to check on its state variables.

**2. Pre-Execution Setup:**

The constructor executes during robot setup, preparing the Command before its actual launch. This separation from the `initialize()` method, which runs immediately before execution, allows for careful configuration and resource management.

***

## **Initialize**

The `initialize()` method acts as the Command's launchpad, performing critical setup tasks right before execution:

**1. Setting the Stage:**

* **Timer Activation**: Initializes the timeout timer using `timer.start()` to enforce the Command's duration.
* **Target Calculation**:
  * **Motor Positions**: Calculates encoder target positions for precise motor control.
  * **Pedro Pathing**: Builds path following actions using `FollowPathCommand` or creates custom paths with PathBuilder.

**2. Key Considerations:**

* **Once and Done**: `initialize()` executes only once before the Command's execution loop begins.
* **Preparation Focus**: Its primary responsibility lies in configuring initial values, targets, and action plans, setting the stage for successful execution.

**Essential Reminder:**

Although `initialize()` lays the groundwork, the `execute()` method, covered next, drives the Command's actions and interacts with the robot's physical systems. This non-blocking and concurrent nature can be a new concept for high school programmers.

***

## **Execute**

The `execute()` method is the Command's heart and soul, translating plans into action.

**1. The Execution Loop:**

Imagine `execute()` as a conductor, continuously calling the shots throughout the Command's lifespan. It doesn't have a set duration; it will keep getting called until its `isFinished()` method signals completion. However, it's crucial to avoid blocking calls like while loops or `sleep()` that would halt the entire robot program.

**2. Concurrent Commands: Sharing the Stage Gracefully:**

Remember our analogy of multiple Commands as athletes? They might perform simultaneously, especially if they don't require the same resources. `execute()` needs to consider this possibility, ensuring smooth cooperation and avoiding conflicts.

**3. Key Principles:**

* **Non-Blocking**: Steer clear of blocking calls that would freeze the robot program. Instead, favor short, focused actions within `execute()` and rely on `isFinished()` for termination.
* **Concurrent-Friendly**: Design your `execute()` logic to function correctly even when other Commands are running concurrently, as long as they don't interfere with the required resources.

**4. Understanding the Challenge:**

This non-blocking and concurrent nature can be a new concept for high school programmers. Here's an analogy to help:

Imagine juggling. Each Command is a ball you keep in the air. You can't hold onto any ball for too long (blocking call), or you'll drop the others (other Commands needing resources). But by quickly tossing and catching each ball (short actions), you can keep them all going simultaneously (concurrently).

**Remember:**

`execute()` is the action stage, but design it wisely to avoid blocking and ensure smooth cooperation with other concurrent Commands. It's like the insides of the while loops we're avoiding because they're blocking (and the condition of those avoided while loops is the `isFinished()`). Embrace non-blocking techniques and keep your `execute()` methods focused and efficient for optimal robot performance.

***

## **isFinished + end**

The final act of our Command play unfolds in these two methods:

**isFinished(): The Curtain Call Condition**

Think of `isFinished()` as the stage manager, waiting for the right moment to signal the end of the Command's performance. Similar to the condition in a while loop, it continuously evaluates whether the Command has achieved its goal. If `isFinished()` returns true, the curtain falls, and the Command gracefully exits.

**Key Considerations:**

* **Exit Criteria**: Define clear conditions for completion within `isFinished()`. Common criteria include:
  * Time elapsing (using the timer started in `initialize()`)
  * Sensor readings reaching desired values
  * External signals (e.g., button press)
* **Concurrent Awareness**: Remember other Commands might be waiting in the wings. Ensure your `isFinished()` logic doesn't hold onto resources unnecessarily, preventing other Commands from running.

```java
@Override
public boolean isFinished() {
    return timer.elapsedTime() > timeout
        || robot.sensor.getValue() > targetValue;
}
```

**end(): Taking a Bow (Even if Interrupted)**

The `end()` method serves as the post-performance cleanup crew, ensuring everything is left tidy after the Command finishes, whether naturally or interrupted by another Command.

**Key Considerations:**

* **Power Down**: Stop motors, reset servos, and release any acquired resources.
* **State Management**: If using an ENUM to track subsystem state, ensure it reflects the actual final state, especially if interrupted. Update the ENUM variable accordingly in `end()`.
* **Cleanup Thoroughness**: Leave the robot and subsystems ready for the next Command without lingering effects.

```java
@Override
public void end(boolean interrupted) {
    robot.motor.stopMotor();
    robot.servo.setPosition(0.0);
    if (interrupted) {
        robot.subsystemState = STATE_UNFINISHED;
    }
}
```
