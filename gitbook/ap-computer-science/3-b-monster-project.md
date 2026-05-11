# 3-B: Monster Project

## Monster Battle Game - Project Assignment

### Overview

Enhance your game by implementing monster special abilities and customizing the 4th action button. Make your game feel complete and polished!

### Part 1: Monster Special Abilities (Required)

**Goal:** When monsters attack, check if they have special abilities and trigger unique effects.

**Where to work:** In the `monsterAttack()` method, after damage is dealt.

**Steps:**

1. Check each attacking monster's `special()` ability (it returns a String)
2. If the ability is not empty, add custom behavior based on the ability name
3. Display appropriate messages for each special ability

**Example Pattern:**

```java
// After monster deals damage...
if (!monster.special().isEmpty()) {
    if (monster.special().equals("Vampire")) {
        // TODO: Monster heals itself for some of the damage dealt
        // Hint: Use a variable to track damage before dealing it
    }
    else if (monster.special().equals("Poison")) {
        // TODO: Add poison effect that damages over time
    }
    // Add more special abilities!
}
```

**Possible Special Abilities to Implement:**

* **Vampire**: Heals for 50% of damage dealt
* **Poison**: Deals 5 extra damage for the next 2 turns
* **Rage**: Increases damage by 25% when below 50% health
* **Thorns**: Player takes 10 damage back when attacking this monster
* **Regeneration**: Heals 10 HP at the end of each turn
* **Stun**: Player misses their next turn (skip next action)

**Tips:**

* You may need instance variables to track ongoing effects (like poison duration)
* Update the `setupGame()` to create monsters with different special abilities
* Test each ability one at a time

### Part 2: Customize the 4th Button (Choose One)

#### Option A: Implement Use Item System

Make the 4th button use consumable items from your inventory.

**Tasks:**

1. Create health potions in `setupGame()` (see `GameDemo.java` for examples)
2. The `useItem()` method already works - just add items!
3. Create 2-3 different item types:
   * Health Potion: Heals 30 HP
   * Bomb: Damages all monsters for 20 HP
   * Shield Potion: Adds temporary shield
   * Your own creative item!

#### Option B: Implement Player Special Abilities

Replace "Use Item" with a unique special ability for each character class.

**Tasks:**

1. Change button label in `setupGame()` to "Special"
2. Add a `useSpecial()` method with unique abilities per class:
   * **Fighter**: Berserker Rage - Double damage for 2 turns
   * **Tank**: Iron Wall - Block all damage next turn
   * **Healer**: Group Heal - Heal 50 HP (cooldown: 3 turns)
   * **Ninja**: Shadow Strike - Attack all monsters for half damage
3. Track cooldowns to prevent spam (add instance variable)
4. Update `handlePlayerAction(3)` to call your new method

**Cooldown Pattern:**

```java
private int specialCooldown = 0;  // Instance variable

private void useSpecial() {
    if (specialCooldown > 0) {
        gui.displayMessage("Special ability on cooldown! (" + specialCooldown + " turns)");
        return;
    }
    
    // Do special ability...
    specialCooldown = 3;  // Set cooldown
}

// In gameLoop(), reduce cooldown each turn:
if (specialCooldown > 0) specialCooldown--;
```

### Part 3: Polish Your Game (Required)

Make your game feel professional and complete!

**Required Improvements:**

1. **Victory Conditions**: Display final stats when game ends (turns survived, damage dealt, etc.)
2. **Better Targeting**: Let player choose which monster to attack (hint: show monster numbers in message)
3. **Status Display**: Show active effects in messages (poison status, shield amount, cooldowns)
4. **Balance Testing**: Adjust character stats so all classes are viable
5. **Bug Fixes**: Ensure health can't go above max, shield doesn't go negative, etc.

**Optional Enhancements:**

* Add more monster types with different stat ranges
* Create boss monsters with multiple special abilities
* Add difficulty scaling (monsters get stronger each wave)
* Implement combo attacks (bonus damage for consecutive attacks)
* Add critical hit chances
* Create a scoring system
* Add sound descriptions in messages ("💥 CRASH!", "✨ SPARKLE!")

### Submission Checklist

* [ ] At least 3 different monster special abilities working
* [ ] 4th button fully functional (items OR player specials)
* [ ] Game is balanced (winnable but challenging)
* [ ] No major bugs (crashes, negative health, etc.)
* [ ] Clear messages tell player what's happening
* [ ] Code is commented and organized
* [ ] Game has been playtested multiple times

### Tips for Success

1. **Test frequently**: Run your game after each small change
2. **Start simple**: Get one special ability working perfectly before adding more
3. **Use print statements**: Add `System.out.println()` to debug issues
4. **Study GameDemo.java**: It shows many useful patterns
5. **Ask for help**: If stuck for 10+ minutes, ask a classmate or teacher
6. **Be creative**: Add your own unique abilities and features!

### Example Monster Creation with Specials

```java
// In setupGame(), create diverse monsters:
monsters.add(new Monster("Vampire"));
monsters.add(new Monster("Poison"));
monsters.add(new Monster("Rage"));
monsters.add(new Monster());  // Normal monster
monsters.add(new Monster());  // Normal monster
```
