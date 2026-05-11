---
description: >-
  We start to delve into algorithms and basic AI with our first
  CollegeBoard-issued lab. We will learn about String manipulation so we can
  have a conversation with our computer.
---

# 2-B: Strings

## Learning Targets

* I can use common String methods to modify a string.
* I can evaluate the contents of a String.
* I can use a Scanner to take inputs.&#x20;
* I can isolate an object in the user's input and use it in Magpie's response.

## Magpie Lab

CollegeBoard used to have three official projects, **Magpie**, **Elevens**, and **PicLab**. A few years ago, they dropped those four and started four new ones: Celebrity, Consumer Review, DataLab, and Steganography. But I still think Magpie is the best lab for starters.&#x20;

### What's a magpie?&#x20;

A bid that can mimic speech.

{% embed url="https://www.youtube.com/watch?v=qNwFQpotg90" %}

![Taken from giantfreakinrobot.com](<../.gitbook/assets/image (94).png>)

![](<../.gitbook/assets/image (169).png>)

Check out the chatbot in Activity 1:

{% file src="../.gitbook/assets/Magpie Lab Student Guide_updated_Sept_2014.pdf" %}
Student Guide from College Board
{% endfile %}

## Strings

Check out the [official documentation](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html).&#x20;

Strings are a special data type in Java. They're not primitives but they behave a little differently than most instantiated objects. In many ways, they're an array of primitive `char` objects. The biggest difference is that Strings also have many helpful methods to change their formatting, to search and examine the Strings, and lots of other helpful tools.&#x20;

<figure><img src="../.gitbook/assets/image (276).png" alt=""><figcaption></figcaption></figure>

<figure><img src="../.gitbook/assets/image (282).png" alt=""><figcaption></figcaption></figure>

<figure><img src="../.gitbook/assets/image (275).png" alt=""><figcaption></figcaption></figure>

###

### StringExplorer

Create a new class in our project called **StringExplorer** and drop this code in:

{% tabs %}
{% tab title="StringExplorer.java" %}
```java
import java.util.Scanner;

public class StringExplorer
{
	public static void main(String[] args)
	{
      // Count down with a "T minus 5"
      
      // Declare and instantiate a Scanner
    
      // infinite loop 
      
          // take an input
    
          // repeat input + message
    
          // implement "equals" to stop with the word "stop"
          
      
      /*
      ---------------------------
          SAMPLE STUFF
      ---------------------------
      */
  		String sample = "The quick brown fox jumped over the lazy dog.";
  
      // Print the sample and add a blank line after
      System.out.println("OUR SAMPLE:");
  		
      //  Demonstrate the length method.
  		int l = 9999;
  		System.out.println ("sample.length() = " + l);
  
  		//  Demonstrate the indexOf method.
  		int position = 9999;
  		System.out.println ("sample.indexOf(\"quick\") = " + position);
		
      //  Demonstrate the toLowerCase method.
		  String lowerCase = sample.toLowerCase();
		  System.out.println ("sample.toLowerCase() = " + lowerCase);
		  System.out.println ("After toLowerCase(), sample = " + sample);
				
		  //  toUpperCase


      // lastIndexOf


      // substring
      
      
      // equals

	}
}

```
{% endtab %}
{% endtabs %}

