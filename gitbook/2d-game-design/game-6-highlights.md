# Game 6 Highlights

## Due to time, we will cover the following:

* Platformer Movement (Video 1)
* Importing Sprite Sheets (Video 1)
* Enemy Movement & Paths (Video 2)
* Tile Sets (class and video 3)
* Big Room with a follow view (class and video 3)

{% embed url="https://youtu.be/wkFGUwKOyyk" %}

{% embed url="https://youtu.be/AKFEUd2yoy4" %}

{% embed url="https://youtu.be/1tCUKsMl_Bs" %}

## Platformer Movement Script

```
// Run This Function in END STEP event
/*
 INSTRUCTIONS: 
 This function requires passing in arguments playerSpeed (not hspeed or speed) 
 and a gravity value.
 
 You should also make an optional argument maxFall with a value of 15
 
 In addition, you need to have two variables in the create event
 of your object:
 
     jumpSpeed = 0
     canJump = true
	 
optional:  Jumping variable (needed in create if you are going to have
		   a jumping animation (controlled in step).

*/



/*********************/
/*Horizontal Movement*/
/*********************/

var move = -keyboard_check(vk_left) + keyboard_check(vk_right);
var collision = instance_place(x+playerSpeed, y+vspeed, all);

// You are moving right
if (move == 1){
	
	if (collision < 0 or !object_get_solid(collision.object_index)){
		x += playerSpeed;
	}
	
	// Move to wall, if there is a SOLID wall to your right
	else{  
		move_contact_solid(0, playerSpeed);
	}
}

// You are moving left
else if (move == -1){
	collision = instance_place(x-playerSpeed, y+vspeed, all)
	if ( collision < 0 or !object_get_solid(collision.object_index)){
		x -= playerSpeed;
	}
	
	// Move to wall, if there is a solid wall to your left
	else{
		move_contact_solid(180, playerSpeed);		
	}
}



/*******************/
/*Vertical Movement*/
/*******************/

jumping = false;
collision = instance_place(x, y - jumpSpeed, all);
// Check to see if you are in the air or are about to jump.
if (place_empty(x, y + 1) or jumpSpeed > 0 or (collision > 0 and !object_get_solid(collision.object_index))){
	jumping = true;
}

// if you are jumping...
if (jumping){
	
	
	// Move up or down if there is no collision this frame.
	if (collision < 0 or !object_get_solid(collision.object_index)){
		y -= jumpSpeed;
	}
	
	// Check for a SOLID object below you
	else if (jumpSpeed < 0  and  object_get_solid(collision.object_index)){
		move_contact_solid(270, jumpSpeed)
		jumpSpeed = 0
	}
	
	// Check for a SOLID object above you
	else if (jumpSpeed > 0  and  object_get_solid(collision.object_index)){
		move_contact_solid(90, jumpSpeed)
		jumpSpeed = -0.1
	}
	jumpSpeed -= grav;
	if (jumpSpeed < -maxFall){
		jumpSpeed = -maxFall;
	}
}

// If you are on SOLID ground, allow the player to jump again.
if (!place_empty(x, y+1) and instance_place(x, y + 1, all) > 0 and object_get_solid( instance_place(x, y + 1, all).object_index)){
	canJump = true;
}
```

## Animation Control

```
var dir = -keyboard_check(vk_left) + keyboard_check(vk_right)

//put your sprite names here:
var jump_right = sMario_jumpR
var walk_right = sMario_right
var jump_left = sMario_jumpL
var walk_left = sMario_left

image_speed = 3
if (dir == 1){
	if (jumping){
		sprite_index = jump_right;
	}
	else {
		sprite_index = walk_right;
	}
}
else if (dir == -1){
	if (jumping){
		sprite_index = jump_left;
	}
	else {
		sprite_index = walk_left;
	}
}
else {
	if (!jumping and sprite_index = jump_right){
		sprite_index = walk_right;
	} else if (!jumping and sprite_index = jump_left){
		sprite_index = walk_left;
	} else if (jumping and sprite_index = walk_right) {
		sprite_index = jump_right;
	} else if (jumping and sprite_index = walk_left) {
		sprite_index = jump_left;
	}
	image_speed = 0;
	image_index = 0;
}
	
```



## Enemy Move

```
var collision = instance_place(x+hspeed, y+vspeed, all);
var collisionBelowRight = instance_place(x+hspeed+sprite_width, y+1, all)
var collisionBelowLeft = instance_place(x+hspeed-sprite_width, y+1, all)

if (hspeed > 0){
	if (place_empty(x+hspeed+sprite_width, y+1) or
	   (collision >-0 and object_get_solid(collision.object_index)) or
	   (!place_empty(x+hspeed+sprite_width, y+1) and collisionBelowRight > 0 and object_get_solid(collisionBelowRight.object_index) == false )){
		hspeed = -hspeed;
	}
}
else if (hspeed < 0){
	if (place_empty(x+hspeed-sprite_width, y+1) or 
	   (collision >-0 and object_get_solid(collision.object_index)) or
	   (!place_empty(x+hspeed-sprite_width, y+1) and collisionBelowLeft > 0 and object_get_solid(collisionBelowLeft.object_index) == false )){
		hspeed = -hspeed;
	}
}
```



## Jump Attack

```
if (y < other.y and jumpSpeed <= 0){
	instance_destroy(other)
} 
else {
	instance_destroy(self)	
}
```





## Resources

[Mario Sprite Sheet](https://drive.google.com/file/d/1kAJ_KxtlbHOLhRBc9T9NuvlZ2CHGHFph/view?usp=sharing)

[Enemy Sprite Sheet](https://drive.google.com/file/d/1fYdrCbiCGiLoGx3Jj7eykiLtc557QEN0/view?usp=sharing)\
\
[Flying Enemy Sprite Sheet](https://drive.google.com/file/d/1vf-sg-SjtsNS-uD01HT89m43nA7L7VUW/view?usp=sharing)

[Mario Tileset](https://drive.google.com/file/d/1tEzBMb0P0xj7Osa2XejKGwMOyRnnB9N6/view?usp=sharing)
