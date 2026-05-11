# OLD: 5: Raspberry Pi

## Expectations <a href="#expectations" id="expectations"></a>

### Learning Targets <a href="#learning-targets" id="learning-targets"></a>

* I can connect to my Raspberry Pi via SSH.&#x20;
* I can deploy an app to a Raspberry Pi.

### Assessments <a href="#assessments" id="assessments"></a>

* You will submit a link to your GitHub repo.&#x20;
* You will demonstrate your capacity to control your robot.&#x20;
* You will be asked regular comprehension questions about Raspberry Pis.&#x20;

## Terms

#### **Printed Circuit Board (PCB)**

![](<../../../.gitbook/assets/image (266).png>)

#### **Single Board Computer (SBC)**

This is a PCB with all the basic components found in a personal computer (PC)

![](<../../../.gitbook/assets/image (154).png>)

#### **Microcontroller Unit (MCU)**

![](<../../../.gitbook/assets/image (1).png>)

#### Linux

![There are many types of the Linux operating system. We'll use Raspbian](<../../../.gitbook/assets/image (197).png>)

{% embed url="https://www.codecademy.com/learn/learn-the-command-line" %}

## Setup your robot

I'll help you remote control (SSH) your robot.&#x20;

### Check and Update

* [Learn more about updating Raspberry Pi](https://www.raspberrypi.org/documentation/raspbian/updating.md)
* [Learn more about the Command Line Interface](https://www.codecademy.com/learn/learn-the-command-line)&#x20;

`sudo apt-get update`

`sudo apt-get upgrade`

Ready to shut down? `sudo shutdown now`

## Local Python Practice

Now that we've left the fun environment of Trinket.io, let's first build a practice project.&#x20;

{% embed url="https://code.visualstudio.com" %}
Make sure you have VS Code installed
{% endembed %}

{% embed url="https://python.org" %}
Make sure you have the latest Python installed
{% endembed %}

{% embed url="https://gitforwindows.org/" %}
If you're on Windows, you may need to install Git Bash
{% endembed %}

{% embed url="https://github.com/dadiletta/TurtleChase" %}
Fork this repo. You'll need a GitHub account to do so
{% endembed %}

Now let's go to VS Code and clone your forked repo.&#x20;

![](<../../../.gitbook/assets/image (30).png>)

The URL we need is: `https://github.com/YOUR-USERNAME/TurtleChase`

Now let's add some new features together:

1. Add a button to change each player's color
2. Prevent players from traveling off the screen
3. Detect collision of players
4. Wire up some other SuperTurtle methods...?

Now let's commit and push our code.&#x20;

