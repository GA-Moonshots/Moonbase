# 3: DRY Turtle

## Expectations <a href="#expectations" id="expectations"></a>

### Learning Targets <a href="#learning-targets" id="learning-targets"></a>

* I can implement the basic constructs of programming languages such as variables, conditionals, loops, and flow control.
* I can make a class wrapper that inherits from a library's class.
* I can call a method from a library.&#x20;

### Assessments <a href="#assessments" id="assessments"></a>

* You will be submitting [Trinket.io](https://trinket.io/library/trinkets/create?lang=python) scripts demonstrating the following skills.&#x20;

## Class Videos

**Class 1/24 Turtle drawing assignment:**

{% embed url="https://youtu.be/UTHuE6hexe0" %}



## What is DRY code?

![Avoid having to copy and paste lines of code to repeat a command](<../.gitbook/assets/image (185).png>)

Loops and functions allow skilled programmers to make more efficient code that's easier to maintain.

### Parts of a for loop

A **for** loop has an **iterator** and a **collection** that it _traverses_.&#x20;

```python
# the range command will build a list you can traverse
for x in range(5):
    print(x)
    
# you could also write it using a literal list:
for x in [0, 1, 2, 3, 4]:
    print(x) 
```

### Parts of a function

A **function** has a **definition** that lists any **parameters** and has a **code block** underneath that gets activated when _called_.&#x20;

```python
def magic_spell(target):
    target.sneeze()

# let's make Steve sneeze
magic_spell(steve)
```

In the example above, the `magic_spell` function isn't a part of a **Class**. It's on its own. If that ability was a part of a player in a game, we'd call it a method instead of function.&#x20;

```python
class Player(object):
    
    def magic_spell(self, target):
        target.sneeze()
        
lucy = Player()
steve = Player()
lucy.magic_spell(steve)

# fun fact: you could also write line 8 like so:
Player.magic_spell(lucy, steve)
```

### Code Along

We're going to jump into work with a lot of advanced concepts. This is intentional. New programmers are very often intimidated by code they don't understand. I want you to get used to that early on. Enjoy tinkering with a few lines here and there and see how things change. Get comfortable swimming in the deep end. &#x20;

```python
from turtle import Turtle

class SuperTurtle(Turtle):
  
  def __init__(self, x, y, color='blue', shape='turtle'):
    Turtle.__init__(self) # run the normal Turtle constructor
    self.color(color)
    self.shape(shape)
    self.penup()
    self.goto(x,y)
```

This class (inherits) from the **Turtle** class which is available since we imported the **turtle** library. Instead of writing `from turtle import Turtle` I could have also written just `import turtle` in which case every time I wanted to use the Turtle class, I would have had to specify the library, such as `turtle.Turtle()`

The only thing that our `SuperTurtle` does that the regular Turtle doesn't is the way it gets constructed. When a new Turtle is created or **instantiated**, we initialize or `__init__` with some default properties.&#x20;

**Follow along as we go over a couple of skills. You aren't expected to be able to do this stuff yourself quite yet.**&#x20;

1. Make a loop and create a bunch of turtles
2. Add a new method to the turtle to make it go to a random location and call that method in the constructor
3. Make a list of colors and make each turtle randomly select a color
4. Make an empty list and add each turtle to the collection as it's being instantiated
5. Loop through the turtle collection and modify each

We'll spend some time experimenting with this code, learning by modifying existing code.

## Building Methods

Experimenting with code given to you is fun and can be very helpful, but let's slow things down now and build some basic skills. Your [Trinket.io ](https://trinket.io/library/trinkets/create?lang=python)app should look something like this:

```python
# here's where we imported the Turtle class from the turtle package
from turtle import Turtle
# now from the random package, we imported to helpful functions
from random import randint, choice

def rancolor():
  """ This method returns a string from a list of colors available to Turtle's .color() method """
  colors = ["brown", "darkorange", "maroon", "crimson", "navy", "salmon", "tomato", "khaki", "gold", "hotpink", "springgreen", "blue", "cyan", "purple", "green", "red", "pink", "yellow", "teal"]
  return choice(colors)


class SuperTurtle(Turtle):
  # our own constructor that makes Turtles more convenient
  def __init__(self, shape='turtle'):
    Turtle.__init__(self)
    self.color(rancolor())
    self.shape(shape)
    self.penup()
    self.speed(9999)
    self.goto_random()
  
  def goto_random(self):
    self.goto(randint(-200,200), randint(-200,200))
    
  # HERE'S WHERE WE WILL ADD MORE METHODS
  def triangle(self):
    pass # replace pass with real code

  def square(self):
    pass # replace pass with real code
    
  def star(self):
    pass # replace pass with real code
  

# create a collection for our turtles
gang = []

# loop through a set range of 20 and 
# add a Turtle to our collection during each iteration   
for x in range(20):
  gang.append(SuperTurtle())
  
# loop through my gang and change each one
for x in gang:
  x.shape("triangle")
```

A method or function is a group of commands that can be **called**. If I tell you to please clap, that's me activating or _calling_ the command that's already defined in your head. I may give you additional parameters or **arguments** like, "clap 5 times loudly". In Python that may `input("What's your name?")` but that doesn't save the variable, so we write it as:

`name = input("What's your name?")` written as `joe.clap(5, "loudly")`

#### What's the difference between a function and a method?

They both start with `def` and will execute their pre-programmed commands when called. However, we'll refer to a function as something floating outside of a class and a method as an ability built within an object. For example, a method would be if an instance of the Human class, let's call him Joe, had to sneeze: `joe.sneeze()`. But a function would be an anonymous helper like the`rancolor()` function programmed above that just returns a random string in a list of colors.&#x20;

## Novel Design

Look at the documentation, other student examples, and Google searches to modify open-source code and customize your own design. You can use one or many turtles but the end result has to have multiple colors over a fun design.&#x20;

{% embed url="https://hourofpython.trinket.io/a-visual-introduction-to-python#/welcome/an-hour-of-code" %}

{% embed url="https://docs.python.org/2/library/turtle.html" %}

{% embed url="https://trinket.io/python/b4c0f36ca8" %}

{% embed url="https://trinket.io/python/7199f86bb2" %}

{% embed url="https://trinket.io/library/trinkets/2c9353308c" %}

{% embed url="https://trinket.io/python/a5b0420ded" %}

{% embed url="https://trinket.io/python/a1f1478d32" %}

\
Taking Controls
---------------

Let's make our app more interactive. Just like the `print("message")` function we've been using, there's another one that takes a string input called `input()`

`input("What's your name?")` will work but that doesn't save the user's response anywhere. So let's create a variable that will store the answer in this example:

`name = input("What's your name?")`

### Testing the input

```
if "circle" in user_input:
    tina.circle()
elif "triangle" in user_input:
    tina.triangle()
```

To make sure we are asked the question over again, we'll put the input within a `while True:` loop.

