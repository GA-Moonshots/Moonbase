# 6: Raspberry Pi / GoPiGo

## Expectations <a href="#expectations" id="expectations"></a>

### Learning Targets <a href="#learning-targets" id="learning-targets"></a>

* I can connect to my Raspberry Pi via SSH.&#x20;
* I can deploy an app to a Raspberry Pi.
* I can compose a higher-ordered algorithm.&#x20;
* I can update code on my Raspberry Pi.&#x20;
* I can make short, descriptive commit messages.

### Assessments <a href="#assessments" id="assessments"></a>

* You will submit a link to your GitHub repo.&#x20;
* You will demonstrate your capacity to control your robot.&#x20;
* You will be asked regular comprehension questions about Raspberry Pis.&#x20;

## Terms

#### **Printed Circuit Board (PCB)**

​

![](<../.gitbook/assets/image (123).png>)

#### **Single Board Computer (SBC)** <a href="#single-board-computer-sbc" id="single-board-computer-sbc"></a>

This is a PCB with all the basic components found in a personal computer (P&#x43;**)**

![](<../.gitbook/assets/image (92).png>)

## Getting Started

### Fork code

1. Visit the [project ](https://github.com/dadiletta/Piggy)and **fork** it&#x20;
2. Open Replit and start a new project from github
3. Use your forked github project. You should now see your code on your editor. Explore `student.py` and `teacher.py`.&#x20;
4. Use SSH (on Mac) or [PuTTy](https://www.chiark.greenend.org.uk/~sgtatham/putty/) (on Windows) to connect to your robot.  Install PuTTy if it is not on your computer.
5. Open putty and enter the ip address of your robot.  Click open.
   * login: pi
   * password: robots1234
6. Remove the `Piggy` folder if it's already there: `rm -rf Piggy`
7. Now we'll clone your project on the robot too with `git clone https://github.com/YOURUSERNAME/Piggy`
8. Change to your project folder: `cd Piggy`
9. Run the app: `python3 student.py`

### Push code to GitHub

Whenyou make changes to your app and want to update the code on your robot, we first need to send the code from our computers to GitHub.  This happens in the version control tab by typing in "What did you change" and hitting **Commit & Push**.

![](../.gitbook/assets/Capture.PNG)



### Pull code on robot

Now we'll remote control our robots using SSH. We'll use Linux commands to pull the updated code down from GitHub.&#x20;

Open putty and enter the ip address of your robot.  Click open.

* login: pi
* password: robots1234

**Note:  You will not see the password when typing.  This is a security feature!**

1. Make sure you're in the right folder: `cd Piggy`
2. Pull your updated code: `git pull origin master`
3. Run your app: `python3 student.py`
4. If it doesn't run, study the error.&#x20;



## Calibrate

We'll need to configure your class variables.&#x20;

{% embed url="https://youtu.be/P5OrzJDF_sg" %}

### Midpoint

If the servo wasn't mounted perfectly, the midpoint won't be `1500`. But that's rarely the case. We should adjust this [magic number](https://en.wikipedia.org/wiki/Magic_number_\(programming\)) to fit your particular robot.&#x20;

### Motor Speeds

Sometimes one motor will perform faster than the other, giving the robot a noticeable veer. We can try to correct for this drift by adjusting the motor power.

## Moving Your Robot

{% embed url="https://youtu.be/lcqhq5v5-6s" %}



## Dance Project

Check out what commands are available from the API that's provided for you. These are the commands you're inheriting.&#x20;

### Higher-Ordered Logic

Your `dance` method should read as close to regular English as possible. The nitty-gritty commands are all kept in the particular methods being called in your `dance` algorithm. So your `dance` method should just call a handful of moves. Within those moves, you'll use the specific motor commands below and get into the nitty-gritty of robot control.&#x20;

* `deg_fwd(angle)` - how many degrees do you want your wheels to rotate? You need to pass the _angle_
* `turn_to_deg(angle)` - rotates to the given angle as calculated by the piggy's gyroscope
* `turn_by_deg(angle)` - turns relative to it's current heading. Positive values rotate right and negative rotate left
* `fwd` - powers on your robot to drive forward. You'll need to use `self.stop()` to power off the motors
* `right` - by default, `self.right()` will give the left motor 90% power and the right 0% which rotates right. You can use kwargs to adjust the power such as `self.right(primary=90, counter=-90)`, which will spin the robot in place
* `left` - same as right but reversed.
* `back` - same as fwd but in reverse.
* `servo` - moves the servo (plugged into servo1) to the given value (use 1000 - 2000)
* `stop` - sets motor power to zero
* `read_distance` - returns the distance from the distance sensor (plugged into I2C port) in millimeters
* `get_heading` - returns the gyroscope's value

## Shutting down the robot

To shut down your robot, type: _**sudo shutdown now**_ in the putty window.



## Basic Movement Methods

* Square
* Dance
* Add safe\_to\_dance() method which checks surroundings and only dances if it has enough space.
* Move to wall and stop
* Move to wall and turn around.  Move forward again and repeat endlessly.
* Move to box and go around it
* Before moving around box, figure out which side of closer.  If you are closer to the left end of the box, go around left.  If you are closer to the right end of the box, go around to the right.

## Intermediate Movement Methods

* Write a move method which scans slightly to the left and right of the robot as it moves forward. &#x20;
* If it senses a wall straight ahead, it goes around to the closest side as above (put that move in it's own method)
* If it senses a wall at the edges of the robot, swerve slightly to miss the wall (this swerve should again be in it's own method).



## Maze Navigation

* Coming soon.
