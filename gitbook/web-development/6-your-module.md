# 8: Standup Your DB

## Expectations <a href="#docs-internal-guid-f3fa077b-7fff-3172-38a7-05aee11c2356" id="docs-internal-guid-f3fa077b-7fff-3172-38a7-05aee11c2356"></a>

By now you should have created your module or blueprint’s folder in your project’s directory and another in your templates. Now, we'll talk about what we should add into the **models/** folder

### Learning Targets

* I can create an ERD/UML to describe the data that will be stored in my app.
* I can write new relational database objects and successfully stand up my database. &#x20;

## Make Your Copy

Here's a semi-accurate diagram of Flaskinni's starting objects. Make a copy of this document and share it with your team. Compare your UML's and your wireframes, to make sure all the data you need in your app is stored in a logical hierarchy.&#x20;

{% embed url="https://drive.google.com/file/d/17nNPaKDGL-HFiGZwVaeTIoZ9BW2zZk5X/view?usp=sharing" %}
I admit I'm lax with my UML discipline
{% endembed %}

{% embed url="https://www.loom.com/share/77013b8b6e56476992c71b297c3a2fcb" %}



## Example 1: Starsite

{% embed url="http://youtu.be/dgbncDMv4Wg?hd=1" %}

{% embed url="https://www.youtube.com/watch?v=kJU-s4ZQLPw&feature=youtu.be&hd=1" %}





## Example 2: Fipplr

Fipplr allows businesses to log work, manage invoices, and accept payment. This set of tools can be used by freelancers and employers. Fipplr works similarly to many other accounting tools but its simplicity and guided structure protects young entrepreneurs.



