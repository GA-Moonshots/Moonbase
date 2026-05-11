Our team uses Java to program our robots. Most of the foundational skills — classes, objects, loops, conditionals — are covered in AP Computer Science. If you've taken APCS, you already have the background you need to start contributing.

{% embed url="https://github.com/GA-Moonshots/Moonbase" %}
{% endembed %}

# What's In This Section

**Command Pattern** — The design philosophy behind all of our robot code. Start here. It explains why we structure code the way we do before showing you how.

**Example Command** — A walkthrough of the four lifecycle methods every command implements: constructor, initialize, execute, isFinished, and end.

**Subsystem** — How we group hardware (motors, servos, sensors) into logical units that commands can claim and control.

**Running Your Code** — How OpModes kick off the robot, how buttons get bound to commands, and how autonomous routines are sequenced.

**Pedro's Follower** — Our autonomous navigation system. Covers the coordinate system, path building, the Pinpoint odometry computer, tuning, and visualization via Panels Dashboard.

**Under the Hood** — For curious programmers only. Explains how Robot.java and CommandOpMode connect FTC's LinearOpMode to our command scheduler.

# Setup

## Android Studio

Android Studio is the IDE we use to write, build, and deploy robot code to the Control Hub. Install the version recommended by FIRST — the FTC SDK targets a specific SDK level, so newer Android Studio versions occasionally cause build issues.

{% hint style="info" %}
Download at [developer.android.com/studio](https://developer.android.com/studio). After installing, open the project by pointing Android Studio at the repo root folder. Let Gradle sync fully before trying to build. If Gradle fails on first sync, check that your JDK version matches the SDK requirements.
{% endhint %}

## GitHub Desktop

GitHub Desktop is how we sync code between the team laptop and our GitHub repository. You don't need to know Git commands — the app handles commits, pushes, and pulls visually.

{% hint style="info" %}
Download at [desktop.github.com](https://desktop.github.com). Sign in with your GitHub account and clone the Moonbase repo.
{% endhint %}

# Our Workflow

We keep version control simple. The team shares a single laptop for most coding sessions, which means we rarely have merge conflicts. When you finish a change, open GitHub Desktop, write a short commit message describing what you did, and push to main. Pull before you start coding if anyone else has pushed since your last session.
