# Game 5: Tank Battle

### Tank Battle Instructions Part&#x20;

{% embed url="https://docs.google.com/presentation/d/13XMKVKkkDSNASlCwowzC7TM2Hg4G2H8Ag1r2yjjliHg/edit?usp=sharing" %}



### Tank Battle Instructions Part II

{% embed url="https://docs.google.com/presentation/d/1Z_u-U40u8DKuDLrG84AB9HKIBShKfHJb2zJFOyIywW8/edit?usp=sharing" %}



```
// Make sure that only the active player is able to fire the gun.
// Also, no players should be able to fire if we are between turns 
// (transitioning from player to player)

if (obj_controller.WhoseTurn == myName) and (obj_controller.Transitioning == false){
    
    // Check to see if the the spacebar is released.
    if (keyboard_check_released(vk_space)){
   	 

   	 // The xdistance and ydistance is the difference between the origin 
 // position of the cannon and the end of the barrel at any given rotation.  

 // This value is basic trigonometry for a right triangle if you know the   
 // hypotenuse (the barrel sprite width -- in this case 64) and the angle.
   	 ydistance = 64 * (sin(degtorad(Barrel_Rotation)));
   	 xdistance = 64 * (cos(degtorad(Barrel_Rotation)));
   
   
         // instance_create_depth will create an object at a specific depth.  (100 is generally the
   	 // background.  We are creating obj_bullet at the x and y of the firing turret and shifting the
   	 // bullet based on the angle of the barrel.  
   	 
   	 // Because we are using "with" the things within the { } will apply to the thing being created.
   	 // In this case, we are giving the bullet the barrel rotation value of the turret which is
   	 // shooting it off.  We have to use other. because we are actually doing this from within the
   	 // bullet object, not the turret.

   	 with instance_create_depth(x+xdistance,y-ydistance,50,obj_bullet)
   		 {
   			 direction = other.Barrel_Rotation;
   		 }
   		 
   	 // We are adding an alarm in obj_controller and setting letting the game know we are between turns
   	 // so that players can't fire off multiple bullets and can't accidently fire off their opponent's
   	 // shot.  

   	 // We use room_speed for the alarm because we can multiply our Frames per second by a time in 
   	 // seconds for a more intuitive control.  At 30 FPS, we could have also put in a value of 30.
   	 obj_controller.alarm[1]= room_speed * 1 //seconds;
   	 obj_controller.Transitioning = true;
    }
}

// We will finish off our step event by turning the gravity back on if the turret
// is not moving and there is nothing under it (a box just got destroyed for
// instance) OR if there is fire directly under the turret.  We want the turret
// to fall into the fire.

if ((speed == 0 and place_empty(x,y+1)) or place_meeting(x,y+1,obj_fire))
{
    gravity = 1;
}


```
