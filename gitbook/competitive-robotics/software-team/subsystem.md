---
description: The composition of hardware components and their basic helper functions
---

# Subsystem

### **What are subsystems in SolversLib?**

A SolversLib Subsystem is like a part of your robot that controls specific tasks, such as driving, lifting an arm, or shooting a game element. Each subsystem has its own job and knows how to control the motors, sensors, or other components related to that job. By breaking the robot into subsystems, your code becomes easier to manage and update because each part is responsible for its own actions. Think of it like different departments in a company—each one has a clear purpose, making the whole robot work smoothly together.

### **Why do we use this Subsystem design?**

The advantage of using subsystems in SolversLib is that it allows for smooth control of multiple parts of your robot at once. Organizing your code this way allows you to run several subsystems without everything happening in one big block. This means one thread can manage multiple subsystems simultaneously without commands blocking each other. For example, the robot can move and operate its arm, and if a new command interrupts a current action—like stopping the drive to shoot a game element—it can smoothly switch tasks without delays or confusion.

## **Example Subsystem**

```java
package org.firstinspires.ftc.teamcode.subsystems;

// EXAMPLE SUBSYSTEM
public class Arm extends SubsystemBase {
    // SUBSYSTEM ASSETS
    private final MyRobot robot;
    private final Servo wristServo, openServo, rollServo;
    public final MotorEx motor;
    // STATE VARIABLES
    private double wristAng = HardwareNames.WRIST_MIN;
    private double rollPos = HardwareNames.ROLL_MAX;
    private boolean isOpen = false;
    private int offset = 0;

    public Arm(MyRobot robot) {
        this.robot = robot;
        HardwareMap hardwareMap = robot.opMode.hardwareMap;

        // shoulder motor
        this.motor = new MotorEx(hardwareMap, HardwareNames.ARM_MOTOR_NAME);
        motor.setRunMode(Motor.RunMode.PositionControl);
        motor.setInverted(true);
        motor.setPositionCoefficient(HardwareNames.ARM_MOTOR_kP);
        motor.setPositionTolerance(HardwareNames.ARM_MOTOR_TOLERANCE);

        // servos
        wristServo = hardwareMap.get(Servo.class, HardwareNames.WRIST_SERVO_NAME);
        openServo = hardwareMap.get(Servo.class, HardwareNames.OPEN_SERVO_NAME);
        rollServo = hardwareMap.get(Servo.class, HardwareNames.ROLL_SERVO_NAME);
        wristServo.setPosition(wristAng);
        openServo.setPosition(HardwareNames.CLAW_CLOSED_POS);
        rollServo.setPosition(rollPos);
    }

    // -- EXAMPLE SERVO COMMANDS --
    public void travelMode() {
        closeClaw();
        wristServo.setPosition(0);
        wristAng = 0;
    }
    public void wristUp() {
        wristAng -= HardwareNames.WRIST_INC;
        wristAng = Range.clip(wristAng, HardwareNames.WRIST_MIN, HardwareNames.WRIST_MAX);
        wristServo.setPosition(wristAng);
    }
    public void wristDown() {
        wristAng += HardwareNames.WRIST_INC;
        wristAng = Range.clip(wristAng, HardwareNames.WRIST_MIN, HardwareNames.WRIST_MAX);
        wristServo.setPosition(wristAng);
    }
    public void openClaw() {
        openServo.setPosition(HardwareNames.CLAW_OPEN_POS);
        isOpen = true;
    }
    public void closeClaw() {
        openServo.setPosition(HardwareNames.CLAW_CLOSED_POS);
        isOpen = false;
    }
    public void toggleOpen() {
        if(isOpen) {
            closeClaw();
        } else {
            openClaw();
        }
    }
    public void toggleRoll() {
        if(rollServo.getPosition() >= .5){
            rollServo.setPosition(HardwareNames.ROLL_MIN);
            rollPos = HardwareNames.ROLL_MIN;
        } else{
            rollServo.setPosition(HardwareNames.ROLL_MAX);
            rollPos = HardwareNames.ROLL_MAX;
        }
    }

    @NonNull
    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "OPR: (%f, %f, %f)",
                openServo.getPosition(), wristServo.getPosition(), rollServo.getPosition());
    }
}
```

**Hardware and Setup:**

The Arm subsystem in our example demonstrates essential aspects of subsystem creation:

* **Hardware References**: Declares member variables like motor, wristServo, etc., linking them to hardware names from a centralized place for these "magic strings," such as HardwareNames.
* **Motor Configuration**: Sets up the motor for precise position control using MotorEx, defining parameters like PID coefficients and tolerances.
* **Servo Initialization**: Retrieves servo objects from the hardwareMap and sets their initial positions.

**Helpful Methods:**

Subsystems often include convenience methods to control hardware directly. The Arm class provides examples:

* `travelMode()`: Sets the arm for driving by closing the claw, adjusting the wrist, and storing the new wrist position.
* `wristUp()`/`wristDown()`: Increment/decrement the wrist servo position within set limits.
* `openClaw()`/`closeClaw()`: Manipulate the claw servo based on an `isOpen` boolean flag.
* `toggleOpen()`/`toggleRoll()`: Implement button-pressable actions using conditional logic.

**State Management:**

Subsystems can maintain internal state using variables like `isOpen` for the claw. The `toString()` method provides a human-readable snapshot of the subsystem's current state (servo positions in this case).

{% hint style="warning" %}
**Where do state variables go?**

There are state variables like `wristAng` and `isOpen` in this subsystem. Does every subsystem get unique state variables? Should we consolidate them into the MyRobot file? These are organizational guidelines that are flexible and will need to be discussed so all programmers know how things ought to be organized.
{% endhint %}

## **Beyond Commands:**

Remember, not every action needs a dedicated Command. Servos like the wrist can be adjusted directly using methods like `wristUp()`. They're instantaneous and aren't a threat to block off other commands. So here's how we can bind these to a button (more details in Running Your Code).

```java
Button dPadUpP2 = new GamepadButton(player2, GamepadKeys.Button.DPAD_UP);
dPadUpP2.whileHeld(new InstantCommand(() -> {
    arm.wristUp();
}));
```

**Next Steps:**

While this explanation covers the basics of subsystems, exploring the provided Robot OpMode will reveal how these subsystems are integrated and controlled within your robot's overall behavior. Remember, effectively utilizing subsystems is vital in writing well-structured and maintainable robot code in SolversLib.