![](https://lh5.googleusercontent.com/C63fJHOWsnvebV3UkzDo_Bdzrx8dvEbbeANJFGQMbAUBydA24zPOhrW2waHbGhWimrK5F_OQ0NB2Q-vE9QdiAL7-TVJbifXPAN_C5ZHpbmdHumJKkRY0WIIG-aBHYSqIKolJgXOj)

### Example Class

{% code title="models.py" %}
```python
class Company(db.Model):
    """
    An organization that will serve as the primary contact point between projects
    """
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(80))    
    description = db.Column(db.Text)
    address = db.Column(db.Text)  # where to send the bill?
    website = db.Column(db.String(120)) 
    active = db.Column(db.Boolean())
    
    # ONE-TO-MANY relationships
    invoices_issued = db.relationship('Invoice', back_populates='issuer', foreign_keys="Invoice.issuer_id", lazy='dynamic')
    invoices_received = db.relationship('Invoice', back_populates='recipient', foreign_keys="Invoice.recipient_id", lazy='dynamic')
    
    # MANY-TO-MANY relationships
    users = db.relationship("Company_User", back_populates="company") # association table: connects a user to a company

    def __repr__(self):
        if self.name:
            return self.name
        else:
            return "Company ID#%d" % self.id
```
{% endcode %}

### Query Practice

[https://www.codementor.io/sheena/understanding-sqlalchemy-cheat-sheet-du107lawl](https://www.codementor.io/sheena/understanding-sqlalchemy-cheat-sheet-du107lawl)

Invoice Count:

* `Invoice.query.count()`
* `len(Invoice.query.all())`
  * Count how many invoices have been submitted system-wide

Paid/Unpaid:

* `Invoice.query.filter(Invoice.date_paid != None).all()`
  * Check to see if an invoice has been officially paid. This will be a simple boolean check to see if it has been paid or not. Eventually, you will be able to filter paid and unpaid but to begin, it will just be paid.

Project List:

* `Project.query.join(Project_User).filter(Project_User.user_id==current_user.id).all()`
  * Print the list of all your current working (live) projects. For employers, this list would include the project name and who is assigned to it. For freelancers, it will list all the projects you are assigned to.

Client/Employer List:

* \[Function name]
  * Find the full list of your clients. For employers, each client would be your subcontractors. For freelancers it will list all the clients that have hired you.

Company List:

* `Company.query.join(Company_User).filter(Company_User.user_id==current_user.id).all()`
  * All companies a user is connected to.

Invoiced Work Check:

* Query: \[Function name]
  * Find the full list of work officially invoiced (submitted). If work is not invoiced pull up a separate list. In total there will be two lists, one for the officially invoiced (submitted) work and another for the unofficially invoiced (submitted) work.

##

{% embed url="https://www.youtube.com/watch?v=bV17N9cdgrI&feature=youtu.be&hd=1" %}

{% embed url="https://www.youtube.com/watch?v=NR7OSzGtz-c&feature=youtu.be&hd=1" %}

Star Sight is a collaborative story editor with a growing array of tools to help writers. You can control access to your work, track your characters, and roll dice to help make decisions.  Stories also support rich media so your work can stand out.



![](https://lh4.googleusercontent.com/AG3Gq0MMHRwYLGd5IuVGcSUZdPsrKJbTU891uEdBWcJRTNkTZETvnZYT0vdOm1R4iOicE6gib6nhICdJbmtxD9gFjK-odKufNnhjewvnf8JsJM4bRKach9F7gLjBVGGa5w1eimx0)

### Relationships



Database architecture, the way we build and connect elements in an app, often goes unappreciated by the average user. It’s a complex software engineering challenge that’s unique to every problem being solved. In this example we have some of the following relationships:

* Story\_Chapter
* User\_Story: A user has its own attributes (First and last name, email, and ID). A story also has its own attributes (A series it belongs to, and its own ID). In order to connect these two things, a helper table is created and used by pairing the ID of the user and the story it’s associated with.Its an additional object that connects to the two. It told to, it also gives the user permission to give other users access to a particular story.

### Example Class

{% code title="models.py" %}
```python
class Story(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    title = db.Column(db.String(80))
    subtitle = db.Column(db.String(80))
    description = db.Column(db.Text)
    order_in_series = db.Column(db.Integer)
    image = db.Column(db.String(125))
    slug = db.Column(db.String(125), unique=True)
    publish_date = db.Column(db.DateTime)
    live = db.Column(db.Boolean)
    series_id = db.Column(db.Integer, db.ForeignKey('series.id'))
    
    # relationships
    series = db.relationship("Series", back_populates="stories")
    chapters = db.relationship('Chapter', back_populates='story', lazy='dynamic')
    characters = db.relationship('Character_Story', back_populates='story')
    users = db.relationship("Story_User", back_populates="story")
```
{% endcode %}

### Query Practice

[https://www.codementor.io/sheena/understanding-sqlalchemy-cheat-sheet-du107lawl](https://www.codementor.io/sheena/understanding-sqlalchemy-cheat-sheet-du107lawl)

[https://www.codepowered.com/manuals/SQLAlchemy-0.6.9-doc/html/orm/query.html](https://www.codepowered.com/manuals/SQLAlchemy-0.6.9-doc/html/orm/query.html)

* `Story.query.join(Story_User).filter(User.id==current_user.id).all()`
  * All stories the current user has
* `Chapter.query.join(Character_Story).filter(Character.id==x.id).all()`
  * All chapters that have a certain character
* `Series.query.join(Story).join(Story_User).filter(User.id==1).all()`
  * All series that the current user has
* `User.query.join(Story_User)).all()`
  * All users that have stories linked in the Story\_User join table
* `User.query.except_(User.query.join(Story_User)).all()`
  * All users that don’t have stories

## Example 3: Overhaul Repair

{% embed url="https://www.youtube.com/watch?v=wIQQltPpFn4&feature=youtu.be&hd=1" %}

Overhaul Repair is an app that allows users to sign up to request a mail-in phone repair service. This web app will allow users to create accounts to monitor their device status and also add their devices into the account, allowing users to easily create repair orders from previously added devices. The app will also include an admin only finance management system. &#x20;



![](https://lh6.googleusercontent.com/M15MMCJZAnDNeW2Nhqxk7sVKXpYncJBGyd4Fq1ATZQvRcwWO_DkwT2f3BcYZ99I-S4QIj9TCvs_OOmxnvzsporGG7R9wQgYlG53F8tiVROFmS7bsQS8Jkaf57Yuilqvl615nUQyw)

### Example Class

{% code title="models.py" %}
```python
class Device(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    user_id = db.Column(db.Integer, db.ForeignKey('user.id'))
    name = db.Column(db.String(80))
    model_number = db.Column(db.String(80))
    serial_number = db.Column(db.String(80))
    created_date = db.Column(db.DateTime)
    live = db.Column(db.Boolean)
    
    # relationships
    user = db.relationship("User", back_populates="devices")
    tasks = db.relationship("Task", back_populates="device")

    # return the date in readable English    
    @property
    def created_on(self):
        return humanize.naturaltime(self.created_date)

    def __init__(self, user=None, name=None, model_number=None, serial_number=None, live=True):
            if user:
                self.user_id = user.id

            self.name = name
            self.model_number = model_number
            self.serial_number = serial_number
            self.live = live
            self.created_date = datetime.now()

    def __repr__(self):
        return '<Device %r>' % self.name
```
{% endcode %}

### Query Practice

[https://www.codementor.io/sheena/understanding-sqlalchemy-cheat-sheet-du107lawl](https://www.codementor.io/sheena/understanding-sqlalchemy-cheat-sheet-du107lawl)

[https://stackoverflow.com/questions/4926757/sqlalchemy-query-where-a-column-contains-a-substring](https://stackoverflow.com/questions/4926757/sqlalchemy-query-where-a-column-contains-a-substring)

* Query:  `Task.query.filter(Task.date_completed==None)`
  * Explanation: Query searching through all phones that have unsolved open issues
* Query: `Task.query.order_by(Task.price)`
  * Explanation: Order all tasks by price
* Query:
  * Explanation: All phones that have completed repairs
* Query: `Device.query.filter(device. odel_number.contains(‘A1’))`
  * Explanation:
* Query: `Message.query.filter(Message.user_id.contains('Robert Hayek'))`
  * Explanation: All messages sent by employees

## Example 4: TGene

Tgene is a website that connects the Gilmour Academy molecular genetics lab to others around the world. My app allows the students and lab instructor, Doctor Edward Turk, to write and upload blog posts, pictures, and research about the current work being done in the lab. Through this shared information, collaboration can occur between labs through a contact feature to get teachers and researchers in touch. Collaboration also includes the sale of plasmids from the Gilmour Academy lab to other schools. Tgene is a project that allows Gilmour Academy high school molecular genetics class to share their research, work, and plasmids to other students and researchers across the country.

![](https://lh5.googleusercontent.com/BkP19a_vRe84YOhbvhSriSBkEhoMNWjhgPpyFkufYB8rVEQhxK-2d1hUPJOFiQp_TcYNV25UQKYeCsRSeCRlxDqhtU7YT5yhqD-01boqwXE7UT0D8RbFYw80KzsMXSJgfQD-VoUL)

### Example Class

![](https://lh3.googleusercontent.com/N17_rfxdzIUeQbB52Tgj3_ygdguPJWac6doCEJeQIoeAFeuIhJXbAkumSK-6TpYUebDJnkV5moaWp3MvGRjdNgtRGGdQPgPaiuDJk0h_igoGEyuTFYCbIU8dxwjAOGQwcv1Sqz1V)

Class for my register form that allows me to register as an admin

### Query Practice

* Query: `Moneyplasmid = DBSession.query(Plasmid).filter(plasmid.price)`
  * Explanation: Returns all plasmids that cost money
* Query: `Freeplasmid= DBSession.query(Plasmid).filter(plasmid.price<1)`
  * Explanation: Returns all plasmids that are free/ link to assistance
* Query: `PlasmidOrder=DBSession.query(Plasmid).order_by(Plasmid.price)`
  * Explanation: Query all plasmids ordered by price
* Query: `Plasmidall= DBSession.query(plasmid)`
  * For plasmid in Plasmid:
  * &#x20;  print plasmid.name
  * Explanation: Query all available plasmids for sale (free and \$$)
* `plasmidgene = DBSession.query(Book).filter_by(gene_id=str)`
  * Query that shows all the plasmids bought that include a specific gene  (sort by genes)

{% embed url="https://www.codementor.io/sheena/understanding-sqlalchemy-cheat-sheet-du107lawl" %}

## Example 5: Ennounce

An app to organize announcements for school clubs and teams and to efficiently communicate them to students.  Our platform is a way for groups to connect with users. Members can subscribe to groups to stay up to date on what is going on with a group. Groups can post announcements and members can comments and react to them.



![](https://lh4.googleusercontent.com/nRgoF7X4PBs1vieRP1CXe7ghsrDUWR2xFxv0-4zaUjpcUZSTaey8yKfk2cWtXkLi3Gr6MHqEJxDy_etrx_6rDbr4dGndzZwh_h1rANM0WIxWNTYrPHgijus5KAo_k1FJ4F2OYThM)

### Example Class

{% code title="models.py" %}
```python
class Group(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(80))
    school_id = db.Column(db.Integer, db.ForeignKey('school.id'))
    image = db.Column(db.String(125)) # could be the logo, team photo, whatever..
    live = db.Column(db.Boolean)
    body = db.Column(db.Text)
    meeting_place = db.Column(db.Text)
    meeting_time = db.Column(db.Text)
    
    school = db.relationship('School', back_populates='group')
    users = db.relationship('Membership', back_populates="group")
    announcements = db.relationship('Announcement', back_populates='group')
    # get the whole image path
    @property
    def imgsrc(self):
        if self.image:
            return uploaded_images.url(self.image)
        else:
            return None

    def __init__(self, user=None, name=None, body=None, meeting_place=None, live=True, meeting_time=None):
        self.school_id = user.school_id
        self.name = name 
        self.body = body
        self.meeting_place = meeting_place
        self.meeting_time = meeting_time
        self.live = live

    def __repr__(self):
        if self.name:
            return "Group %s" % self.name
        else:
            return 'Group #%d' % self.id

    def has_member(self, user):
        membership = db.query(Membership).filter_by(user_id=user.id, group_id=self.id).first()
        return bool(membership and "applicant" not in membership.role)
```
{% endcode %}

### Query Practice



[https://www.codementor.io/sheena/understanding-sqlalchemy-cheat-sheet-du107lawl](https://www.codementor.io/sheena/understanding-sqlalchemy-cheat-sheet-du107lawl)

* Lists all the groups a certain user is in
  * `Group.query.join(Membership).filter(Membership.user_id == 2).all()`
* Lists all of the announcement for a particular school base on school id
  * `Announcement.query.filter(Announcement.school_id == 2).all()` &#x20;
* Lists all of the groups at a particular school
  * `Group.query.filter(Group.school_id == 2).all()`
* \# Gives all the announcements that a certain user has made
  * `Announcement.query.filter_by(user_id=2).all()`&#x20;
* \# Gives all of the announcements of a particular group
  * `Announcement.query.filter(Announcement.group_id == 2).all()`
* Membership.query.filter(Membership.user\_id==current\_user.id, Membership.role=='Leader').all()  &#x20;
* \# NOT WORKING---- Gives all of the announcements for a particular user based on their groups
  * `Announcement.query.join(Group.query.join(Membership)).filter(Membership.user_id == 2).all()`
  * `.filter(Membership.user_id == 2).all()`
  * `Group.query.join(Membership).filter(Announcement.query.filter_by(user_id=2).all()`

## Get Started

{% embed url="https://www.youtube.com/watch?v=KjHu-7Pkqec&feature=youtu.be&hd=1" %}

{% embed url="https://www.youtube.com/watch?v=NeopMm56SXY&feature=youtu.be&hd=1" %}

Assuming you’re responsible enough to use some sort of project management tool like Trello, use the UML or ERD you’ve sketched as a reference to build out your todo list. For almost every table you’ve created in your database, you’ll probably need:

* A form built in your forms.py that defines each field a user will fill out
* A .html template where that form can be displayed. This form will be used to create a new object as well as editing an existing object
* A route and function in your views.py for both the new and edit mode of your object form
* A link that will trigger the creation of a new object or editing an existing object  &#x20;

The point here is to think through the absolute minimal displays required to add and manage your data. Then layer in some basic commands next to that table of data.

### Comment Your Code

[https://www.python.org/dev/peps/pep-0257/#what-is-a-docstring](https://www.python.org/dev/peps/pep-0257/#what-is-a-docstring)

```python
def some_function():
    """
    This function doesn't do anything. It's just an example of building-in 
    the explanations that may one day enable your app to grow. 
    """
    some_object.different_function(example_param)
```

### Superadmin

Once your `models.py` file is complete and your app is running, the first route I recommend building is `/superadmin.`&#x20;

We'll build control tables, here's how we load the data for the first one, users.

```python
@app.route('/superadmin')
@roles_required('admin')
def superadmin():
    data = {}
    data['users'] = User.query.all()
    return render_template('my_module/superadmin.html', data=data)
```

```markup
	<tbody>
	    {% for user in data['users'] %}
		<tr>
			<td>{{ user.first_name }}</td>
			<td>{{ user.last_name }}</td>
			<td>{{ user.email }}</td>
			<td>22 Jun 1972</td>
			<td><span class="badge badge-success">Active</span></td>
			<td class="text-center">
				<div class="list-icons">
					<div class="dropdown">
						<a href="#" class="list-icons-item" data-toggle="dropdown">
							<i class="icon-menu9"></i>
						</a>

						<div class="dropdown-menu dropdown-menu-right">
							<a href="{{ url_for('user.edit_view', id=user.id, url=url_for('superadmin')) }}" class="dropdown-item"><i class="icon-pencil"></i> Edit object</a>
						</div>
					</div>
				</div>
			</td>
		</tr>
		{% endfor %}
	</tbody>
```

### How to query?

There's a few ways to trigger a database query. I like to call the object statically so I can explain to students about those terms. You'll more often see `db.session.query(Post)`. \
[More info for the try-hards](https://stackoverflow.com/questions/40020388/flask-sqlalchemy-db-session-querymodel-vs-model-query).&#x20;

{% embed url="http://somup.com/cqh20NnBZD" %}

