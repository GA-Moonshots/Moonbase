# 3: Hello Flask

## Expectations

Where are you going to do your coding? If you try to run your app, what other software is required? How are you going to save or publish your work? Configuring your [IDE](https://en.wikipedia.org/wiki/Integrated_development_environment), [dependencies](https://en.wikipedia.org/wiki/Dependency_hell), and [VCS](https://en.wikipedia.org/wiki/Version_control) is essentially your workspace.

### Learning Targets

* I can create and view a blank Flask app.

Before we get into the structure and mechanics of our code, let’s build the most basic of Flask apps. It’ll help set some context as we then start to learn particular skills. It’s important that you start from scratch as it builds confidence knowing you can start from the ground-up.

{% embed url="https://www.youtube.com/watch?v=pkLZzmSyJ5Q&list=PL_JS5ztwk2L8FT_9YccSrbEpN6eEQuN0E&index=10" %}
This is probably woefully out of date by now.
{% endembed %}

## Hello Flask

Let's look at the most simple possible Flask app.

{% embed url="https://repl.it/@HarrySoper/Create-a-basic-Hello-World-Flask-app#main.py" %}

### Alternative

In case Repl.it isn't cooperating with your browser, here's a simple view of a basic "Hello Flask" app.

{% code title="hello.py" %}
```python
import os  # connects the OS library so we can lookup our own IP address
from flask import Flask   # this connects our framework of tools we'll need

app = Flask(__name__)  # here we create our app in memory. It's maybe the most important line of code

@app.route('/') # if anyone tries to go to the homepage, their request will be routed to the method below
def index():
    return 'Hello from Flask'

if __name__ == '__main__':
    host = os.getenv('IP', '0.0.0.0')
    port = int(os.getenv('PORT', 5000))
    app.debug = True 
    app.run (host=host, port=port)
```
{% endcode %}

## Challenge

### Variables from a route

If I go to `/hello/george`, can you make the screen say, "Hello, George?" How do we pull a variable from the URL on that GET request?&#x20;

### Link to another page

Build another route and switch between two pages.&#x20;

### Basic templating

Use `render_template`

## What's Missing?

If you can understand some of the elements that are missing from this simple example, you’ll have a greater appreciation for the core of our Flask app and the many components that we’re about to study.

### No Templates and Few Routes

Our initial application, hello flask, had one singular route `@app.route('/')` which is very basic. Just a homepage, that’s it. On the other side, “Flaskinni” includes numerous routes so you see blog and account pages just to name a few. Each route in Flaskinni calls templates with method calls like `render_template('index.html')`. These are just as their name suggests, templates or outlines of the final HTML page a user sees. Templates are a big deal (⅓ of our whole MVT structure).

![](https://lh6.googleusercontent.com/NOsNCeYMdR-PKwboR1puTAt0RH8xxdP7nVoYtb2xO0RIGXdM91j4hHTlHE7Yo13qWflO5UPplcnbFHF_XKSoOWsqQqKPX-2Sc0sGoXEQKrKRk3FjcgU0jBCEpJzh4JWHR6Jiv20j)

Want to know the difference between ‘GET’ and ‘POST’? You see them  mentioned as a [kwarg](https://pythontips.com/2013/08/04/args-and-kwargs-in-python-explained/) on line 16 in the picture below? Well, you should know the name Tim Berners Lee. GET and POST are two of the HTTP requests that travel over our network and provide us the Internet. Simply put, GET is a request for a page and POST is when the user is submitting a form. Knowing the types of HTTP requests gets really important if you ever decide to use [Flask-RESTful](https://flask-restful.readthedocs.io/en/latest/) to use this web app to power mobile apps, too. &#x20;

### No Models or Database

In the Hello Flask application, there is no database or model schema being used. There are no objects like user, admin, blog post in the app. Also in the Hello Flask app, we had no database, but in Flaskinni there is a database, and a schema that shows how the database will be set up. Also in Flaskinni there is code that creates database tables and is able to send the data to the database in the format laid out by the schema.

![](https://lh6.googleusercontent.com/oveM9vcq5nLou7SAf7k91U4Ui_H5VhirKlFyzew9TEjSUkWnBw1pUcoDZKjN5KO4s7W7yG6WBgTFpJj-bfSJFw0KikalSL5LpawoCQgG4DX-bl92l5euhOp2XI8Eqr_MilEv6HQV)

### No Interactivity

Our initial Hello Flask application had no interactivity whatsoever as illustrated by the one simple message that is sent to the user.  Our app only responds to GET requests, never a POST request. In other words, the user is only getting static information and is never sending information back to the server or requesting more specific information. For example in the Flaskinni application a user can post a blog post or can request or a certain blog post.  &#x20;

### Few Libraries

Libraries are expansion packs, they're files containing compiled code that allow the app to reference them later in other files. Libraries allow the app  the run faster and have more capabilities. Instead of calling methods over and over while writing the app, the user can call the library file. The linking of libraries allows a file to gain the capabilities of the library module without having to define those methods again.

