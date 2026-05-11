---
description: >-
  We introduce our first complex algorithms and start to pull back the
  scaffolding a bit. Students will get their first real experience designing
  aggregate objects with encapsulated properties.
---

# X: Inheritence

## Learning Targets

* I can secure my class variables with encapsulation.
* I can create a constructor to initialize an object.
* I can override a parent method.
* I can build unit tests for all methods in an aggregate object.

## Inheritance

{% embed url="https://www.youtube.com/watch?v=cC5ZgGSh-iU" %}

{% hint style="info" %}
**Keep it DRY and OOP-y**

DRY stands for Don't Repeat Yourself. So far, that's meant that if you need to repeat a bit of code, you make a loop instead of sloppily copying and pasting the same commands a few times. Now we're seeing that OOP, or Object-Oriented Programming, has was to build classes off of one another. That means we can avoid repeating (aka DRY code) by using inheritance.&#x20;
{% endhint %}

### Abstract Classes

{% embed url="https://www.youtube.com/watch?v=hZ1EU-F-0nU" %}

![](<../.gitbook/assets/image (49).png>)

### Polymorphism Practice

Polymorphism is my favorite CS term because it sounds so much fancier than it really is (sort of a theme here). In class we'll build an abstract class called Shape with some encaspulated instance variables like `length` and `width`, abstract methods like `.area()`. Then we'll inherit from those methods when we create types of shapes like Circle, Rectangle, Triangle and so on. Let's look closer at why this is an example of inheritance and polymorphism.&#x20;

#### Why this is smart, object-oriented programming

Creating a parent class called `Shape` that all your shapes will inherit means that the common properties and functions can live in one place. If new features or changes needed to happen across all the elements in your app, you would have a logical place to check.

#### But why do we declare abstract methods?&#x20;

Let's take a look at a shortened `Shape` class:

```java
class Shape {
    
    // a single example encaspulated instance variable
    private float length;
    
    // accessor method
    public float length(){
        // using this. is not required but helpful when writing
        return this.length; 
    
    // mutator method
    public void length(float length){
        // now using this. is required to tell the local and instance var apart
        this.length = length;

    // example abstract method. Each shape will need to make or "implement" 
    pubilc abstract float area();
        
}
```

All the encapsulation shown between lines 3 - 14 should be familiar by now. Seek additional practice including your teacher's office hours if not. The cool new thing here is line 17. Because the parent is declaring this method, all its children (i.e `class Circle extends Shape {` )will have to build their own area method. The `Circle` class will `return 3.14 * (length * length);` for its `area()` implementation. &#x20;

#### So how exactly is this business "polymorphic?"

Because all of my app's shapes will have a common parent, I can create a collection of `Shape` like:\
`ArrayList<Shape> myShapes = new ArrayList<>();`

That allows me to to loop through the whole collection and report out their areas:

```java
for (Shape x : myShapes) {
    System.out.println("This shape's area is: " + x.area() + " cm2");
}
```

### Multiple Inheritance?

What if I wanted to build a huge space game with thousands of types of ships. I'd make rules for cargo ships and warships. There may be times when I want multiple inheritances to be applied. Well there are some limits here in Java. You can have multiple vertical levels, like _Ship_ --> _Warship_ --> _Battleship_ but a single ship can't inherit from two places simultaneously. Instead, there are **Interfaces**.&#x20;

![](<../.gitbook/assets/image (57).png>)

![](<../.gitbook/assets/image (199).png>)

## Concepts to Review

* Loops
  * Searching / counting while traversing an array and an ArrayList&#x20;
    * Traverse to find max and mins:\
      `public static int findLargest(int[] nums){`
    *   Interact with an ArrayList

        `public static void makeLowerCase(ArrayList<String> commands){`
    *   Keep count

        `public static int countNames(ArrayList<String> names, String target){`
    *   Shuffle methods:

        `public static void selectShuffle(int[] nums){`\
        `public static void perfectShuffle(Card[] cards){`
  * Nested loops
    *   Find common elements between two collections:

        `public static ArrayList<String> findCommonNames(String[] roster1, String[] roster2){`
