# 1: Core Concepts

## Expectations

![](<../.gitbook/assets/giphy (2).gif>)

Slow down. Get your head around these ideas before we lean into the code. Being able to come back and reference these terms as they come up will help you put the whole puzzle together.&#x20;

### Learning Target

* I can describe a full-stack application and the tools required to build one using relevant vocabulary.

## What is a Stack?

A stack is all the systems used to run an app. Usually, several computers are involved but that's not a must. Let's look at the various layers in a stack...&#x20;

{% embed url="https://www.youtube.com/watch?v=cWt12mACjoU" %}



[**Stack**](http://whatis.techtarget.com/definition/Web-stack)**:** Web stack contains an operating system (OS), a programming language, database software and a Web server. A full-stack developer is someone capable of building an app or solution that addresses each of these components.

![](https://lh4.googleusercontent.com/Mh_aLsFOUGUbyQfP_zxIAEW1cDi2vuhjoO5jFw0kYfpElqqwyOJ2BsEjZN0nSz94z49LghMPpnkSdenJTVJ1BiR1RKKJzn_kgjXW1xDFCjL93SC1Tfz8N9Qq0k00qojzz-U5ZCnp)

Let's understand the layers by discussing the programming languages used in each.

### Client

[**HTML and CSS**:](https://learn.shayhowe.com/html-css/building-your-first-web-page/) This is what you see on your page. HyperText Markup Language, gives content structure and meaning by defining that content as, for example, headings, paragraphs, or images. CSS, or Cascading Style Sheets, is a presentation language created to style the appearance of content—using, for example, fonts or colors.

![](https://lh4.googleusercontent.com/Phl0n2_SA7Wn4avXgUOyZ-ocUou5ggMaOwMcbxF-pMRlbVuN7XrWoHGOiqRnxm1sRyUMgRDogOO4APIXhMvO5RO0HJTzRrxbwAaeZL4AA-0fcDfJEUFPJLdtaeoTl9VSa_n4regk)

[**JavaScript:**](https://techterms.com/definition/javascript) is a programming language commonly used in web development. It was originally developed by Netscape as a means to add dynamic and interactive elements to websites. It used to be used solely for client-side purposes, but now servers are running apps build using NodeJS. JavaScript has nothing to do with Java.

_**... but how do we get this HTML / CSS / JS on our client computer?**_

[**HTTP Request**](http://rve.org.uk/dumprequest)**:** the message system that runs the World Wide Web. This is how website information is sent over the Internet. There are many different types of HTTP requests, including GET and POST, one asks for information from the server and the other submits information to the server. &#x20;

![](https://lh6.googleusercontent.com/IMHlszyG7WDobX4qCoNMpBeGPdqewj_3bvlqLUs5cm_z7yH3NkTLP2fCr5CCcDvB8QNpyTsmk8JB808XHELFOuQCY6lAg-sxxgxF2N7HFWs1tHB_odNKWlVM_QJH7eeVbDvVzopf)

### Web Server&#x20;

[**Shell/CLI**](http://linuxcommand.org/lc3_lts0010.php)**:** In computing, a shell is a user interface for access to an operating system's services. In general, operating system shells use either a command-line interface (CLI) or graphical user interface (GUI). CLI is used to communicate to the shell in the form of text input.

[**SSL Encryption:**](http://info.ssl.com/article.aspx?id=10241) (Secure Sockets Layer) is the standard security technology for establishing an encrypted link between a web server and a browser. This link ensures that all data passed between the web server and browsers remain private and integral.

[**Operating System Service**](https://www.tutorialspoint.com/operating_system/os_services.htm): An Operating System provides services to both the users and to the programs. It provides programs an environment to execute. It provides users the services to execute the programs in a convenient manner.

### Web Application

Okay, we've got a web server receiving signals from our client's computer. Now comes the part where our server runs the app we've built and gives us cool information.&#x20;

[**Python**](https://techterms.com/definition/python): Python is a high-level programming language designed to be easy to read and simple to implement. It is open source, which means it is free to use, even for commercial applications. Python can run on Mac, Windows, and Unix systems and has also been ported to Java and .NET virtual machines. Most Python distributions rely on CPython, which means your code will boil down and run using the C language. Flask is a Python library.

[**Framework**:](https://en.wikipedia.org/wiki/Web_framework)  Framework is described as “an abstraction, in which software providing generic functionality can be selectively changed by additional user-written code, thus providing application-specific software, is a software framework that is designed to support the development of web applications including web services, web resources, and web APIs. Web frameworks provide a standard way to build and deploy web applications. Web frameworks aim to automate the overhead associated with common activities performed in web development. For example, many web frameworks provide libraries for database access, templating frameworks, and session management, and they often promote code reuse.   (additional [link](https://www.merixstudio.com/blog/framework-vs-library-differences-web-development/))

### Database

[**SQL:**](https://www.webopedia.com/TERM/S/SQL.html) Structured Query Language, used to request information from a database. SQL has been the favorite query language for database management systems running on [minicomputers](https://www.webopedia.com/TERM/M/minicomputer.html) and [mainframes](https://www.webopedia.com/TERM/M/mainframe.html). Increasingly, however, SQL is being [supported](https://www.webopedia.com/TERM/S/support.html) by PC database systems because it supports [distributed databases](https://www.webopedia.com/TERM/D/distributed_database.html) (databases that are spread out over several [computer systems](https://www.webopedia.com/TERM/C/computer_system.html)). This enables several [users](https://www.webopedia.com/TERM/U/user.html) on a [local-area network](https://www.webopedia.com/TERM/L/local_area_network_LAN.html) to [access](https://www.webopedia.com/TERM/A/access.html) the same database simultaneously.   &#x20;

[**PostgreSQL**](https://en.wikipedia.org/wiki/PostgreSQL)**:** is an [object-relational database management system](https://en.wikipedia.org/wiki/Object-relational_database_management_system) (ORDBMS).  As a database server, its primary functions are to store data securely and return that data in response to requests from other software applications.

![](https://lh5.googleusercontent.com/A3EZN8aomCnpSAabJogUDJencuueYcJYpBzTSoFhXcKWl6Ar2GUJVzfpsKbG3_9eRYIEIMOA_XTYPwoA5oaNAoYJ7Yc_azr5G8ExxGLUgNCUTiQLEcQxWF4cNxpD-CTLyXEmFO8Y)

## More Python Vocab

{% embed url="https://www.youtube.com/watch?v=zynqI2ythak" %}

[**Interpreter**](https://en.wikipedia.org/wiki/Interpreter_\(computing\)): a computer program that directly executes, i.e. performs, instructions written in a programming or scripting language, without requiring them previously to have been compiled into a machine language program.

[**Flask Application Context**](http://flask.pocoo.org/docs/0.12/appcontext/)**:** One of the design ideas behind Flask is that there are two different “states” in which code is executed. The application setup state in which the application implicitly is on the module level and request handling.  &#x20;

Imagine two people watching a movie at the same time. Because those two people have different life experiences, they will interpret the movie in a different way. When your app is running, it loads variables and libraries that gives it a particular “experience.” Our application context refers to the references at play.

[**Module**](https://softwareengineering.stackexchange.com/questions/167859/what-actually-is-a-module-in-software-engineering)**:** encapsulates code and data to implement a particular functionality,  has an interface that lets clients to access its functionality in an uniform manner,  is easily pluggable with another module that expects its interface, is usually packaged in a single unit so that it can be easily deployed.

A module is a loose term. Python uses the term to describe a single file, sometimes just one part of a larger library of tools that you can import and use within your app. If you put a single line of code in a file, you’ve built a module.

[**Virtual Environment**](https://www.pcmag.com/encyclopedia/term/58705/virtual-environment)**:** A folder where a copy of all dependencies is kept separate from the system installation. This allows you to work on several apps without having to manually toggle which version of the language interpreter your system is using. It's a safe and responsible way to develop your apps.

Virtual environment does not include “your app” this is separate. And you may have meant modules, not models. The model refers to the objects and database tables we’ll use in our app.  Meanwhile, the libraries or modules that our app depends on in order to run will be installed in our virtual environment.&#x20;

[**Libraries**](https://www.merixstudio.com/blog/framework-vs-library-differences-web-development/)**:** “a collection of implementations of behavior, written in terms of a language, that has a well-defined interface by which the behavior is invoked.”

![](https://lh6.googleusercontent.com/RBBN4KzEzfaIG22fD-DSy85NJKixA4MLuT4lX_msvxDKRdfQQdZSLBTN3nU0Czn--SLD_1GzJtUOnmKuXA9Ke0kQsv0_psjGqwbTqXIY2AvrC1-TpxqOaCZQ3cGZIZNMzL5N4r9s)

[**Dependencies**](https://askubuntu.com/questions/361741/what-are-dependencies)**:** A dependency is a file that something you are trying to install requires. These are the required libraries and modules for your app to function.

An efficient programmer keeps their dependencies in a virtualenv, but it’s not required to do so. You can install them globally if you’d like, but other apps running on that machine might complicate things. There are other ways to manage dependencies too.

[**Git Version Control**](https://git-scm.com/book/en/v2/Getting-Started-About-Version-Control)**:** is a system for tracking changes in computer files and coordinating work on those files among multiple people. Version control is a system that records changes to a file or set of files over time so that you can recall specific versions later.

Throughout the course of the semester how often will we be referring back to older versions of our app?

[**Object**](https://docs.python.org/3/tutorial/classes.html#tut-object)**:** An item in memory with a variable name, location reference, and the instantiated code provided by some class definition. Objects have individuality, and multiple names (in multiple scopes) can be bound to the same object. This is known as aliasing in other languages. This is usually not appreciated on a first glance at Python, and can be safely ignored when dealing with immutable basic types (numbers, strings, tuples).

[**Method (Python)**:](https://docs.python.org/2/tutorial/classes.html) A method is a function that “belongs to” an object. (In Python, the term method is not unique to class instances: other object types can have methods as well. For example, list objects have methods called append, insert, remove, sort, and so on. However, in the following discussion, we’ll use the term method exclusively to mean methods of class instance objects, unless explicitly stated otherwise.) &#x20;

![This method is not named according to PEP which recommends the use of snake\_case](https://lh4.googleusercontent.com/pXuubo-BP2tCS6pMqPV1F5cpkUOX4-Ny4Pqqc_MJODfTu39z9saN8GbxjFLujuxL5FQQKEn8WYgDjIZ-Rk1QGZPGKgtRNDLUeLa5GxizKtQJZVV6RKCqgsed5ataZezGXm1Fk16n)

[**Parameter:**](https://docs.python.org/2/glossary.html) In almost all programming languages, functions accept variables that are used in their code, (i.e. f(x) = x + 1). The parameter is simply the variables that are referenced within a method or behavior. This can also be referred to as an argument. A Python module which can contain submodules or recursively, subpackages. Technically, a package is a Python module with an `__path__` attribute. parameter. A named entity in a function (or method) definition that specifies an argument (or in some cases, arguments) that the function can accept.

[**Constructor (init method)**](https://en.wikipedia.org/wiki/Constructor_\(object-oriented_programming\))**:** In class-based object-oriented programming, a constructor (abbreviation: ctor) is a special type of subroutine called to create an object. It prepares the new object for use, often accepting arguments that the constructor uses to set required member variables.

[**Inheritance**](https://www.webopedia.com/TERM/I/inheritance.html)**:** Inheritance is a feature that represents the "is a" relationship between different classes. Inheritance allows a class to have the same behavior as another class and extend or tailor that behavior to provide special action for specific needs.

[**DocString Comment**](https://en.wikipedia.org/wiki/Docstring)**:** A string literal specified in source code that is used, like a comment, to document a specific segment of code.

In-line comments are written with a # and add extra notes around our app. ‘’’DocString’’’ comments provide more detailed explanations right underneath class and function headers.

###
