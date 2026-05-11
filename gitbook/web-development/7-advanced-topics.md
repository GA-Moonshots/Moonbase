# 9: Advanced Topics

## Expectations

From here on out, your project is going to vary from everyone else’s. Once your models are done, you’ve now got to build out each view and template that will serve the workflow of your [MVP](https://en.wikipedia.org/wiki/Minimum_viable_product). Work with your teacher to identify what your MVP needs to do, (we’ll call this your requirements based off of the [SRS stage of the IEEE software lifecycle](https://en.wikipedia.org/wiki/Software_requirements_specification)). Once we work out what exactly you’re building in your module, we’ll populate your Trello backlog with loads of tasks. And as we solve those weird tasks, we’ll start to build the collection of topics below. &#x20;

### Learning Targets

* I can research and hack together an MVP.



## Session

{% embed url="https://youtu.be/eE0eO5EUA34" %}

{% embed url="https://blog.miguelgrinberg.com/post/how-secure-is-the-flask-user-session" %}

## Decorators

{% embed url="https://www.youtube.com/watch?v=Lkm7vG9ESqg&feature=youtu.be&hd=1" %}

[http://flask.pocoo.org/docs/1.0/patterns/viewdecorators/](http://flask.pocoo.org/docs/1.0/patterns/viewdecorators/)

The term decorators in programming refers to a sort of flag or notice put at the start of a method to signal some sort of special treatment. We use @login\_required to trigger Flask-Security’s verification that the user is carrying the encrypted token from our system given to a confirmed user. I would imagine verification of authority and privileges is the most common reason to use a decorator in Flask. We use them [in Java to notify the system we’re overriding a parent’s method](https://www.geeksforgeeks.org/overriding-in-java/). &#x20;

## Forms

The form is our primary method of collecting information from the user. Depending on your application's need, you may need to looking closely into [wtforms](https://wtforms.readthedocs.io/en/stable/). Meanwhile, here are a few recipes that have been requested.

### Drop-down

![In case you forgot what a drop-down looks like?](<../.gitbook/assets/image (240).png>)

When filling out a form, you may want to have a drop-down of a user's friends or some other set of data unique to that user. How can you provide those dynamic options within a form template?&#x20;

The most typically recommended answer is the [QuerySelectField](http://wtforms.simplecodes.com/docs/0.6/ext.html#module-wtforms.ext.sqlalchemy).&#x20;

{% embed url="https://www.youtube.com/watch?v=b9W2ul2VRRc" %}

And what if you want one drop-down to populate the options of another dropdown?

{% embed url="https://www.youtube.com/watch?v=I2dJuNwlIH0" %}

#### Build Options From a View

Just use a `SelectField` with no real options and populate them after you build the form.&#x20;

[https://stackoverflow.com/questions/46921823/dynamic-choices-wtforms-flask-selectfield](https://stackoverflow.com/questions/46921823/dynamic-choices-wtforms-flask-selectfield)

### Placeholders

[https://stackoverflow.com/questions/9749742/python-wtforms-can-i-add-a-placeholder-attribute-when-i-init-a-field](https://stackoverflow.com/questions/9749742/python-wtforms-can-i-add-a-placeholder-attribute-when-i-init-a-field)

Examples:

* [http://screencast-o-matic.com/watch/cFfb2obVJJ](http://screencast-o-matic.com/watch/cFfb2obVJJ)  (placeholders)

### Captcha

{% embed url="https://www.youtube.com/watch?v=VrH0eH4nE-c" %}

## SQLAlchemy and Databases

### backref VS back\_populates

[http://docs.sqlalchemy.org/en/latest/orm/backref.html#relationships-backref](http://docs.sqlalchemy.org/en/latest/orm/backref.html#relationships-backref)

Two back\_populates equals one backref. Using backref declares a two-way relationship. It’s more efficient than dropping a back\_populates on both ends of the relationship but I prefer it because I’ve been confused too many times staring at a class wondering about its relationships unaware that another class has declared a relationship backref in a different file.

### Relationship Loading: Lazy?

[http://docs.sqlalchemy.org/en/latest/orm/loading\_relationships.html](http://docs.sqlalchemy.org/en/latest/orm/loading_relationships.html)Let’s say you want to query the database for a user’s contacts with a built-in relationship such as current\_user.contacts. You can get a list back from the database with just that one command. However, what if you know you’ll always need additional filters on that query. You don’t want the results quite so fast, instead you’d like the SQLAlchemy query not to complete its task but rather to keep the search open and ready for additional filtering or sorting. &#x20;

## Command Line Interface

### flask shell

This is a really useful skill we should go over as it helps us test and figure out where things go wrong.&#x20;

`flask shell`

if python just said it doesn't know what that is, then you need this line:\
`from extensions import db`

`from user.models import User`

`my_users = User.query.all()`

&#x20; look at your user(s):\
`my_users`\
\
`my_users[0].email`

`my_users[0].first_name`

### Talking to Postgres

Let's make sure we can login directly to our database. **You can skip this step** if you're, say, in the midst of a hackathon, the app is working, and you've got to keep moving. In the long-run, it's critical you know how to flex control over your database directly. &#x20;

If you're using Terminal, bash or PowerShell, you should be able to type `psql` to open a command-line version of PostgreSQL. You can also use a friendlier interface like pgAdmin, though I recommend making the effort to explore both.  You'll need to specify your user when accessing psql. Specifying your user can vary a lot depending on how you approach it. Good thing you know how to Google.&#x20;

**Linux:**

`sudo service postgresql start`\
`psql` \
(try listing the current databases) `\l` \
(if you need to quit) `\q`

If you’re the superuser using `sudo -i` then you’ll be on the root account (don’t do that). Postgres has a built-in admin you can log into with `su - postgres` and then `psql`  (you shouldn’t need that but it’s useful).

You can edit accounts' psql access and credentials with stuff like:

`ALTER ROLE ubuntu WITH PASSWORD 'ubuntu';`

You probably won’t need this very often, but it’s important to know if you want to understand how your app works. Launch `psql` and be very careful as you tiptoe through our database: &#x20;

(connect to our database, which in this example is named “db”) `\c db`

(check out the tables in our database) `\dt`

(see what we’ve got in our post table) `SELECT * FROM post;`

If there are no posts, we’re going to create the first one, which will have the ID of zero. If there are posts already, we’re going to create one with the next highest number.

([let’s add a new record](https://www.postgresql.org/docs/9.3/static/sql-insert.html) of a post)

`INSERT INTO post (id, user_id, title, subtitle, body, slug, live) VALUES (0, 0, “Some title”, “Some subtitle”, “Some body”, “someslug”, True);`

(let’s quit psql) `\q`

Launch your app and check it out. [Not pretty, right](https://screencast.com/t/3N5OpF5HMG1)?

(go back into psql and connect to our db then [let’s delete](https://www.postgresql.org/docs/9.3/static/sql-delete.html) what we made)

`DELETE FROM post WHERE id=0;`

(make sure it’s gone) `SELECT * FROM post;`<br>

## Configuring Flask-Mail

[https://pythonhosted.org/Flask-Mail/](https://pythonhosted.org/Flask-Mail/)<br>

This line needs to be in your **settings.py**:

`SECURITY_EMAIL_SENDER = private.ADMIN_EMAIL`

## JavaScript

### Setting Nav Links Active

{% embed url="https://www.youtube.com/watch?v=sIGPwvd-nTk&feature=youtu.be&hd=1" %}



### Confirmation Buttons

Just as we keep a custom.css file, your project should have a custom.js function. Something like this could be very handy. Now you can just add class=”confirmation” attribute to any \<a>\</a> and it’ll have a JS-powered confirmation window.

```
$('.confirmation').on('click', function () { 
return confirm('Are you sure?'); 
});
```

### AJAX: Server Without Reloads

Actions of our app are triggered by routes in our view. If you type in the url of your site, `/index,` your browser sends a GET request to that route to the homepage route in your app. Your browser loads the page. But what if you want to avoid refreshing the page? What if you want to send a message from a modal window and press submit without losing your spot on the current page?

{% embed url="https://www.youtube.com/watch?v=IZWtHsM3Y5A" %}

### Passing Variables from Flask to JavaScript

{% embed url="https://www.youtube.com/watch?v=2PGXU36Yqz0&feature=youtu.be&hd=1" %}

{% embed url="https://stackoverflow.com/questions/37259740/passing-variables-from-flask-to-javascript" %}

### Calling a JavaScript Method on a Button

`<a onclick="hidePaidBills()" href="javascript:void(0);" data-toggle="tooltip" data-placement="top" title="hide paid"><i class="fa fa-eye"></i></a>`

```
// HIDE PAID BILLS
function hidePaidBills(){
    $('.bill-paid').each(function() {
        $(this).hide();
    })
```

## Sending SMS Messages with Twillio

[https://www.twilio.com/docs/sms/quickstart/python](https://www.twilio.com/docs/sms/quickstart/python)

{% embed url="https://www.twilio.com/docs/sms/tutorials/marketing-notifications-python-flask" %}

## Updating Dependencies

We use [VirtualEnv](https://virtualenv.pypa.io/en/stable/) as a sort of bubble that contains our version of Python, Flask, and all the many other libraries used. Each library is likely to see improvements and security fixes. It’s important to keep this codebase updated but it’s an awfully risky process. Updates might change how some of the libraries work and may force you to change or cause new bugs. Best practice is to keep a previous version of your [requirements.txt](https://help.pythonanywhere.com/pages/RebuildingVirtualenvs/) handy and to build thorough [unit tests](http://flask.pocoo.org/docs/0.12/testing/).

Before asking [pip ](https://en.wikipedia.org/wiki/Pip_\(package_manager\))to do a lot of work, you may want it upgrade it first: `pip install --upgrade pip`

Update all libraries (copied from StackOverflow)

`sudo -H python3 -m pip freeze --local | grep -v '^-e' | cut -d = -f 1 | xargs -n1 sudo python3 -m pip install -U`

If you don't want to overdo it with the sudo nonsense: `pip freeze --local | grep -v '^-e' | cut -d = -f 1 | xargs -n1 pip install -U`

Create a requirements document:

`pip freeze > requirements.txt`

Test to make sure the app works. If it doesn't, undo changes tracked by git to get you your previous version of the `requirements.txt`. Reinstall your dependencies based on all the previously recorded versions.&#x20;

## Documentation

Inside [Flaskinni's](https://github.com/dadilettad/flaskinni) `docs/` folder are files produced by [Sphinx](https://www.sphinx-doc.org/en/master/tutorial/index.html).&#x20;

{% embed url="https://www.youtube.com/watch?index=61&list=PL_JS5ztwk2L8FT_9YccSrbEpN6eEQuN0E&v=b4iFyrLQQh4" %}

{% embed url="https://www.youtube.com/watch?index=62&list=PL_JS5ztwk2L8FT_9YccSrbEpN6eEQuN0E&v=DSIuLnoKLd8" %}

{% embed url="https://marketplace.visualstudio.com/items?itemName=njpwerner.autodocstring" %}
Use this VS Code extension to generage autodoc-compatable docstring comments
{% endembed %}

Enable the support of the Google-style docstrings which are much easier to read:

{% embed url="https://www.sphinx-doc.org/en/master/usage/extensions/napoleon.html" %}

## Unit Tests

[http://flask.pocoo.org/docs/0.12/testing/](http://flask.pocoo.org/docs/0.12/testing/)

The most responsible way to build software is to start with unit tests. A script will mimic various types of users as they test every function on your site. The unit test will report when something acts differently than expected. I struggle with keeping to this discipline. A more sophisticated implementation of Flask’s unit test system will be the best sign of my own professional growth in this area.

