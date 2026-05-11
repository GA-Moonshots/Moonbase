# Game 4: Breakout

### Breakout Instructions

{% embed url="https://docs.google.com/presentation/d/1SLcSG1_0J-O7lTFuKuEdL4TMmFn3bOioIG1iRwVjAK0/edit?usp=sharing" %}

## Bounce Code

```
///Bounce against walls

move_bounce_all(true);
move_outside_all(direction, 100);


```



## Pause Code - in obj\_pause (create event)

```
  // Create surface, draw everything to it, deactivate all other objects
 
surf = surface_create(room_width, room_height); 
    // creates a surface which is the same height and width as the room.
    // A surface is basically a clear drawing surface on the screen.
  
surface_set_target(surf);   
    // Sets aside room in memory for surface and begins drawing on it

draw_clear_alpha (c_red, .5); 
    // Clears surface of buffer noise and sets color and alpha 
    // (0= fully transparent, 1 = fully opaque, .5=50% transparent)

surface_reset_target();
    // Tells GM to stop drawing on the surface and 
    // allows drawing directly on the screen again (and thus the draw GUI below)
 
instance_deactivate_object (obj_ball);
    // Deactivates the ball without destroying it.

visible = true; 		
    //This object is visible.  
    //Adding the command is not strictly necessary since we already set the object to visible.

```

## Pause Code - In obj\_pause (Draw GUI event)

```
draw_set_font(fnt_pause);
	// GML commands, also called functions,  are set up in categories.
	// Draw_ gives you access to draw functions.
	// Instance_ functions give you access to things dealing with instances of objects.
	// Draw_set_ commands establish parameters for your draw actions.
	// This one changes your draw font to your pause font (set it up, if you haven’t).

draw_set_color(c_black);
	// This one sets the color.
	// typing c_ will give you a list of different color options.

draw_set_halign(fa_center);
	// Sets the horizontal alignment of the font to center.

draw_surface(surf, 0, 0);
	// This function draws the surface over the room.  
	// The surface that it draws is called surf (which is what we called it in the create event).
	// It draws it starting at 0x and 0y in the room.

draw_text(room_width/2, room_height/2, "Game Paused:  Press Space to Continue");
	// This draws text.  It looks for (x,y,string) which means the programmer 
	// decides where the it goes.  room_width / 2 is right in the center of the room.
	// A string is a series of text in “”. The text is in black and centered because of the above 
	// draw_set_ functions.

draw_set_halign(fa_left);
	// Since the text of the scoreboard is aligned to the left, we need to reset the alignment.

```

## Pause Code - In obj\_pause (Key Press - Space)

```
/// Unpause, clear surface, re-activate all objects.

surface_free(surf); 
	// Free up the memory from the surface.
	// Essentially this deletes the surface.
	// By the way, we are starting code now because there are no commands in 
	// drag and drop programming that deal with surfaces.

instance_activate_all(); 
	// Activate all the objects again
	// We could have also used instance_activate_object (obj_ball); 
	// since that is the only thing we deactivated in the create event.

instance_destroy(self);  
	// Destroy the pause object.
	
	// As you look at this code, remember that instance_ functions are used
	// to control instances of objects in the room.  As we get further along, we 
	// will use more code blocks,  so it is important to be aware of the general 
	// language rules because you won’t always know what the exact command 
	// will be for an operation. 
	
	// In the code block autocomplete will help you find the right one.  If you know
	// you are dealing with an instance, you can start typing “instance_” and will be
	// given a list of possible things which could finish that command.  

```

### [Breakout Resource Folder](https://drive.google.com/drive/folders/1qpfKgSkViJUorV2ezaY6GFXnQQda9m8K?usp=sharing)
