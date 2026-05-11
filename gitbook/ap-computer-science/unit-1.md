---
description: >-
  We start with the fundamentals of logic gates and logical expressions using De
  Morgan's Law. By looking at transistors, the most granular aspect of CS, we
  can steadily add layers of abstraction.
---

# 1-A: Logic & Instances

## Learning Targets

* I can explain the connection between electricity and logic.
* I can interpret logical statements with all common operators, (i.e. and, or, nor, xor, if, iff).
* I can describe the purpose of instantiation.&#x20;
* I can decide when to instantiate an object or when to use a static class.&#x20;
* I can simplify a logical expression according to De Morgan's Laws.&#x20;
* I can convert numbers from decimal to binary and to hexadecimal.&#x20;

## Logic Gates

I'm absolutely fascinated in how people build logic, systems that react to conditions, into physical devices.

![](../.gitbook/assets/RashMassiveAmmonite-size_restricted.gif)

We start with two tricks with circuits: \
1\) and `&&` \
2\) or `||`&#x20;

With tiny transistors and these building blocks, we can assemble our modern technological era. Let's just take a peak:

{% embed url="https://www.youtube.com/watch?v=VBDoT8o4q00" %}

<figure><img src="../.gitbook/assets/image (136).png" alt=""><figcaption></figcaption></figure>

<figure><img src="../.gitbook/assets/image (98).png" alt=""><figcaption></figcaption></figure>

&#x20;&#x20;

<figure><img src="../.gitbook/assets/image (110).png" alt=""><figcaption></figcaption></figure>

<figure><img src="../.gitbook/assets/image (95).png" alt=""><figcaption></figcaption></figure>

<figure><img src="../.gitbook/assets/image (87).png" alt=""><figcaption></figcaption></figure>

<figure><img src="../.gitbook/assets/image (112).png" alt=""><figcaption></figcaption></figure>

<figure><img src="../.gitbook/assets/image (86).png" alt=""><figcaption></figcaption></figure>

### De Morgan's Law

You'll need to know how to distribute the `!` when simplifying logical expressions. This will make more sense as we get into more practical examples.&#x20;

<figure><img src="../.gitbook/assets/image (100).png" alt=""><figcaption><p>De Morgan's Laws essentially describes the distributive property of "not" or !</p></figcaption></figure>

A "promise" or an "if" within logic is something like:

<figure><img src="../.gitbook/assets/image (138).png" alt=""><figcaption><p>It's only false if the condition was met (you studied) but you did not get the promised result.</p></figcaption></figure>

{% embed url="https://www.loom.com/share/b64ef665231943ffab2568a680ad8129" %}

<figure><img src="../.gitbook/assets/image (83).png" alt=""><figcaption><p>iff means they both have to be the same for &#x3C;-> to be true</p></figcaption></figure>

### Practicing Boolean Logic

Let's simplify these statements. Reduce them down to just `true` or `false`

* `true != true || (true || false)`
* `false && true || true && false || true && false || true`
* `!(true && false)`&#x20;
* `!(5 > 5)`
* `!(5 <= 5)`
* `5 == 5 && true`&#x20;



## Binary

Can you see how `false` and `true` could also be considered to be `0` and `1`? All the sudden, we can make these logic gates, these electrical transistors, store binary data. Computers are pretty cool.&#x20;

{% embed url="https://i.imgur.com/NQPrUsI.gifv" %}

![](<../.gitbook/assets/image (262).png>)

![](<../.gitbook/assets/image (84).png>)

{% embed url="https://youtu.be/8T4F7WboWPQ" %}

## Instantiation

This is an important concept that's most easily introduced when we're not thinking about the code. If you have a recipe to make a cake, that's similar to a **class definition**. Each time you bake a cake, you're creating a new instance of that cake.&#x20;

<figure><img src="../.gitbook/assets/image (105).png" alt=""><figcaption><p>One cake recipe produced many objects</p></figcaption></figure>



<figure><img src="../.gitbook/assets/image (90).png" alt=""><figcaption><p>A whiteboard has functions but is not replicable. It's a static resource </p></figcaption></figure>

### Another example of instance VS static classes&#x20;

This is by no means a perfect example as things are more complicated... but let's consider Fortnite for a moment. There's just one map. Programmers might refer to this map by its class. If I wanted to call a tornado, at Coney Crossroads, I might type something like, `Map.createTornado("Coney Crossroads");`

<figure><img src="../.gitbook/assets/image (274).png" alt=""><figcaption><p>One map and globally accessible resources. An potential example of a <strong>static class</strong> </p></figcaption></figure>

Now let's imagine a programmer wanted to provide a player with some individual powers. I wouldn't want to be so broad as to call the whole `Player` class as each player is an individual. I'd want to specify which individual player, something like `lancerGuy99.upgradeWeapon();`

<figure><img src="../.gitbook/assets/image (91).png" alt=""><figcaption><p>Each person controls an instance of the Player class. Each copy of stores the user's skin, current health, etc.</p></figcaption></figure>

### Mixing Static and Instances&#x20;

Now that we understand the difference between static (class-level) and instance (object-level) methods, let's see what happens when we try to mix them inappropriately.

Going back to our Fortnite example: remember that the map is static—there's only one map for everyone, so we use `Map.createTornado()`. But each player is their own individual instance, so we use `lancerGuy99.upgradeWeapon()`.

What would happen if we tried to put instance-specific things inside our static Map class? Imagine if we tried to write `Map.upgradeWeapon()`?&#x20;

This doesn't make sense because the Map doesn't know which specific player we're talking about. The map is shared by everyone, but each player has their own individual weapon that needs upgrading.

Think of it like a school's PA system (static) versus individual student lockers (instances). The PA system can make announcements to everyone: "School will dismiss early today." But the PA system can't say "Please clean out your locker" because it doesn't know whose specific locker needs cleaning—that's something each individual student (instance) needs to handle for their own locker.

In programming terms: **static methods can't directly access instance variables or call instance methods** because they don't know which specific object (which student, which player) they should be working with. Static belongs to the whole class, while instances belong to individual objects.
