# 7: Theme & Blueprint

## Expectations

During this phase of your project, you can implement a new cosmetic layer. This will help setup the visual tone of your project while buying us some more time while we learn fundamentals. We will also add a new folder inside `app/` that will store your routes

### Learning Targets

* I can implement a new HTML theme into a web app's base template.
* I can create my own blueprint and prepare to expand my database schema.&#x20;

## Implementing a new HTML theme

{% embed url="https://www.loom.com/share/78a400f043d643ce8279ef47e7359b38" %}
A full example of theme implementation
{% endembed %}

We’ve got to build our **base.html.** That one file is the frame to our whole app. It’s a key HTML file in the T of our MVT.  We’ll need to carefully setup the `<head>`’s attached files, the `<body>` and any wrapper/container structure your theme might be using, the `<nav>` bar, the `{% block container %}` where all other pages will be inserted, and your footer.

{% hint style="info" %}
**Pro Tip**: Sometimes it's nice to have more than one **base.html,** if say, you have areas of your site that look dramatically different than others. I sometimes have **marketing\_base.html** for my front page and a **base.html** with all the controls a user has when logged in.&#x20;
{% endhint %}

### Skinning your login page

{% embed url="https://www.youtube.com/watch?v=6MPyGq6k5R4&t=3s&list=PL_JS5ztwk2L8FT_9YccSrbEpN6eEQuN0E&index=16" %}
Note to self: replace this old video. Many items here are outdated&#x20;
{% endembed %}