![Why you can't use == to compare the contents of two instantiated objects](<../.gitbook/assets/image (180).png>)

## Activity 2 Starter Code

Now we're going to add a few new classes to the project.&#x20;

#### Magpie.java

{% tabs %}
{% tab title="MagpieRunner.java" %}
```java
import java.util.Scanner;


/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner
{
	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		Magpie maggie = new Magpie();
		
		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye"))
		{
			System.out.println (maggie.getResponse(statement));
			statement = in.nextLine();
		}
	}
	
}

```
{% endtab %}

{% tab title="Magpie.java" %}
```java
/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>

 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}
	
	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		
		return response;
	}
}

```
{% endtab %}
{% endtabs %}

Now write a commit message to bookmark these changes and push the new version to GitHub. Then following along with the exercises in Activity 2.&#x20;

{% embed url="https://www.youtube.com/watch?v=-cLjQvGFrBA" %}

## Activity 3: Better method

Magpie's current structure and use of `.indexOf("something") >= 0` is full of logic errors. It's caps sensitive, it can't tell if you've entered no response at all, and it sees the word **"no"** inside of **"know"**. Let's do better.&#x20;

Let's drop these two methods into your Magpie class ([they're overloaded](https://beginnersbook.com/2013/05/method-overloading/)):

```java
/**
 * Search for one word in phrase. The search is not case
 * sensitive. This method will check that the given goal
 * is not a substring of a longer string (so, for
 * example, "I know" does not contain "no").
 *
 * @param statement the string to search
 * @param goal the string to search for
 * @param startPos the character of the string to begin the search at
 * @return the index of the first occurrence of goal in
 *         statement or -1 if it's not found
 */
private int findKeyword(String statement, String goal,
		int startPos)
{
	String phrase = statement.trim().toLowerCase();
	goal = goal.toLowerCase();

	// The only change to incorporate the startPos is in
	// the line below
	int psn = phrase.indexOf(goal, startPos);

	// Refinement--make sure the goal isn't part of a
	// word
	while (psn >= 0)
	{
		// Find the string of length 1 before and after
		// the word
		String before = " ", after = " ";
		if (psn > 0)
		{
			before = phrase.substring(psn - 1, psn);
		}
		if (psn + goal.length() < phrase.length())
		{
			after = phrase.substring(
					psn + goal.length(),
					psn + goal.length() + 1);
		}

		// If before and after aren't letters, we've
		// found the word
		if (((before.compareTo("a") < 0) || (before
				.compareTo("z") > 0)) // before is not a
										// letter
				&& ((after.compareTo("a") < 0) || (after
						.compareTo("z") > 0)))
		{
			return psn;
		}

		// The last position didn't work, so let's find
		// the next, if there is one.
		psn = phrase.indexOf(goal, psn + 1);

	}

	return -1;
}

/**
 * Search for one word in phrase. The search is not case
 * sensitive. This method will check that the given goal
 * is not a substring of a longer string (so, for
 * example, "I know" does not contain "no"). The search
 * begins at the beginning of the string.
 * 
 * @param statement
 *            the string to search
 * @param goal
 *            the string to search for
 * @return the index of the first occurrence of goal in
 *         statement or -1 if it's not found
 */
private int findKeyword(String statement, String goal)
{
	return findKeyword(statement, goal, 0);
}
```

Now we've got to update our `getResponse` method to use this instead of `indexOf`.&#x20;

Let's use this chart to walk through what's happening:

<figure><img src="../.gitbook/assets/image (277).png" alt=""><figcaption></figcaption></figure>

## Activity 4: Slice and dice

{% embed url="https://www.loom.com/share/f5c1401dda0e4ee0b4557f1e6fe688ea" %}

Okay, now you're ready to follow along the student guide with the class and ask some questions along the way.&#x20;



## Review

Let's review some basics before we move onto our next, advanced concept. Now's the time to hit codingbat, SoloLearn, Codecademy, or other training websites to practice. You want the basics down pat so you can focus on new concepts as we move forward.&#x20;

{% tabs %}
{% tab title="Drills.java" %}
```java
public class Drills {
    
    public static void main(String[] args) {
    
        // Declare 5 different data types with initial values (include at least one array)
        
        // A standard for loop printing numbers 1-5 with their squares (i.e. num * num)
        
        // Create an int array with test scores: 85, 92, 78, 95, 88, 73, 91
        // Use a for-each loop to traverse and print each score
        
        // Calculate and print the average of the test scores array
        
        // Count how many scores are above 85 using a loop
        
        // An infinite loop that collects user input
        
            // A short-circuit conditional with four tests
            // (check if input is: positive && less than 100 && even && divisible by 5)
        
                // Break the loop if all conditions pass
        
        // Loop through each char in the String "DataScience"
        // Print each character on a separate line with its index
                
        // Given String word = "Algorithm", print only the first three letters
        
        // Print all the odd numbers from 1-100 in rows of 10 numbers each
        
        // Create a Scanner and take a String input (ask for user's name)
        
        // Create a Scanner, take a number, print a countdown from that number to 0
        // Format: "T-minus [number]..."
        
        // Create a double array for temperatures: {72.5, 68.3, 75.1, 69.8, 71.2}
        // Find and print the highest and lowest temperatures
        
    }
    
    // Create a method that compares two arrays and returns the larger average
    // Include a proper JavaDoc comment
    
    // Create a method that formats a number as a percentage (returns String)
    // Include a proper JavaDoc comment
    
}
```
{% endtab %}
{% endtabs %}

{% embed url="https://www.youtube.com/watch?v=98j3e1YI4v0" %}

{% embed url="https://www.youtube.com/watch?v=zvS-mYXfx3o" %}
