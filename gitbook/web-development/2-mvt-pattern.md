# 2: MVT Pattern

## Expectations

In the last section, you learned there's a lot of layers to a stack. But even within our stack's application layer, there's a lot of complexity. If you don't keep organized, your code quickly gets overwhelming and difficult for other people to understand if you need help. But we find that we can sort-of split our code into three areas, 1) code that stores stuff like user data, 2) "logic" code, or rather the stuff that loads data executes actions like making a sale, and 3) the HTML visuals we see when we interact with the app. This pattern was originally called MVC. We use a slight twist on that called MVT.&#x20;

### Learning Targets

* I can describe the rationale for the MVT design pattern.

## Background

{% embed url="https://www.youtube.com/watch?v=TXubIScyrRE" %}

![(image taken from djangobook.com)](<../.gitbook/assets/image (61).png>)

There are countless ways to organize the files and code used in an application. How does one choose? How do you plan out the parts of your app? There’s big advantages to following best practices, using a pattern that others can recognize. You may hear people references the Gang of Four (GoF) when referring to [their design patterns](https://en.wikipedia.org/wiki/Design_Patterns).  MVC is one such pattern, but for reasons I'm still figuring out, Flask uses a conflicting acronym for remarkably similar pattern.

* **Model**: Database schema or rather, what gets stored in memory. But we won't have to learn a database language like SQL just yet. We'll have a tool called an ORM to convert Python into SQL for us. We'll use that to setup our SQL database tables for each object&#x20;
* **View**: Routes internet traffic. Here's where we connect the `/url/someone/typed/` to the Python thinking that will respond to request for that certain webpage. The view is our controller. It's our application logic--our central brain.&#x20;
* **Template**: HTML with bits of `{{ python }}`. It's not just a regular HTML page. Python will render this so we can respond to different conditions. For example, if a user is logged in we can so the "Logout" button but if not, we show the "Login" button. Careful though, avoid putting too much logic here.&#x20;

[**Model-View-Controller:**](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller) (We will be using a modification of this pattern called MVT)

The model (**M**) is a model or representation of your data. It’s not the actual data, but an interface to the data. The model allows you to pull data from your database without knowing the intricacies of the underlying database. The model usually also provides an abstraction layer with your database, so that you can use the same model with multiple databases.

The view (**V**) is what you see. It’s the presentation layer for your model. On your computer,the view is what you see in the browser for a Web app, or the UI for a desktop app. The view also provides an interface to collect user input. In our MVT pattern, this becomes **T**. So MVT and MVC both use the term "view" but for different parents of the same triangle. This seems needlessly cruel to those studying this stuff.

![](<../.gitbook/assets/giphy (1) (1).gif>)

The controller (**C**) controls the flow of information between the model and the view. It uses programmed logic to decide what information is pulled from the database via the model and what information is passed to the view. It also gets information from the user via the view and implements business logic: either by changing the view, or modifying data through the model, or both. In our MVT pattern, this is the **V** and will be found in our `views.py` file.&#x20;

## Model

### Schema

If I launched `flask shell` I could talk with Python while flask is running `app` and I could ask `app.models` for all the objects we use around our code. Like `app.models.User`. That would be the schema. It's not an actual user that I'm referring to when I say `app.models.User`. That's the definition, the skeleton or the **schema**.  The individual records in the `User` table will used for the instantiated objects in my code.&#x20;

Schema is more than just the list of properties (like `first_name` and such) and functions of an object in your app. It also describes how objects are connected in your database.&#x20;

### Relationships&#x20;

[**ER Diagrams/UML**](https://courses.cs.washington.edu/courses/cse403/11sp/lectures/lecture08-uml1.pdf)**:** Communication diagrams model the interactions between objects in sequence. They describe both the static structure and the dynamic behavior of a system.

[**Association Table**](https://en.wikipedia.org/wiki/Associative_entity)**:** table that associates two other tables in a many-to-many relationship. Let's say you make a website to manage school clubs. Students can be in many different clubs and clubs can have many different students. Somewhere in our database we need to write down a connection between each `Student.id` and each `Club.id`. It's the list of connections between two objects. You want to leave the club? Remove the record that links the two `id`'s.&#x20;

_**There's more:**_ Instead of just connecting two objects, what if we wanted to _qualify_ that relationship? Not only do you want to say "this user belongs to this club," but you also want to mark down that she's the president of the club. So now we have a **Membership** object that can have all sorts of properties that describe your role on the club and what you're allowed to do or not do. Association objects are super cool.

![](https://lh6.googleusercontent.com/IiJeEIkq3xOROUUkWFfJDMvp0Yj-mLAHClVHo49IlMBq79wCONPrldwem2IGSfutE3xDfyeYT7TTihXhaHTuHNkjOgYjk5IvT0xLGB6xdlOXZSKSeYEL1tdAo9-fOkiizT0NRZfJ)

### Queries

[**ORM**](http://en.wikipedia.org/wiki/Object-relational_mapping)**:** a technique that lets you query and manipulate data from a database using an object-oriented paradigm. When talking about ORM, most people are referring to a library that implements the Object-Relational Mapping technique, hence the phrase "an ORM". An ORM library is a completely ordinary library written in your language of choice that encapsulates the code needed to manipulate the data, so you don't use SQL anymore; you interact directly with an object in the same language you're using. For example, here is a completely imaginary case with a pseudo language: You have a book class, you want to retrieve all the books of which the author is "Linus". Manually, you would do something like that:

`book_list = new List(); sql = "SELECT book FROM library WHERE author = 'Linus'"; data = query(sql);  while (row = data.next()) { book = new Book(); book.setAuthor(row.get('author'); book_list.add(book); }`

With an ORM library, it would look like this:

`book_list = BookTable.query(author="Linus");`

The mechanical part is taken care of automatically via the ORM library.

_Questions_

* So object-relational mapping is a programming technique for manipulating data?
  * Yes, it’s the tool (ours is called SQLALchemy) that keeps us from having to write many SQL commands of our own.

[**SQL Alchemy**](http://docs.sqlalchemy.org/en/latest/orm/tutorial.html)**:** a method of associating user-defined Python classes with database tables, and instances of those classes (objects) with rows in their corresponding tables.

[**Migration**](https://en.wikipedia.org/wiki/Data_migration): the process of transferring data between computer storage types or file formats. If we ever want to change our SQL tables to add new information to every record, we’ll need to migrate the data from the old table to the new table. We’ll use a tool called Alembic to do this.



## View

### Routes

[**Route**](https://www.webopedia.com/TERM/R/routing.html)**:** moving data from source to destination. Our Flask controller will take requests to, for example, `yourwebsite/home` and match it to the code that builds the home page

![](https://lh6.googleusercontent.com/yC4XvRScfVHaE3YQrZki3ZbzVsfLn8VFkylZfsCF1hhTqL875OdmkTmRfsYfIT6dY84jxy4ega28UqMsKjUQWWBs-fFumFIDdgvhGX3uH7BabnQPqAa35VMvLdunpxvqHiPEHHeY)

###

[**Flask Session**](https://www.tutorialspoint.com/flask/flask_sessions.htm)**:** Session is the time interval when a client logs into a server and logs out of it. The data, which is needed to be held across this session, is stored in a temporary directory on the server.

### Decorators&#x20;



## Template

[**Render**](https://en.wikipedia.org/wiki/Rendering_\(computer_graphics\))**:** generating HTML code from a mix of Python and HTML, this is done in Flask using Jinja2.

![](<../.gitbook/assets/image (236).png>)

[**Jinja2 Template**](http://jinja.pocoo.org/docs/2.10/templates/)**:** a template engine for the Python programming language. It’s the software that takes the mix of HTML and Python and renders it down to just HTML which is then sent to the user.

### Inheritance&#x20;

There's no reason to write every page used in your app on separate html files. Templating allows us to **extend** or start from a base file that has all the nav bar and footer stuff we need. This is a type of inheritance and it's pretty neat.

### Static Assets

Static assets are your images and CSS files and other stuff that doesn't get run like code and have to get served up to your users. We'll find ways of making this process go fast.&#x20;