* Classes
  * Encapsulation with accessor and mutator methods
  * Implementing an abstract class (with encapsulation)
    * OOP: When should you move properties and methods to an abstract layer?
      * _Name three properties or methods that would be suitable for a `Human` class and three that would go on an abstract `Mammal` class._&#x20;
    * How do you declare an abstract class and an abstract method?&#x20;
      * _Declare an abstract class called `Athlete`, give it private properties of `name`, `number`, `position`, and `is_active`._&#x20;
      * _Make a constructor._&#x20;
      * _Make accessor methods for each property._&#x20;
    * How do you declare a class to inherit the properties from an abstract class?
      * _Create classes called `SoccerAthlete` and `BasketballAthlete` that both inherit from `Athlete`._
      * _Give each class a `toString` method that returns the String, "My name is {name} and I'm a {position} in_ socce&#x72;_. I'm #{number}." **Only if they're active.**_\
        _If they're inactive, the returning String should read, "I used to be play_ basketball _as a {position}."_
    * How can you take advantage of polymorphism?
      * _Create a runner class with a main method that creates an array of `Athlete`s. Loop through them and have each one introduce themselves._&#x20;

{% embed url="http://youtu.be/BI-c6sqk3Ps?hd=1" %}

### Challenge

Submit a completed NumSet class:

{% tabs %}
{% tab title="NumSet.java" %}
```java
import java.util.ArrayList;


public class NumSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        ROUND 1 tests
        */
        
        // Create a random int array of a given length, low and high end of range
        int[] randArray = randArray(15, 0, 100);
        
        // Create a random Integer ArrayList of given length, low and high range
        ArrayList<Integer> randArrL = randArrL(8, 5, 50);
        
        // How many similar elements are in a given array and ArrayList
        System.out.print("There are this many similar elements: ");
        System.out.println(compareNums(randArray, randArrL));
        
        // printPretty takes an int array and prints it out nicely
        printPretty(randArray);
        // printPretty takes an Integer ArrayList and prints it out nicely
        printPretty(randArrL);
        
        /*
        ROUND 2 tests
        */
        
        // shuffle randomizes an int array (then calls printPretty)
        shuffle(randArray);
        
        // shuffle randomizes an Integer ArrayList (then calls printPretty)
        shuffle(randArrL);
        
        // divide all numbers by two
        divByTwo(randArray);
        divByTwo(randArrL);
        
        //sumArray
        sumArray(randArray);
        sumArray(randArrL);
        
    }
    /*
    ROUND 1 code
    */
    
    // TODO: randArray
    
    
    // TODO: randArrL
    
    
    // TODO: compareNums
    
    
    // TODO: prettyPretty (overloaded)
    
    /*
    ROUND 2 code
    */
    
    // TODO: shuffle array
    
    
    // TODO: shuffle ArrayList
    
    
    // TODO: divByTwo (overloaded)
    
    
    // TODO: sumArray (overloaded)
}
```
{% endtab %}
{% endtabs %}

### Studying for the Test

Your Unit 3 test will be a semi-randomized selection of multiple choice questions all taken from the same sources used for our Do Nows. There will be one free response question similar to the homework. Both of these parts of the test reflect the two portions of the AP test. Therefore, **the best way to study would be to review AP practice problems from our relevant topics:**

* Redo homework assignments and previous drills
* This site's Chapters 3-9: [https://runestone.academy/runestone/books/published/apcsareview/index.html](https://runestone.academy/runestone/books/published/apcsareview/index.html)
* Take a practice test: [http://ice.cc.gatech.edu/apexam\_final/index.jsp](http://ice.cc.gatech.edu/apexam_final/index.jsp)
* Do some Codingbat: [https://codingbat.com/java/AP-1](https://codingbat.com/java/AP-1)

