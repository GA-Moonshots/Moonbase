# 6: Visualize Your App

## Expectations

If you don't start visualizing things before you're knee-deep in code, your product will lack a cohesive visual style and an intuitive workflow. Building an app starts with colors, logos and most importantly, [wireframes](https://www.adobe.com/products/xd.html).&#x20;

### Learning Targets

* I can develop a brand identify for my product including logos, color pallets, fonts, and tone of voice.
* I can outline the workflow of my app in a wireframe.&#x20;

{% embed url="https://www.youtube.com/watch?v=VMhg0A0ZFM0&feature=youtu.be&hd=1" %}

Setup a local folder using something like Google Drive to collaborate with your team. Download a theme. Start a PowerPoint or Google Slides document to take notes, build a scrapbook of visual designs that can help you shape the message you’re trying to send.

## Select a Theme

Rather than design our own HTML layout and polish the finer details and effects, we’re going to use a theme. We’ll look at [paid themes](https://themeforest.net/category/site-templates?rating_min=3\&sales=rank-4,rank-3,rank-2\&sort=rating\&tags=bootstrap) and [free themes](http://startbootstrap.com). You must make sure your theme is based on [Bootstrap](http://getbootstrap.com), preferably the most recent version. You want to make sure that the theme has a variety of elements and layouts that will allow you to mockup pages quickly.

{% hint style="info" %}
For rapid prototyping, don't be afraid of using Flaskinni's default theme. Proving your app concept with a pleasant, neutral design is smart.&#x20;
{% endhint %}

### Custom layer

Never make changes to theme.css, style.css or whatever your file is called that governs the primary rules of your theme. We will override the rules using different files. That way we can more easily upgrade the theme in the future. The `custom.css` file (that hopefully you're using [Sass](https://sass-lang.com/guide) to produce) in our `<head>` after the theme’s CSS. That way, our rules will overwrite the theme’s. We’ll have the final say.&#x20;

### Change base.html

Implementing a new theme is tricky business. You'll have to rebuild your static assets and modify all the templates. The base.html file will need the most amount of work as it will need to reflect  We talk about that more [next chapter](flaskinni-drills.md#implementing-a-new-html-theme).&#x20;

## The Brand

Building your app, your team, and your company requires a lot of drive. A brand identity is a flag on a battlefield for your soldiers to rally.&#x20;

![Bajirao Mastani is a metaphor for the rallying effect of a brand](<../.gitbook/assets/giphy (5).gif>)

### Colors

Go to the websites of some major brand names you know and look at the colors used. If you did deep enough, you'll find a variety of button colors, but most things follow a pretty consistent pattern.  It's time to set up such a pattern inside our CSS.&#x20;

* [http://coolors.co](http://coolors.co) \
  These palettes can help you color your logo
* [https://color.adobe.com/create/color-wheel/](https://color.adobe.com/create/color-wheel/)  \
  expand the 5 colors you get from coolors
* [https://colors.eva.design/](https://colors.eva.design/)\
  Eva will help you fill in any gaps on the standard Bootstrap colors (primary, success, info, warning, danger)
* [http://designmodo.github.io/Flat-UI/](http://designmodo.github.io/Flat-UI/)\
  When in doubt, use Flat design

{% embed url="http://youtu.be/dey7sohsdsg?hd=1" %}
This example doesn't use Sass. Not great.
{% endembed %}

#### Sass

Hopefully you have a `_variables.scss` file where you can drop all your color palette. Many themes include these assets. Flaskinni's default theme comes from [startbootstrap](https://startbootstrap.com) so you can take advantage of the [Sass structure](https://sass-lang.com/guide) to quickly implement your colors.&#x20;

{% embed url="http://youtu.be/debUtxK8euM?hd=1" %}

{% hint style="warning" %}
If you're using **SourceLair**, you may need to upgrade Sass so it can handle recent Bootstrap templates. So first run **`npm install -g sass`** so you can then run:\
`sass app/static/scss/custom.scss:app/static/css/custom.min.css`
{% endhint %}

The code below are example MacOS settings for the Live Sass Compiler extension for VS Code.&#x20;

```javascript
    // add to your settings.json file in VSCode if you choose to liveSassCompile
    "liveSassCompile.settings.includeItems": [
        "/app/static/scss/custom.scss"
    ],
    "liveSassCompile.settings.generateMap": false,
    "liveSassCompile.settings.formats":[
        {
            "format": "compressed",
            "extensionName": ".min.css",
            "savePath": "/app/static/css/"
        }
    ]
```

{% embed url="https://getbootstrap.com/docs/4.0/getting-started/theming/" %}
At least glance through the documentation
{% endembed %}

### Fonts

You'll need a header and a body font at least. Sometimes a logo font is used as the headers, sometimes not. You may want to pick out your logo first and then find complementary fonts afterwards.&#x20;

[http://fonts.google.com](http://fonts.google.com)

### Logo

Start sketching ideas on your branding document. It can be very powerful to have a logo designed early in project development as it sets styles, colors and gives you something to reference when discussing your project.

[http://graphicriver.net](http://graphicriver.net)

{% embed url="https://www.youtube.com/watch?v=zOPA0NaeTBk" %}

### Stock Images

[http://allthefreestock.com/](http://allthefreestock.com/)

Shutterstock.com  -- start building collections of images you might want to use<br>

Add images to your branding document. Scrapbook images that you don’t intend or are unable to buy and use but speak to the type of look and feel you want (or want to avoid). Have a different section for images that you may want to purchase and use later on. Free images you can start to download and organize into your team’s project folder. Paid images you can start to save in bookmarks, links on your slides, or in other ways.

## Wireframes

{% embed url="https://www.adobe.com/products/xd.html" %}
Free, popular and loaded with tutorials
{% endembed %}

{% embed url="https://letsxd.com/prototyping" %}
They really do a great job of teaching this stuff. I don't have to do anything
{% endembed %}

{% embed url="https://www.sketchapp.com/" %}
While I prefer Adobe XD, I've seen tons of great work on Sketch
{% endembed %}

{% embed url="https://www.figma.com/" %}
Free for students!
{% endembed %}

The wire-framing that needs to be added to your branding document is essentially just shapes illustrating what your app can do. You could use Google Slides in a real hurry. Ideally though, you should use the wire-framing process not only to determine all the steps your users will need to take, but also how you'll organize the interface. You're making UI decisions as well as UX.&#x20;

I try to start by first looking through the pages that come with my HTML theme and see what sort of layout, widgets and objects are readily accessible. Keep them in mind when designing your wire-frames. After this early phase, we will be building full HTML mockups to illustrate these wire-frames.

![](https://lh6.googleusercontent.com/Tex293sflc2XOO9gtsrzXypSik59mMRYUZ6LqgIcKklfTEPyzqRtb89obbWKkEWh1fEdOQciaxPWg3pxAoaRTITrjoAPSZgIbPFenfC7wgwr6dbgsWQZKC6JfipcNOeV6HcLypWD)

### HTML mockups

Building HTML mockups is much, much slower than Adobe XD. You ought to sketch out your apps before you code HTML elements. But designing the HTML elements using the theme assets you'll have in production takes you from planning the outline of the user experience (UX) to the mechanics of the actual interface (UI).&#x20;

{% embed url="https://www.youtube.com/watch?v=LJ4w9a_o-Nk" %}

{% embed url="https://www.youtube.com/watch?v=_MNqJaHSUN8" %}

Before you advance, be sure you’re making steady progress through the Flask Udemy course (and getting help when stuck)

[<br>](http://graphicriver.net)
