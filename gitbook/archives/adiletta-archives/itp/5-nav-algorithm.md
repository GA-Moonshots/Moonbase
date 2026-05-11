# OLD 7: Nav Algorithm

## Expectations <a href="#expectations" id="expectations"></a>

### Learning Targets <a href="#learning-targets" id="learning-targets"></a>

* I can connect to my Raspberry Pi via SSH.&#x20;
* I can deploy an app to a Raspberry Pi.

### Assessments <a href="#assessments" id="assessments"></a>

* You will submit a link to your GitHub repo.&#x20;
* You will demonstrate your capacity to control your robot.&#x20;
* You will be asked regular comprehension questions about Raspberry Pis.&#x20;

{% embed url="https://www.youtube.com/watch?v=NCParRMaGsw" %}

## Open House Demo

During our school's open house days, I setup a few GoPiGo robots that respond when visitors hold their hand in front of the sensors. We'll make our own version of this function. It's fun and an easy way for us to start responding to data from the ultrasonic sensor.&#x20;

### Work the us\_sensor

1. Power-up your robot and connect over SSH
2. Go to your project folder: `cd PnR-Final`
3. Launch Python: `python`&#x20;
4. Import our file: `import student`
5. Instantiate our Piggy:  `p = student.Piggy()`
6. Experiment with the sensor with `p.dist()`

### Setup the method

Let's look at our menu and create a new option for open house. We'll keep checking `dist()` and perform some sort of action when it returns a number too close

## Nav Skills

Before you start on your project to experiment with and grow your own navigational algorithm, let's go over a few helpful tricks.

### Counting Obstacles

Let's imagine a list of about twenty distance measurements: \
`[200, 210, 204, 3, 2, 7, 197, 221, 211, 1, 5, 5, 3, 205, 202]`

How many obstacles do you think were found in this set of distance measurements?&#x20;

Our GoPiGo's keep a list of 180 measurements, `self.scan`,  that corresponds to the servo's angle when taking measurements. Here's the starting code to count obstacles directly in front of the robot:

```python
    def obstacle_count(self):
        """scans and estimates the number of obstacles within sight"""
        self.wide_scan()
        found_something = False
        counter = 0
        for ang, distance in enumerate(self.scan):
            if distance and distance < 200 and not found_something:
                found_something = True
                counter += 1
                print("Object # %d found, I think" % counter)
            if distance and distance > 200 and found_something:
                found_something = False
        print("\n----I SEE %d OBJECTS----\n" % counter)
```

Let's try this out and see if it's accurate. Can you improve its accuracy?&#x20;

Next, let's try to modify the method to get a 360 degree view of all the obstacles around our robot.&#x20;

### Left or Right?

We've already experimented with `self.wide_scan()`. We use that method to fill the `self.scan` list with data. For example, `self.scan[60]` is the distance found at the servo's 60 degree angle.&#x20;

_What's the distance at the midpoint of your robot?_

```python
# create two variables, left_total and right_total
# loop from self.MIDPOINT - 60 to self.MIDPOINT
    # add up the numbers to right_total
# loop from self.MIDPOINT to self.MIDPOINT + 60
    # add up the numbers to left_total
# if right is bigger:
    # turn right
# if left is bigger: 
    # turn left
```

### Turn Until Clear

We've also used the `self.is_clear()` option to tell whether or not the space right in front of the robot is clear. Create a loop that keeps turning the robot until it's clear.&#x20;

## Nav Algorithm

{% embed url="https://www.loom.com/share/a9644ab084c14108bffa6f3cdcc5d1ba?from_recorder=1" %}



![](<../../../.gitbook/assets/image (12).png>)
