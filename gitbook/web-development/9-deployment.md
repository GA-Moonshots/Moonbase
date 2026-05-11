---
description: >-
  Publish your Flask app to a web server. This is a challenging process often
  with unique challenges for every app. We'll get there.
---

# 10: Deployment

{% embed url="https://www.youtube.com/watch?v=kl65a11030A&feature=youtu.be&hd=1" %}

{% embed url="https://www.youtube.com/watch?v=FljqX9juuwc&feature=youtu.be&hd=1" %}

{% embed url="https://www.youtube.com/watch?v=_hsQel6BvEU&feature=youtu.be&hd=1" %}

We’re going to use Digital Ocean to host our app. I also considered Heroku. If we were better with Docker, I’d also consider using Azure or Google Cloud. So don’t be afraid to look around at other options besides the stuff I spell out here. You really can figure this stuff on your own and chart a different path if you're willing to grind it out

## Initial Server Setup

1. Register a domain and point your domain’s to DigitalOcean’s nameservers: [https://www.digitalocean.com/community/tutorials/how-to-point-to-digitalocean-nameservers-from-common-domain-registrars<br>](https://www.digitalocean.com/community/tutorials/how-to-point-to-digitalocean-nameservers-from-common-domain-registrars)[https://www.digitalocean.com/community/tutorials/an-introduction-to-digitalocean-dns](https://www.digitalocean.com/community/tutorials/an-introduction-to-digitalocean-dns)
2. Setup your server’s basic settings: [https://www.digitalocean.com/community/tutorials/initial-server-setup-with-ubuntu-18-04](https://www.digitalocean.com/community/tutorials/initial-server-setup-with-ubuntu-18-04)\
   This includes our ufw firewall: [https://www.digitalocean.com/community/tutorials/how-to-setup-a-firewall-with-ufw-on-an-ubuntu-and-debian-cloud-server](https://www.digitalocean.com/community/tutorials/how-to-setup-a-firewall-with-ufw-on-an-ubuntu-and-debian-cloud-server). Don't forget to disable root ssh login.
   1. Setup python (check on your version of ubuntu). You're not trying to get a demo app online, we're mostly using commands like `sudo apt install python3.7-dev`: [https://www.digitalocean.com/community/tutorials/how-to-install-python-3-and-set-up-a-programming-environment-on-ubuntu-18-04-quickstart](https://www.digitalocean.com/community/tutorials/how-to-install-python-3-and-set-up-a-programming-environment-on-ubuntu-18-04-quickstart)\
      Make sure we have the basics for our database (install, install, install!):\
      [https://stackoverflow.com/questions/28253681/you-need-to-install-postgresql-server-dev-x-y-for-building-a-server-side-extensi](https://stackoverflow.com/questions/28253681/you-need-to-install-postgresql-server-dev-x-y-for-building-a-server-side-extensi)
   2. Once you get your venv activated, don't forget `pip install --upgrade pip wheel`
3. Install and configure nginx, your webserver (remember the [overview from the beginning of class](https://youtu.be/VXe9MRZOyuo?t=5m18s)): [https://www.digitalocean.com/community/tutorials/how-to-install-nginx-on-ubuntu-16-04\
   <br>](https://www.digitalocean.com/community/tutorials/how-to-install-nginx-on-ubuntu-16-04)-\[ at this point you should be able to go to http://your-domain and see a blank, nginx page ]-

## Deploying Your App

Update your git repository and [your requirements.txt](https://docs.google.com/document/d/1goCM1waUqJzR1s_0fq49jf3EEELUjyftqo3SXLQ0XPQ/edit#heading=h.mrucfgaqm1z0) ([video guide](https://screencast-o-matic.com/watch/cFhDIxbAl0)). We’ve got to package your app ready to ship. Calling the deployment of software “shipping” is really cool and people think you’re cool when you say it. So instead of "setting up my app on a remote server" we can say, "shipping a new version." Nice.

Pull your app’s repo and setup your dependencies before serving up your app:  [https://www.digitalocean.com/community/tutorials/how-to-serve-flask-applications-with-uswgi-and-nginx-on-ubuntu-18-04](https://www.digitalocean.com/community/tutorials/how-to-serve-flask-applications-with-uswgi-and-nginx-on-ubuntu-18-04)\
Notes to complement the Digital Ocean guide:

* If admin rights are needed, you may need a command like this:\
  `sudo -H /home/myuser/venv/bin/python -m pip install -r requirements.txt`
*   My **wsgi.py** file:

    `from myapp import app`\
    `if __name__ == "__main__":`

    &#x20;   `app.run(host='0.0.0.0')`
* There are many critical files in this process, but the one that ties them all together is:\
  `sudo nano /etc/systemd/system/flaskinni.service`

#### App deployment is tricky. You'll need some help tracking down problems:

Helpful articles if you’re running into some trouble: [https://stackoverflow.com/questions/39937071/uwsgi-configuration-with-flaskapp](https://stackoverflow.com/questions/39937071/uwsgi-configuration-with-flaskapp)

I use **`sudo cat /var/log/syslog`** frequently to see the errors being reported by the uWSGI service\
and use `sudo less /var/log/nginx/error.log` to see the errors just from nginx (they'll otherwise be mixed in with the syslog)

If everything is working up to this point, your project will load a 500 error. Track down the error and it should be reporting that the connection to the database has failed.&#x20;

### Service

`sudo nano /etc/nginx/sites-available/myproject`

{% code title="/etc/nginx/sites-available/myproject" %}
```python
server {
    server_name flaskinni.org www.flaskinni.org;

    location / {
        include uwsgi_params;
        uwsgi_pass unix:/home/yourname/myproject/flaskinni.sock;
    }

    location /static {
        alias /home/yourname/myproject/app/static;
        expires 2d;
    }

    gzip on;
    gzip_vary on;
    gzip_min_length 10240;
    gzip_proxied expired no-cache no-store private auth;
    gzip_types text/plain text/css text/xml text/javascript application/x-javascript a$
    
}
```
{% endcode %}

`sudo ln -s /etc/nginx/sites-available/myproject /etc/nginx/sites-enabled`

## Database

[Setup **postresql** on your server](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-postgresql-on-ubuntu-16-04) (adjust to the version of Ubuntu you're using)

Postgres starts with a super user with the somewhat unoriginal name of **postgres**. You can use your admin powers to switch to that user by typing `sudo -iu postgres` and now you can use `psql` and  you'll have full control to setup a new user. Read up on _how to add a new user in psql._ The lazy, slightly dangerous way is to `createuser -P -s -e user_name`\
Once you've created your user in psql, update your `.env` file with the user and password.

We've got to test to make sure your database user can log into the database you've created. If your database user also exists in Linux, you can do the same `sudo -iu` trick we did before and then open up `psql`. This command will allow you to be more specific:\
`psql user_name -h 127.0.0.1 -d db_name`

You may end up using `ALTER USER user_name WITH PASSWORD 'new_password';` from the **postgres** user.&#x20;

## Security

Change the passwords and hash codes used in **`.env`** and remember that changes to secret keys or salt could break passwords currently saved in your database. For random strings to use as secret keys for apps, use a line of code like this to make one:

```python
import random, string
''.join(random.SystemRandom().choice(string.ascii_uppercase + string.digits) for _ in range(40))
```

1. Secure your HTTP connection: [https://www.digitalocean.com/community/tutorials/how-to-secure-nginx-with-let-s-encrypt-on-ubuntu-16-04<br>](https://www.digitalocean.com/community/tutorials/how-to-secure-nginx-with-let-s-encrypt-on-ubuntu-16-04)`sudo apt install python-certbot-nginx`\
   `sudo certbot --nginx -d mysite.net`
2. Practice deploying updates. Add, commit, and push from your development environment and pulling over SSH. Make a change to the database and use migrations to update your models without losing data.
   1. Making changes to your application
      1. After building a cool new feature on Cloud9
         1. `git add .`
         2. `git commit -m “fixed the thing”`
         3. `git push origin master`
      2. Then SSH to your server, navigate to your folder and git pull origin master
   2. If you modified any `db.Column` then, you need to track that migration on [your db](https://docs.google.com/document/d/1goCM1waUqJzR1s_0fq49jf3EEELUjyftqo3SXLQ0XPQ/edit#heading=h.5k5z5gusx17c). Reading the [Flask-Migrate documentation](https://flask-migrate.readthedocs.io/en/latest/) is how you can best safeguard your users’ data.
3. Get ready to handle errors: [http://flask.pocoo.org/docs/1.0/errorhandling/](http://flask.pocoo.org/docs/1.0/errorhandling/)
   1. [Sentry.io](https://sentry.io) is an awesome tool to get notifications of any error happening on your server

## Error Reporting

{% embed url="https://unix.stackexchange.com/questions/225401/how-to-see-full-log-from-systemctl-status-service" %}



{% embed url="https://Sentry.io" %}



{% embed url="https://www.youtube.com/watch?v=zVW83QUSDdQ" %}

