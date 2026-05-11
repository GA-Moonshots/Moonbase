# FAQ

{% embed url="https://youtu.be/A624WNp3Mrs" %}

```
// Pac Man Ghost Movement Code
if (place_snapped(64,64)){
	var changed = false;
	var randomDir = irandom_range(1,4);
	
	if (hspeed == 0){
		if (randomDir == 1){
			if (!place_meeting(x - ghostSpeed, y, obj_wall)){
				speed = ghostSpeed
				direction = 180;
				changed = true;
			}
		} else if (randomDir == 2){
			if (!place_meeting(x + ghostSpeed, y, obj_wall)){
				speed = ghostSpeed
				direction = 0;
				changed = true;
			}
		}
	}
	if (vspeed == 0 and changed == false){
		if (randomDir == 1){
			if (!place_meeting(x, y - ghostSpeed, obj_wall)){
				speed = ghostSpeed
				direction = 90; 
			}
		} else if (randomDir == 2){
			if (!place_meeting(x, y + ghostSpeed, obj_wall)){
				speed = ghostSpeed
				direction = 270;
			}
		}
	}
}
```

{% embed url="https://youtu.be/fBNSKj_kMo8" %}

{% embed url="https://youtu.be/583YQyCGhxs" %}



{% embed url="https://youtu.be/sQAczSDuqJg" %}



{% embed url="https://youtu.be/fh8qo_WduWo" %}

{% embed url="https://youtu.be/1hwpQkWj32c" %}

{% embed url="https://youtu.be/yD_D4pNUDV0" %}



{% embed url="https://youtu.be/I34ACzOiSic" %}



{% embed url="https://youtu.be/jvJopnNsKwo" %}
Space Invader Style Enemy Movement
{% endembed %}



{% embed url="https://youtu.be/cAa_2aQBOjY" %}
Object Following a Mouse
{% endembed %}

{% embed url="https://youtu.be/kCYxRxm_Jao" %}
Changing Background Colors in Code.
{% endembed %}

