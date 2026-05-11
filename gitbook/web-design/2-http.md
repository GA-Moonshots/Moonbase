---
description: What's happening under the surface of a web page?
---

# 2: What are Websites?

## Expectations

### Learning Targets

* I can describe how web pages are displayed on my browser using HTTP and HTML.&#x20;
* I can create a basic HTML page.

### Assignments

* You will construct an HTML page from scratch in a guided class activity.&#x20;
* You will complete HTML and CSS courses on codecademy.com

{% embed url="http://youtu.be/TaRNei9dgU4?hd=1" %}

## &#x20;World Wide Web

![Nobel Prize winner Tim Berners-Lee](<../.gitbook/assets/image (227).png>)

### Tim Berners-Lee

If one person had to be named as the creator of the Internet, it might be [Tim Berners-Lee](https://www.w3.org/People/Berners-Lee/) in 1989. More specifically, he created the World Wide Web while working at [CERN](https://home.cern/). It was a way of transferring information over the TCP/IP network talked about in last chapter.&#x20;

#### No more [Microfiche](https://en.wikipedia.org/wiki/Microform)

![Microfiche was text printed on tiny films. Searching through many films was a pain ](<../.gitbook/assets/image (53).png>)

The "Internet" we think of is primarily the contents of our web browser. Trying to find information by tediously scanning film after film was not fun. People like Tim Berners-Lee wanted to **link** text together. So touching one word might connect you to relevant information without having to manually search for hours.

The most important part of a website remains the [hyperlink](https://www.w3schools.com/html/html_links.asp).&#x20;

### HTTP sends HTML

HyperText Transfer Protocol is a set of rules to pass information (like the HTML layout of a web page) over a network. HTML is a markup language. It describes the structure and content of a page. So when you type in an web address like google.com into your browser, you're sending a GET request to the Google server. It responds with an HTML package that your browser renders into a familiar display.

![](<../.gitbook/assets/image (69).png>)

## Structure of HTML

### Tags and Elements

A tag looks like this: \<tag>  \</tag>\
The stuff that's between the opening \<tag> and the closing \</tag> is what's inside that element. The first and most important element in a web page is a hypertext link. If I wanted to make a link that went to Google.com, it would look like this: `<a href="google.com">this is my link</a>`

The term **tag** describes the structure of the \<opening> and \</closing>. The **element** is what type of object is being built by the tag, (an **`a`** is a hyperlink). The **contents** of an element is whatever is between the open and closing tag of an element. The `property="value"` pair that goes inside of an HTML tag is called an **attribute.**

![](<../.gitbook/assets/image (267).png>)

### Page Structure

Every web page has to have a `<!DOCTYPE html>` at the very start to tell your browser that yes, this block of text is HTML and it should render it into a display. The `<html>` element does something very similar. Every page you've ever seen online has been the contents of an HTML tag.&#x20;

{% code title="BlankPage" %}
```markup
<!DOCTYPE html>
<html>
<head>
<title>Page Title</title>
</head>
<body>

<h1>My First Heading</h1>
<p>My first paragraph.</p>

</body>
</html>
```
{% endcode %}

The `<head>` element isn't seen by the user. The contents of the head allow you to connect other resources to the page, such as fonts or CSS.&#x20;

## CSS is HTML's Sidekick

![HTML is Batman and CSS is Robin. CSS doesn't ever work alone--it's there to support HTML](<../.gitbook/assets/image (60).png>)

CSS has its own style rules. But you drop it into an HTML head like any other HTML, `<style>` _css goes here_ `</style>`. You can put the CSS in the HTML file, but the better way is to keep your CSS in a separate file. In that case, you use a `<link>` element instead to connect the **.css** file.&#x20;

![](<../.gitbook/assets/image (261).png>)



![It can often be very frustrating to find the right CSS rule to fix your display](https://planboard.chalk.com/api/chalk/detached_files/5a65aea795deba0e720e08c4cb344275ba83f4de93b83fbf9816f5dd9daed22f)

## Practice

{% embed url="https://codepen.io" %}
We'll build a practice page together in class using CodePen
{% endembed %}

{% embed url="https://youtu.be/lFxdJ9u4arU" %}

### Additional Training



{% embed url="https://flexboxfroggy.com/" %}

{% embed url="https://flukeout.github.io/" %}

