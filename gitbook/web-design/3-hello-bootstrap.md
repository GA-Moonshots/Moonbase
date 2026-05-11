---
description: Use a Bootstrap template to produce a stunning webpage.
---

# 3: Bootstrap

## Learning Targets

* I can build a hero with a call to action.
* I can implement a color palette via CSS.&#x20;
* I can build a responsive Bootstrap website.&#x20;
* I can implement Bootstrap classes and components into a website.&#x20;

## What is Bootstrap?

![Bootstrap has tons of helpful styles and tools built in, but most importantly, it makes your page responsive](<../.gitbook/assets/image (52).png>)

[Read about it](https://en.wikipedia.org/wiki/Bootstrap_\(front-end_framework\)). Twitter publishes a front-end framework that has significantly impacted web designers. It's great, and you'll spend a lot of time with [its documentation](https://getbootstrap.com/docs/4.1/getting-started/introduction/).&#x20;

![](<../.gitbook/assets/image (26).png>)

### What is responsive?

Responsive design isn't just about websites looking good on different screens; it's about delivering an optimal user experience on any device. Imagine navigating a complex website on a tiny phone instead of a spacious desktop – the frustration is real! Responsive design solves this by adapting the website's layout, content, and functionality to various screen sizes, ensuring a seamless user journey.

**Bootstrap's Grid System:**

Bootstrap, a popular framework, makes responsive design accessible. Based on 12 columns, its grid system provides a flexible layout structure. In your example, `<div class="col-md-6">` and `<div class="col-lg-6">` define elements that occupy 6 columns on medium and large screens, respectively.

**Breakpoints and Device Adaptation:**

The magic happens with breakpoints and specific screen widths where the layout adjusts. Bootstrap uses predefined breakpoints for `@media` queries, essentially saying, "When the screen size reaches X, apply these styles." Your task with the inspector window is to find these breakpoints! Look for `@media` rules defining styles for `lg`, `md`, and `sm` (small) screens. Notice how Bootstrap adjusts the number of columns these classes occupy at each breakpoint.

**Exploring Device-Specific Adjustments:**

While Bootstrap offers a solid foundation, sometimes device-specific tweaks are necessary. For example, on smaller screens, you might:

* **Collapse content sections** by default and use buttons or icons to reveal them.
* **Increase font sizes** for better readability.
* **Simplify navigation menus** or switch to hamburger menus for better accessibility.
* **Optimize images** for faster loading times.

**Beyond Bootstrap:**

Remember, Bootstrap is a tool, not a silver bullet. You might need to go beyond its base styles as your projects evolve. This is where understanding CSS media queries and flexbox becomes crucial for more granular control over responsive layouts.

**Beyond Screen Size:**

While the screen size is the primary factor, a responsive design also considers other aspects:

* **Device orientation:** Portrait and landscape modes on phones and tablets require different layouts.
* **Resolution:** High-resolution displays might necessitate adjustments for image quality and text sizes.
* **Network speed:** Consider loading optimizations for users with slower connections.

**The Importance of Testing:**

Responsive design isn't a one-and-done task. Rigorous testing on various devices and screen sizes is crucial. Use browser emulators and real devices to identify and fix any layout issues and ensure a consistent user experience across platforms.

{% embed url="https://getbootstrap.com/docs/4.3/getting-started/introduction/" %}
Check that you're looking at the latest version
{% endembed %}

## Container - Row - Column

Every Bootstrap page starts with the same fundamental building blocks: **Container**, **Row**, and **Column** (C-R-C). Think of this as the skeleton that holds your entire layout together. Just like a house needs a foundation, walls, and rooms, Bootstrap needs containers, rows, and columns to create organized, responsive layouts.

### The Container: Your Layout's Foundation

The container is the outermost wrapper that holds all your content. Bootstrap offers two types of containers:

**`.container`** - Creates a responsive fixed-width container that adjusts at breakpoints **`.container-fluid`** - Creates a full-width container that spans the entire viewport

```html
<div class="container">
  <!-- Your content goes here -->
</div>
```

The container provides proper margins and ensures your content doesn't stretch awkwardly on very wide screens. It's like setting boundaries for your design – everything stays contained and centered.

### The Row: Horizontal Organization

Inside every container, you need rows to create horizontal groups of columns. Rows use negative margins to offset the padding that columns add, creating perfect alignment.

```html
<div class="container">
  <div class="row">
    <!-- Columns go here -->
  </div>
</div>
```

**Important rules for rows:**

* Rows must be placed inside containers
* Only columns should be immediate children of rows
* Rows create horizontal groups of columns using flexbox

### The Column: Where Content Lives

Columns are where your actual content lives. Bootstrap's grid system is based on 12 columns, and you can combine them in various ways to create different layouts.

```html
<div class="container">
  <div class="row">
    <div class="col-md-6">
      <p>This takes up half the row (6 out of 12 columns)</p>
    </div>
    <div class="col-md-6">
      <p>This takes up the other half (6 out of 12 columns)</p>
    </div>
  </div>
</div>
```

**Column class breakdown:**

* `col-` - The base column class
* `md` - The breakpoint (xs, sm, md, lg, xl)
* `6` - The number of columns to span (1-12)

### The Magic of 12 Columns

Bootstrap's 12-column system is incredibly flexible. Here are some common combinations:

* **Two equal columns:** `col-md-6` + `col-md-6` = 6 + 6 = 12 ✓
* **Three equal columns:** `col-md-4` + `col-md-4` + `col-md-4` = 4 + 4 + 4 = 12 ✓
* **Sidebar layout:** `col-md-8` + `col-md-4` = 8 + 4 = 12 ✓
* **Four equal columns:** `col-md-3` + `col-md-3` + `col-md-3` + `col-md-3` = 12 ✓

### Putting It All Together: A Complete Example

Here's a basic Bootstrap page structure that you'll be building in CodePen:

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Bootstrap C-R-C Example</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <!-- Container -->
  <div class="container">
    
    <!-- Row 1: Header -->
    <div class="row">
      <div class="col-12">
        <h1>My Website Header</h1>
      </div>
    </div>
    
    <!-- Row 2: Main content and sidebar -->
    <div class="row">
      <div class="col-md-8">
        <h2>Main Content Area</h2>
        <p>This is where your main content would go.</p>
      </div>
      <div class="col-md-4">
        <h3>Sidebar</h3>
        <p>This is a sidebar with additional information.</p>
      </div>
    </div>
    
    <!-- Row 3: Footer -->
    <div class="row">
      <div class="col-12">
        <footer>© 2024 My Website</footer>
      </div>
    </div>
    
  </div>
</body>
</html>
```

### Key Takeaways for Your CodePen Assignment

When building your C-R-C structure, remember:

1. **Rows go inside containers:** They give you readable margins. We typically avoid putting rows directly in the body
2. **Columns go inside rows**: And content goes inside columns
3. **The numbers must add up to 12** - Or less if you want some columns to not fill the full width
4. **Use breakpoints thoughtfully** - `col-md-6` means "6 columns wide on medium screens and up"

This structure is the foundation of every Bootstrap layout. Once you master Container-Row-Column, you'll be able to create complex, responsive layouts with confidence.

{% embed url="https://youtube.com/playlist?list=PL4cUxeGkcC9joIM91nLzd_qaH_AimmdAR&si=7KoTkJ52lFH9Qxbe" %}

##
