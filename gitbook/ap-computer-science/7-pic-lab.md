---
description: >-
  We will build our own photo editing tools as we study more complex nested
  loops to traverse and mutate 2D arrays.
---

# 4-A: Data Structures

## Learning Targets

* I can remove a column from a 2D array in Java.
* I can write 2D array methods for the PicLab.

## PicLab

{% embed url="https://drive.google.com/file/d/0B3bdZXDWn82MdmsyZ3VMUk5QM28/view?resourcekey=0-bW7bBz3o16g46TAgFBqobA&usp=sharing" %}

### Activity 1 & 2: Color Code

#### Eight Bits for 0 - 255

![](<../.gitbook/assets/image (72).png>)

![](<../.gitbook/assets/image (200).png>)

1. Convert 128 to binary
2. Covert 225 to binary
3. Convert 11010111 from base 2 to base 10

This is a byte.&#x20;

#### 3 Bytes to RGB&#x20;

Max red, green and blue (255, 255, 255) is white. No red, green and blue (0, 0, 0) is black. Sometimes we add a fourth byte to control alpha layer (transparency). `rgba(255, 255, 255, 255)` is opaque black.

#### Compress to Hex

Two digits in base 16, hexadecimal, can describe 0 - 255. Eight digits can contain rgba. `#FF0000FF` is opaque black.

![](<../.gitbook/assets/image (50).png>)

### Activity 3: Exploring a Picture

1. What is the row index for the top left corner of the picture?
2. What is the column index for the top left corner of the picture?
3. The width of the picture is 640. What is the right most column index?
4. The height of the picture is 480. What is the bottom most row index?

![](<../.gitbook/assets/image (10).png>)

![](<../.gitbook/assets/image (206).png>)

![](<../.gitbook/assets/image (156).png>)

### Activity 4: Picture Arrays

![](<../.gitbook/assets/image (256).png>)

![Okay, so you know how a regular array works](<../.gitbook/assets/image (162).png>)

![Now a 2D arrays has a whole array in each spot](<../.gitbook/assets/image (8).png>)

![You don't have to just use dumb old ints. Instantiated objects are cool too](<../.gitbook/assets/image (59).png>)



![We use row-major to define the 2D array of pixels that makes a picture](<../.gitbook/assets/image (144).png>)

![2D traversals go row by row and each column between each row](<../.gitbook/assets/image (264).png>)

### Activity 5: Get working

{% code title="PictureTester.java" %}
```java
        //A5
        testKeepOnlyBlue();
        testKeepOnlyRed();
        testNegate();
        testGrayscale();
        testFixUnderwater();
        //A6
        testMirrorVertical();
        testMirrorVerticalRightToLeft();
        testMirrorHorizontal();
        testMirrorHorizontalBotToTop();
        testMirrorDiagonal();
        //A7
        testMirrorArms();
        testMirrorGull();
        //A8
        testCollage();
        //A9
        testEdgeDetection2();
```
{% endcode %}

{% embed url="https://www.youtube.com/watch?v=uq2BeJv639E&feature=youtu.be&hd=1" %}

## Review

### NumGrid Practice

{% embed url="https://www.youtube.com/watch?v=PhXow4qJBQs" %}

{% code title="NumGroup.java" %}
```java
public interface NumGroup {
    
    /**
     * Provides a total sum of its contained numbers
     * @return accumulated total
     */
    int sum();

    /**
     * Organizes its contained numbers to be sorted from least to great
     * using the selection sort algorithm
     */
    void sort();

    /**
     * Rearranges its contained numbers using the selection shuffle algorithm
     */
    void shuffle();

    /**
     * Displays the contained numbers in a returned string
     * @return formatted String display
     */
    String toString();
    
}
```
{% endcode %}

### Exercises

1. Imagine a circumstance where you might use an interface and an abstract class. Create and implement the interface and abstract class. Instantiate objects that extend these.  Create a polymorphic container or method.
2. Calculate the sum of an indicated column from an extremely rare occurrence of  a 2D ArrayList:\
   `public static int sumColumn(int col, List<List<Integer>> grid){`
3. Remove a row from a 2D array:\
   `public static String[][] removeRow(int row, String[][] names){`
4. Calculate the sum of an entire 2D array:\
   `public static double sum(double[][] grid){`
5. Count the number of occurrences of a given number in a 2D array\
   `public static int count(int[][] grid, int target){`
6. Add a new column to a 2D array of Pixels with the average color at the end of the image\
   `public static Pixel[][] addAverageColumn(Pixel[][] picture){` \
   `// each Pixel has .getColor() which gives a single int` \
   `// return an array that's one column wider, containing the average of every color in that row` \
   `// you can set the color of a pixel by using .setColor() and passing the method the average of that row's .getColor()`\
   `}`
7. Convert an RGB value like 220, 175, 205 to a hex value&#x20;
8.  We have an array of Friends, `Friends[] friends`, and we want to make sure that each of our friends has the items they requested from the store. `Friend.getItems()` returns an array of Item objects (Item implements the `Comparable` interface so you can use `.equals()` to compare two items). If the Item is not on the shopping list, we'll add it to an `ArrayList<Item>` called `requests`. The Item class also has a publicly accessible boolean that marks if the Item has been claimed: `Item.claimed`.&#x20;

    \
    `public ArrayList<Item> checkShoppingList(Friends[] friends, ArrayList<Item> list){`&#x20;

