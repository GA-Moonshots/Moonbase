# 5: Tour Flaskinni

## Learning Targets

* I can describe the MVT components of Flaskinni.&#x20;
* I can describe the thread's steps as my app starts up.

## Organiz**ation**

Remember, you can help add comments and docstrings to Flaskinni and submit pull requests. Even beginners can help contribute to open source projects in surprisingly substantial ways.&#x20;

### App Factory

![All the pieces of our app get bolted on in a structure called an "application factory"](../.gitbook/assets/Robot-Factory-88676.gif)

We've got a handy little method that instantiates our app, loads the settings, and straps on all its expansion packs. Let's start our tour of the code where Flask is spawned. From "[Demystifying Flask’s Application Factory](https://hackersandslackers.com/flask-application-factory/)":&#x20;

> &#x20;The reason why the _Application Factory_ is so important has to do with something called Flask's **Application Context**. Our app's "context" is what takes the assortment of Python files and modules which make up our app and brings them together so that they see and work with one another.&#x20;

When your app is serving hundreds or thousands of people at a time, your server will run many instances of your app. You may also run your app in different modes, like a text-only shell. An application factory addresses this need by spitting out instances of `app`&#x20;

{% embed url="http://youtu.be/6dnt2mInSVY?hd=1" %}

{% embed url="https://www.youtube.com/watch?v=MbXEQZZSvzk" %}

### Blueprints and MVT

Flaskinni comes with a `main` and an `api` blueprint. That'll affect your use of `url_for`. So if you wanted to make a link to the homepage, it'd be `<a href="{{ url_for('main.index') }}">home</a>`

{% embed url="http://flask.pocoo.org/docs/1.0/blueprints/#blueprints" %}
Flaskinni comes with one blueprint. You'll probably want to add more soon
{% endembed %}

## Template

Now that Flaskinni is running in your environment, local or cloud-based, let's take a tour.

### File structure

