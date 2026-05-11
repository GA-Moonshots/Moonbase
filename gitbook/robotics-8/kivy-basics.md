# Kivy Basics

## Kivy Video Overviews



{% embed url="https://youtu.be/kUDXXhJ4Bn4" %}



{% embed url="https://youtu.be/JCiaJqM4o_w" %}

##

```
// Basic Kivy Code (main.py)
from kivy.app import App
from kivy.uix.boxlayout import BoxLayout

class Interface(BoxLayout):
    pass
    
class LayoutApp(App):
    pass
    
LayoutApp().run()
```

##

## Widgets

Kivy uses widgets as the basic building block for GUIs (Graphical User Interfaces).  Widgets are objects which can be layed out on your screen and which perform specific tasks.  Some examples are input fields, buttons and drop down menus.  In this section, you will find an example of widgets we will use in the class as well as specific parameters which can control individual widgets.  If you feel like digging deeper into your options, [the kivy documentation can be found here.](https://kivy.org/doc/stable/guide/widgets.html)



### Label

The label widget is used to create text on your screen.

* **text: "Hello World"**&#x20;
  * _Displays "Hello World" on the interface_
* **color: 1, 0, 0, 1**    &#x20;
  * _Color takes 4 numbers from 0 - 1.  These correspond to RGB and Alpha_&#x20;
* **font\_size: 32**        &#x20;
  * &#x20;_Sets the font to 32 pt_
* _**markup: True**_    &#x20;
  * _Allows you to add markups such as bold, italics, font in your text_&#x20;
  * _\[b] Bold \[/b], \[i] italics\[/i], \[font=times] Change the font to times \[/font]_&#x20;
  * _\[s] strikethrough \[/s],  \[u] underline \[/u], \[color=#hexcolor] change color \[/color]_ &#x20;
* **size\_hint: 0.5, 0.5**
  * _changes the size of the text box in relation to horizontal width of the window and vertical height of the window._
* _**size:  200, 200**    &#x20;_&#x20;    &#x20;
  * _Changes the size of the text BOX, not the text._



***

### Button







***

### TextInput