Our next task is to apply your theme’s design to the built-in login page. Applying a cosmetic, HTML layer to your application is sometimes referred to as “skinning.” The login’s template is provided by our [Flask-Security plugin](https://pythonhosted.org/Flask-Security/) installed in Flaskinni. If you were to delete one of the template files, the app would default to the built-in Flask-Security template. By having the files in our templates folder, we override the built-in look of the pages.

![HTML templating is fun](<../.gitbook/assets/giphy (2) (2).gif>)

Your theme, whether you got it for free or paid for it, will have a pattern to how it organizes the HTML each page (some themes use a series of containers, others `<section>`s, for example). Implementing a theme is about transferring static assets (like images and files) and separating the parts of your HTML code that are common on every page (and putting that in the base.html) and what is unique to the individual page (and putting that in individual template files).

{% embed url="http://youtu.be/Xg7PqlVOEhY?hd=1" %}

### Configuring your notifications

If you haven't learned about flash notices yet for homework, you can [read about them](http://flask.pocoo.org/docs/1.0/patterns/flashing/), or talk about them in class. Assuming you get the idea and see how Flaskinni uses them, let's now rewire the system so it looks good in your HTML template. Maybe we'll use a dismissible Bootstrap alert but maybe want to tie into some fancier features that come with some themes.

![Many HTML themes have notification div boxes like this](<../.gitbook/assets/image (263).png>)

Figure out where all of these messages are listed in their container. Replace the stock objects, (probably will be `li` elements) and that will be generated instead by this line: `{% include "security/_messages.html" %}`

**Note**: When an HTML file is unable to stand up on its own because it's just a partial element, we put an underscore and the start of its filename.

{% tabs %}
{% tab title="_messages.html" %}
```markup
{% with messages = get_flashed_messages(with_categories=true) %}
  {% for category, message in messages %}
    {% if category == "success" %}
    <li class="media">
			<div class="mr-3">
				<a href="#" class="btn bg-success-400 rounded-round btn-icon"><i class="icon-mention"></i></a>
			</div>
			<div class="media-body">
				{{ message }}
				<div class="font-size-sm text-muted mt-1">4 minutes ago</div>
			</div>
		</li>
    {% elif category == "danger" %}
    <li class="media">
			<div class="mr-3">
				<a href="#" class="btn bg-success-400 rounded-round btn-icon"><i class="icon-mention"></i></a>
			</div>
			<div class="media-body">
				{{ message }}
				<div class="font-size-sm text-muted mt-1">4 minutes ago</div>
			</div>
		</li>
    {% elif category == "info" %}
    <li class="media">
			<div class="mr-3">
				<a href="#" class="btn bg-success-400 rounded-round btn-icon"><i class="icon-mention"></i></a>
			</div>
			<div class="media-body">
				{{ message }}
				<div class="font-size-sm text-muted mt-1">4 minutes ago</div>
			</div>
		</li>
    {% elif category == "warning" %}
    <li class="media">
			<div class="mr-3">
				<a href="#" class="btn bg-success-400 rounded-round btn-icon"><i class="icon-mention"></i></a>
			</div>
			<div class="media-body">
				{{ message }}
				<div class="font-size-sm text-muted mt-1">4 minutes ago</div>
			</div>
		</li>
    {% else %}
    <li class="media">
			<div class="mr-3">
				<a href="#" class="btn bg-success-400 rounded-round btn-icon"><i class="icon-mention"></i></a>
			</div>
			<div class="media-body">
				{{ message }}
				<div class="font-size-sm text-muted mt-1">4 minutes ago</div>
			</div>
		</li>
    {% endif %}
  {% endfor %}
{% endwith %}

```
{% endtab %}
{% endtabs %}

### An old demo

Here's a demonstration showing the implementation of Flaskinni's old theme.

{% embed url="https://www.youtube.com/watch?v=hFasXqgj1eE" %}

{% embed url="https://www.youtube.com/watch?v=t95jp0BW2JQ&feature=youtu.be&hd=1" %}

{% embed url="https://www.youtube.com/watch?v=F4F1hcAEs8A&feature=youtu.be&hd=1" %}

{% embed url="https://www.youtube.com/watch?v=z1QWcRxME1g" %}



## Create your blueprint

The different parts of your app should be kept in separate sections or blueprints. It'll make it easier to take one cool blog feature from one site and add it to another project later on. It also keeps your code more organized and easier to work on.&#x20;

{% embed url="https://www.youtube.com/watch?v=K5LBC3hLl8w" %}
PrettyPrinted is an awesome channel and I recommend buying his courses
{% endembed %}

#### Files and Folders

The stuff we have to add to create a new blueprint can be divided up into the **MVT** (which I'll address in reverse). But first, do you know the name of your blueprint? It should be an easy shorthand because you'll be typing it a lot like so: `{{ url_for('why_is_my_blueprint_name_so_long.dashboard') }}`

This example uses a blueprint named "project" which is a pretty lame name. Hopefully you can do better.&#x20;

### Template

Inside the **`templates/`** folder, create a new folder with your blueprint's name. I almost always use a **`_cards.html`** full of macros ready to build cards for all sorts of objects in my app. Might as well add that now, too. For all the new pages you add to your app, you should use use a **blank\_page.html** that you can copy and paste then rename.&#x20;

### Views

Create a new folder within the **`app/`** folder. Like always, spaces and capitals are a bad idea in folder names. Inside that folder create an **`__init__.py`** file. In the file, you'll need to customize this code for a folder name unoriginally titled **`project/`**:

```python
"""
project blueprint constructor - flaskinni/app/project/__init__.py
"""
from flask import Blueprint

project = Blueprint('project', __name__)

from . import views, forms # you can split these into multiple files if they get big
```

### Model

We keep a separate folder for our models. I typically have quite a few files. We'll talk more about building your schema next chapter. For now, know that any new classes you make need to be imported in the `__init__.py` file. That keeps our imports more organized.&#x20;

### Connecting to Flaskinni

When our app factory in **`app/__init__.py`** puts together an instance of our software, it registers our blueprints and imports our models. The app factory is the knot that holds everything together. So the final step is to register our blueprint there. You're now ready to start taking Flaskinni's application logic in a whole new direction. &#x20;

![](<../.gitbook/assets/giphy (4).gif>)

## Making changes to the database

In the next section, we’re about to build [database schema](https://en.wikipedia.org/wiki/Database_schema). You must understand that anytime you tinker with a `models.py` file, (from the /inni folder or elsewhere) then you’ve altered your schema and now your database is likely now out of sync. For example, let’s say you wanted to combine User.first\_name with User.last\_name so there was just one field, User.name. The SQL tables that stored that information can’t adjust to your modified Python code so easily. All of the existing records (i.e. the rows in your tables) will need to now be migrated to a the new set of columns you’ve constructed. That can be really tricky!

### Destroy and rebuild (the wrong way)

The right way to handle this situation is discussed in the next section. Let’s look at the lazy, dangerous way of keeping your database up-to-date through gross destruction. **DANGER**: This will destroy all saved user data. You have a sacred mission to keep this safe and private. This practice is only tolerable at this very early stage of development when we’re learning how to form effective and efficient database schemas. So if you can say to yourself, “who cares? There’s no data here and never has been,” then this might be the right way to update your database.

Check `private.py` for the name of the database being used in our app: BLOG\_DATABASE\_NAME. In this example, it’s called, “db”.

`psql`

`\l`

`drop database db;`

`\l`

`create database db;`

`\q`

### Migrate and upgrade (the right way)

Once your database has been configured and your tables all have columns, making changes is tough. Sure, rows (aka “records”) can be added and deleted without any major problem. But changing the schema so that an object, or table, has new properties (columns in your tables) is much more difficult. Changing the columns in your database tables is a delicate process. Fortunately there are tools like Flask-Migrate to help migrate the data from one version of the table to the next.

#### Why does this work differently?

These commands are different and likely to change in the future. Think about it: we're not using our Flask app. Instead, we're using some tool that detects changes in our database and automates the migration of our data in our old table to our new table. Delicate stuff! Before we'd use Flask-Script as an intermediate. Now we use [Click](https://flask.palletsprojects.com/en/1.1.x/cli/) to access terminal commands that will migrate our database.&#x20;

**If you do it to one, you've got to do it to them all**

Typically, we don’t work on just one database at a time. Most projects have a staging version and a production version and both have their own databases. If you make a change to one, you'll have to migrate the other. That’s why we have Flask-Migrate! Don’t start this process until your teacher has told you your database schema is largely stabilized, (this should happen at the end of the next section of this guide).<br>

_Must read_: [https://flask-migrate.readthedocs.io/en/latest/](https://flask-migrate.readthedocs.io/en/latest/)<br>

**Getting started:**

&#x20;`flask db init` -- this command you'll only do the first time

`flask db migrate`-- this command detects any changes and builds a migration strategy to change your database

`flask db upgrade`-- this command executes the migration