The T part of our **MVT** all starts with `base.html`.  [See how much of the documentation you can read before your brain wimps out](http://flask.pocoo.org/docs/0.12/patterns/templateinheritance/)

![](../.gitbook/assets/CR-Reading-3.gif)

![](https://lh6.googleusercontent.com/2n50I2C6mfI3yIRdJZs85UvikBrsnDzFHNEFcJYH044Q105SYB_FOu7kPsFNKBOw3IpdpEQglWCNPU260CaI_0JRJrGB6Clu8lxKalUdSOrllCe0NF0b1gQtWjdVbiorJvaq9VO5)

The purpose of the base template is to give all the pages in your app common assets. This such as fonts, CSS files, nav bar. Every page must link to the base file. It is kept in the `/templates` folder, as `base.html`. The base template is like a picture frame, loading common elements like the nav bar, footer, and your little [favicon](https://en.wikipedia.org/wiki/Favicon). &#x20;

![I can't remember where this picture in my notes came from but it's not my creation.](https://lh5.googleusercontent.com/FZEFqj1fUSldN1AgN5BonX0vMG0SuZjEW_5h1h72zOeNGEjGHBsVWnDvQhDaWBs8kJTRL7z4igwa-duztfyrrApiUFfczXEq-xZGroTaP75ZOTHow_5FPj_wU3Qt26XCQhiZQA8t)

This is the whole parent-child thing. The parent is the skeleton of your page. We named it base.html and it has `<link>`s to our Google Fonts, CSS files, and sets up nav bars and any other element that’s site-wide. It’s great! Pretty much sets up the whole theme of our site.

To put our pages inside this metaphorical picture frame, we use the command, `{% extends "base.html" %}` at the top of every other HTML we put in our templates folder.

The base template extends across all pages, so the website can share HTML code.

{% embed url="https://blog.miguelgrinberg.com/post/the-flask-mega-tutorial-part-ii-templates" %}
If you give this guide up and follow Mr. Grinberg's exclusively I won't judge.
{% endembed %}

### Base's blocks

We’re going to make a new template that inherits from our base.html so you can experiment with this handy tool. Create a new file in your templates folder called about.html. This page will need hardly any information at all because all the setup is done in the parent. All we need to do is pass some HTML into any block.

{% tabs %}
{% tab title="index.html" %}
```markup
{% extends "base.html" %}   

{% block content %}
    {# this is a comment #}
    <div class="row justify-content-md-center">
        <div class="col-md-6">
            <h1>Hi</h1>
        </div>
    </div>

{% endblock %}
```
{% endtab %}
{% endtabs %}

### Sass and JS

{% embed url="https://sass-lang.com/guide" %}

Sass makes CSS easier, even if you have to spend a few minutes here and there refreshing yourself on how to use the Sass tricks and how to compile your Sass down to CSS. I personally use a [VSCode extension](https://marketplace.visualstudio.com/items?itemName=ritwickdey.live-sass) to manage this automatically.&#x20;

Don't want to learn? There is a lazy way out and that's to edit your CSS directly. No judgments.&#x20;

1. Pick out a header and a body font at [fonts.google.com](https://fonts.google.com/)
2. Add them to your collection and get the \<link> we’ll use to embed a connection to Google Fonts.
3. Replace the other \<link> to fonts.google.com that was in your base.html file
4. Add your CSS code to **custom.css**, something like:

{% tabs %}
{% tab title="custom.css" %}
```css
body {
    font-family: 'Roboto Mono', monospace;
}

h1, h2, h3, h4, h5, h6 {
    font-family: 'Rammetto One', cursive;
}
```
{% endtab %}
{% endtabs %}

1. Launch your server
   1. (make sure you’ve got venv activated) `source venv/bin/activate` or on Windows: `source venv/Scripts/Activate`
   2. (use our flask-script to run the server) `flask run`
2. Check out your font changes!

## Views

If you want to see the new template file in action, we’ve got to build a route to that page. As of this writing, there are only two locations for routes in Flaskinni, the master `__init__.py` file and the `views.py` file inside the blog module folder. Since our homepage route is in the first file, we’ll put our about route there, too.

```python
# Created a new route used for rendering the about page template 
# Custom app routes for the end of the website url
@app.route('/about')
@app.route('/about/')
@app.route('/about.html')
# Define app route
def about():
        """Render the template"""
        return render_template('about.html')
```

We later passed a variable to the template. We dropped `<h1> {{ some_variable }} </h1>` in our `about.html` file. Nothing shows up until we change the render\_template call to something like this:

```python
def about():
        """Render the template"""
        return render_template('about.html', some_variable="Hello!")
```

Congratulations! You just passed your first variable to a template.

### url\_for

{% embed url="https://www.youtube.com/watch?v=BMBwahCCaEk" %}

### Flash Notifications

![Flash notification system is a great illustration of the power of templating](<../.gitbook/assets/tenor (1).gif>)

We have cool, color-changing notifications in Flaskinni that rely on Bootstrap classes. So if you want to send a good alert message that something worked, you'd say:\
`flash("Your message has been sent!", "success")`

But if something failed, you'd write:

`flash("Your message was destroyed by mistake. Whoops!", "danger")`

What other Flash notifications are there? How are the flash notifications being built? Let's look at where they come up in the **base.html** file, trace back the macro that builds the flash messages and then see what other options come with Flaskinni.&#x20;

![There we include the \_message.html partial ](<../.gitbook/assets/image (223).png>)

![Those are the options you've got. You can totally add your own.](<../.gitbook/assets/image (212).png>)

### **Sessions**

Cookies!&#x20;

{% embed url="https://www.youtube.com/watch?v=WsoL4MIhJbg" %}

## Models

### Users are special

{% embed url="https://medium.com/@ckraczkowsky/building-a-secure-admin-interface-with-flask-admin-and-flask-security-13ae81faa05" %}

### Example Queries

Let's talk about how this blog post is queried from our database:

```python
@app.route('/article/<slug>')
def read(slug):
    post = Post.query.filter_by(slug=slug).first_or_404()
    return render_template('main/article.html', post=post)
```

### Example Relationships

Check out line #20.&#x20;

```python
class User(db.Model, UserMixin):

    # Our User has six fields: ID, email, password, active, confirmed_at and roles. The roles field represents a
    # many-to-many relationship using the roles_users table. Each user may have no role, one role, or multiple roles.
    id = db.Column(db.Integer, primary_key=True)
    first_name = db.Column(db.String(155))
    last_name = db.Column(db.String(155))
    phone = db.Column(db.String(20)) # let's guess it should be no more than 20
    address = db.Column(db.Text)
    about = db.Column(db.Text)
    image = db.Column(db.String(125))
    email = db.Column(db.String(255), unique=True)
    password = db.Column(db.String(255))
    # TOGGLES
    active = db.Column(db.Boolean(), default=True)
    public_profile = db.Column(db.Boolean(), default=True)
    # DATES
    confirmed_at = db.Column(db.DateTime())
    last_seen = db.Column(db.DateTime(), default=None)
    posts = db.relationship('Post', backref='user', lazy='dynamic')
```

## Extensions



### **Flask-Security**

{% embed url="https://pythonhosted.org/Flask-Security/index.html" %}



### **Flask-Mail**

### **Flask-Migrations**

### **Flask-Assets**

### **Flask-RESTful**

##

