# OLD: Turtle Design App

## Class Videos

### 2/1

{% embed url="https://youtu.be/yLzET5nshAY" %}

### 2/7

{% embed url="https://youtu.be/Iy5N13DVpaQ" %}

### 2/7  assignment PT 2

{% embed url="https://youtu.be/FbHQiaPKHJ4" %}

###

### 2/8

{% embed url="https://youtu.be/uTMqkgr35Ok" %}

### 2/15 -- Extending the SuperTurtle APP Assignment

To finish off the superturtle app, we are going to add the following to our program:

Move the printing of the menu options to the helper function, but run it in main.py

Add at least 3 new methods to the SuperTurtle class (whatever you want, but they should be obviously different than the things we wrote together.  <br>









## Building an App

Let's get a little crazy here and build a pretty sophisticated app. We're building a SuperTurtle class with lots of methods. We've built some helper functions to provide random colors or print welcome messages. And we're building an interactive menu structure to run the whole app. But if we put all of this stuff in one file it gets to be a real mess. So let's split everything up like professional software developers.&#x20;

### SuperTurtle file

Let's make a new Python Trinket. Call it **Final Turtle** and save it. Then create a new file called **superturtle.py**. Notice that we don't include capitals or spaces in the names of our module file.&#x20;

![](<../../.gitbook/assets/image (23).png>)

Now let's add our SuperTurtle class to this file. You can start with my copy below and then add in additional methods you may have built in our previous Trinkets.&#x20;

```python
from turtle import Turtle
from random import randint

class SuperTurtle(Turtle):
  """
  Our wrapper class of the turtle.Turtle object
  """
  
  def __init__(self, shape='turtle'):
    """
    This is the turtle's constructor with a default shape of "turtle"
    """
    Turtle.__init__(self)
    self.color(rancolor())
    self.shape(shape)
    self.penup()
    self.speed(9999)
    self.goto_random()
  
  def goto_random(self):
    """
    Simple function that sends a turtle to a random location on
    a 400x400 canvas
    """
    self.goto(randint(-200,200), randint(-200,200))
    
  def triangle(self, length=50):
    """
    Draws an equilateral triangle with a default length of 50
    """
    self.pendown()
    self.forward(length)
    self.left(120)
    self.forward(length)
    self.left(120)
    self.forward(length)

  def square(self, length=120):
    """
    Draws a square with a default length of 120
    """
    self.pendown()
    for x in range(4):
      self.forward(length)
      self.left(90)
    
  def home(self):
    """
    Returns to center position
    """
    self.goto(0,0)

  def star(self):
    """
    Draws a 5-point star with a fixed length of 140
    """
    self.pendown()
    for x in range(5):
      self.forward(140)
      self.left(145)
```

### helper file

We're going to make a file with a bunch of helpful functions. Let's call it **helper.py**

![](<../../.gitbook/assets/image (62).png>)

And let's add this code:

```python
from random import choice

def welcome():
  for x in range(3):
    print("**************")
    if x == 0:
      print("** WELCOME ***")
      
def print_options():
  print("--- MENU ---")
  print("1: Add turtle to gang")
  print("2: Draw a picture")
  print("Any other key will quit")

def rancolor():
  """ This method returns a string from a list of colors available to Turtle's .color() method """
  colors = ["brown", "darkorange", "maroon", "crimson", "navy", "salmon", "tomato", "khaki", "gold", "hotpink", "springgreen", "blue", "cyan", "purple", "green", "red", "pink", "yellow", "teal"]
  return choice(colors)
```

### Wiring them together

![](<../../.gitbook/assets/image (22).png>)

In order to access the `rancolor()` function from **helper.py,** we could import that specific function with `from helper import rancolor`&#x20;

But what'd I'd rather do, is just `import helper` at the top and then change the rancolor line to `helper.rancolor()`

### Main file

Let's add a basic menu to our app:

```python
from superturtle import SuperTurtle
import helper

# our collection of turtles
gang = []

# welcome message
helper.welcome()

# menu loop
while True:
  helper.print_options()
  selection = input("You selection: ")
  # analyize the selection
  if "one" in selection or "1" in selection:
    gang.append(SuperTurtle())
  elif "two" in selection or "2" in selection:
    # loop through all our turtles
    for t in gang:
      t.star()
  # quit if no option is recognized 
  else:
    break
```

### Now go play!

Try changing this project. Add options and features. I'm here to help, too.&#x20;

#### What if I want the help file to command my turtles?

The gang of turtles is in the main file. If we want to use it in the helper.py file, we need to pass it as a parameter. For example, I could add this method to my helper file that will make each turtle draw 100 stars:

```python
def super_star(gang):
  for x in range(100):
    for t in gang:
      t.star()
```

And perhaps I want to add this super\_star option to my menu. So I'll add it to my `print_options` and to my `main.py`'s **if** statements:

```python
  elif "three" in selection or "3" in selection:
    helper.super_star(gang) # pass the gang over to helper
```

* **1pt** - separate SuperTurtle class and module
* **1pt** - separate helper module
* **2pts** - multiple adds to menu
* **2pts** - first added method
* **2pts** - second added method
* **2pts** - third added method
* **2pts** - creative display
