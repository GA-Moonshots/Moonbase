# Software Installation

{% embed url="https://youtu.be/_uUBRvdS7tg" %}



{% embed url="https://code.visualstudio.com/" %}



```
#!/usr/bin/env pybricks-micropython
from pybricks.hubs import EV3Brick
from pybricks.parameters import Color

# setup section
ev3 = EV3Brick()
screen = ev3.screen
screen.clear()

# Main Program
screen.draw_text(10, 10, "Everything", text_color=Color.BLACK, background_color=None)
screen.draw_text(10, 30, "is", text_color=Color.BLACK, background_color=None)
screen.draw_text(10, 50, "Awesome!", text_color=Color.BLACK, background_color=None)

ev3.speaker.beep()

while (True):
    wait = 0
    
```
