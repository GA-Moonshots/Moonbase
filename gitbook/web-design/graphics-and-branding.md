---
description: Let's talk about the design in web design.
---

# 5: Graphics and Branding

## Learning Targets

* I can describe the difference between raster and vector.&#x20;
* I can describe the difference between serif and sans serif.&#x20;
* I can iterate on my design.&#x20;
* I can use Photoshop's masking layers and quick select tool.&#x20;
* I can create a logo in Adobe Illustrator.&#x20;

## Serif vs Sans Serif

One of the first decisions to make when starting a new project is your font selection. It helps set a lot of the tone for your site. Typically, I select a **header** font and a **body** font--something fun for titles and something easy to read for my paragraphs.&#x20;

![Serifs helped printers stamp ink onto the page](<../.gitbook/assets/image (107).png>)

![](<../.gitbook/assets/image (97).png>)

{% embed url="https://www.youtube.com/watch?v=ocvUGN-OD0w" %}

## Color Palette

Another key mood-setting decision to make is the type of colors you'll use around your site.&#x20;

![Let's start by picking colors that match our intended mood](https://media3.giphy.com/media/3oriO1VZF0t5PyQVlC/giphy.gif?cid=ecf05e476f1omkz6lldvz0nzp5ta75kw13qteeef2xejdk6w\&rid=giphy.gif)

{% embed url="https://coolors.co" %}

Once you've selected your colors, we're going to add a note to your custom CSS like so:

```css
/**

COLORS
https://coolors.co/05a8aa-b8d5b8-d7b49e-dc602e-bc412b
Blue: 05a8aa
Green: b8d5b8
Red: bc412b
Orange: dc602e

**/
```

{% hint style="info" %}
**Adjust your colors!**

Choosing a hero image isn't just about visual impact; it sets the color palette for your entire website. Remember that initial color inspiration you had? Time to revisit it! Once your hero image is finalized, re-evaluate your chosen color scheme. Does it complement the image's tones and moods? Can you pull color accents directly from the image itself? Aligning your color scheme with your hero image fosters visual cohesion, ensuring a seamless and aesthetically pleasing browsing experience for your visitors. Don't let your hero stand alone; let its colors sing throughout your website's design.


{% endhint %}

### Call to Action

Webpages have agendas. The author wants the reader to do something, read something, buy something. Especially on a [hero](https://envato.com/blog/exploring-hero-image-trend-web-design/), you need to make the key action item into an exciting call to action button.&#x20;

![](<../.gitbook/assets/image (253).png>)

### Raster VS Vector

If your image has been zoomed in or stretched too far, and it's a rasterized image, you'll notice the pixels that make up the image. That's a problem. But the solution is not to use a super high-resolution image with a big file size. That'll just make your webpage take forever to load. We need the right resolution each time.

![](<../.gitbook/assets/image (82).png>)

Use vector where you can. Raster, if the image is the right resolution, looks great. The image below can confuse students into thinking raster is always blurry.&#x20;

![There's an irony here](<../.gitbook/assets/image (77).png>)

## Design Principles

### **Common Mistakes**

Check out [this article](https://mashable.com/2011/04/10/5-web-design-mistakes/) about the top five mistakes most common in small companys' websites.

1. Navigation that isn't simple, logical and explanitory
2. No clear calls to action
3. Insufficient contrast between text and background or clashing colors
4. Jumbled, unengaging, or unorganized content
5. Clutter

### Mostly Boring

Backgrounds and most colors should NOT try to grab your attention. Most of it should be steady, comfortable patterns. Subtly is hard for students eager to splash bright colors on the page. That's why we study examples of great pages. Look how chill most of their decisions are... it makes the touches of bright color really exciting.

![Is this a happy or a sad picture? There are more frowns than smiles but it still feels happy](<../.gitbook/assets/image (184).png>)

### Parallelism

Brains love patterns and it can hurt when they're broken. Patterns exist in grammar, color, lines and all sorts of other things too.&#x20;

![Notice this picture has a thick border around it unlike any other?](<../.gitbook/assets/image (249).png>)

### &#xD;Keep Room to Digest

Less is more.

![](<../.gitbook/assets/image (147).png>)

#### When something is considered "clean" design

Lots of clear space with well-organized boundaries can create a "clean" feel. [Example](https://enjoywith.us/).&#x20;

### Metro, Material and Flat Trends

There is a constant variation in what's trending in web design styles. Here are three of the most popular. The last, flat, is more related to colors and icons and less known as a style.&#x20;

![Metro style is angular, often monochromatic](<../.gitbook/assets/image (177).png>)

![](<../.gitbook/assets/image (24).png>)

![](<../.gitbook/assets/image (71).png>)

## Photoshop

Photoshop works with rasterized images (as opposed to vector images). Let's discuss the difference first.&#x20;

We're going to learn about three basic skills:

### Layer Masks

Let's learn a little about [types of images](https://www.jessechapo.com/posts/Developers-Guide-to-Images.html). Now we'll practice masks.&#x20;

{% embed url="https://www.youtube.com/watch?v=h5yW5hHjQrE" %}

### Resizing

Our themes typically come with images perfectly formatted for the area. Instead of taking a new image and trying to crop and adjust it into the right size, I simply edit the original image in Photoshop. Once it's open, I'll drag and drop the new one on top of that.

### Color Correction

We add in new adjustment layers to tweak colors. Turning down the brightness on a hero image so that it lets your CTA stand out more is a common technique.&#x20;

## Logo Design in Illustrator

{% embed url="https://www.youtube.com/watch?v=gVUVUoXrPzM" %}

{% embed url="https://99designs.com/blog/tips/types-of-logos/" %}

Consistency in colors, branding across all your emails and publications (attention to things like [favicon](https://en.wikipedia.org/wiki/Favicon)).

### Requirements of a Logo Package

* PNG and JPG images
* Wide but thin logos (banner format)
* Square shaped logos
* Large, medium and small file types
* Original .ai files as well as exported versions
* Reversed colors for dark backgrounds as well as light backgrounds

#### Find a Tutorial

Find a tutorial that gets close to the effect you want. Follow along and then try to tweak and customize it.&#x20;

{% embed url="https://helpx.adobe.com/illustrator/how-to/logo-design.html" %}

{% embed url="https://design.tutsplus.com/tutorials/how-to-create-a-cool-cut-out-text-effect-in-illustrator--cms-32422" %}

{% embed url="https://www.youtube.com/watch?v=qwM0KOrZ0fY" %}

{% embed url="https://www.youtube.com/watch?v=-5NdHkz1W4E" %}

{% hint style="info" %}
If I can't hire a graphic designer for my client, I start with a template purchased from [GraphicRiver](https://graphicriver.net/logo-templates).&#x20;
{% endhint %}

