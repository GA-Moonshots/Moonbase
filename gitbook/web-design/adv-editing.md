# 7: Advanced Editing

## Learning Targets

* I can configure a project folder in a cloud-based file system.&#x20;
* I can customize the elements of an HTML template.&#x20;
* I can publish a completed webpage and share the link with my friends.
* I can take feedback on my website and publish an improved draft.

##

* [https://startbootstrap.com/](https://startbootstrap.com/)
* [https://code.visualstudio.com](https://code.visualstudio.com)
* [Google Fonts](https://fonts.google.com/)​
* ​[AllTheFreeStock](https://allthefreestock.com/)​

**Colors**

* ​[https://coolors.co](https://coolors.co/)​
* ​[https://colorhunt.co/](https://colorhunt.co/)​
* ​[Color wheel](https://color.adobe.com/create/color-wheel/)​
* ​[CSS cheatsheet](http://overapi.com/css) ​
* ​[https://color.hailpixel.com](https://color.hailpixel.com/)

{% embed url="https://www.youtube.com/watch?v=6IQdFuDLasM" %}

### Inspect and Overwrite&#x20;

Let's identify a rule that's being used by our theme and overwrite it.&#x20;

{% embed url="https://youtu.be/HJc_7Xqd2Pc" %}

### New Bootstrap Component

Let's get back to the Bootstrap [documentation](https://getbootstrap.com/docs/4.1/getting-started/introduction/) and shop for a new component to add to our site.&#x20;

{% embed url="http://youtu.be/rsRKLTyegn8?hd=1" %}

## Revisions

We all have to edit our work. We need to collect feedback, review, make a list, and add improvements to our project. The more you repeat this process, the better your end product (as well as first draft on your next project).

### Responsive refinement

![](<../.gitbook/assets/image (33).png>)



![This comes from a great blog post about "breakpoints"](<../.gitbook/assets/image (37).png>)

If you're not frequently having to look things up (and finding W3Schools) you're not trying out enough new things. [@media is one I have to repeatedly look up.](https://www.w3schools.com/cssref/css3_pr_mediaquery.asp)&#x20;

```css
@media only screen and (max-width: 600px) {
  body {
    background-color: lightblue;
  }
}
```

### Fine Tuning

{% embed url="http://youtu.be/3k2HZ7lIamA?hd=1" %}
You may have different things to fix than shown in this video, but I hope it shows the process to follow
{% endembed %}

## Extra Addons

### Load Screen

#### We're going to use jQuery

Our Bootstrap template uses [jQuery](https://jquery.com/), which is a really handy JavaScript library. JavaScript is a programming language that runs right inside your browser. Most of what you do with jQuery can be done in plain-old vanilla JavaScript. We use jQuery to make life a little easier.&#x20;

Add a `<div id="cover"></div>` on the first line of your `<body>`. Then at the very bottom, add the following script:

```markup
  <script>
    $(window).on('load', function(){
      $('#cover').fadeOut(1000);
    });
  </script>
```

And we'll add the following code to our **custom.css**.&#x20;

```css
#cover {
    /* save a file called loading.gif to your img folder */
    background: url("../img/loading.gif") no-repeat scroll center center #FFF;
    position: absolute;
    height: 100%;
    width: 100%;
    z-index: 9999;
}
```

{% embed url="https://loading.io/" %}
Don't have a loading GIF? Use this and give them credit in your code!
{% endembed %}



## Replacing Images

{% embed url="https://www.loom.com/share/91f536ae714e497ca73d4fcc3ce6adee" %}

## JavaScript

{% embed url="https://www.loom.com/share/17d113800e8f4842bcff2745814d0ac1" %}

