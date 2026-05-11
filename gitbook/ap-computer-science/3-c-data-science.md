---
description: Using custom objects to bring life to each row in a spreadsheet
---

# 3-C: Data Science

## Learning Targets

* I can create a class to represent a row of real-world data.
* I can parse a CSV file by splitting strings and converting data types.
* I can write constructors that initialize multiple instance variables from parsed data.
* I can implement utility methods that perform calculations using instance data.

### Why Data Science in AP CSA?

You've learned how to create custom classes, work with ArrayLists, and traverse collections. Now it's time to put all these skills together with real-world data. Data science is about taking raw information and extracting meaningful insights from it. In Java, we do this by:

1. **Modeling data** as custom classes
2. **Reading files** to populate collections of objects
3. **Analyzing data** through methods that compute results

This combination of object-oriented programming and data analysis is exactly what you'll encounter on the AP exam and in professional software development.

### Data Classes: Objects as Rows

Think about a spreadsheet. Each row represents one thing (a person, a product, a measurement) and each column represents an attribute of that thing. In Java, we can model each row as an object.

For example, imagine you're working with cereal nutrition data:

```
100% Bran,70,10,5,0.33
All-Bran,70,9,5,0.33
Apple Jacks,110,1,11,1.0
```

Each line is one cereal. The columns are: name, calories, fiber, carbohydrates, and serving size in cups.

#### Creating the Data Class

We'll create a `Cereal` class where each instance represents one row:

```java
public class Cereal {
    // Instance variables - one for each column
    private String name;
    private int calories;
    private int fiber;
    private int carbohydrates;
    private double cups;
    
    // Constructor takes all the data for one row
    public Cereal(String name, int calories, int fiber, int carbs, double cups) {
        this.name = name;
        this.calories = calories;
        this.fiber = fiber;
        this.carbohydrates = carbs;
        this.cups = cups;
    }
    
    // Accessor methods
    public String getName() { return name; }
    public int getCalories() { return calories; }
    // ... more getters
}
```

Let's say you read this line from a file: `"100% Bran,70,10,5,0.33"`

Here's how to break it apart:

```java
String line = "100% Bran,70,10,5,0.33";

// Step 1: Split by comma
String[] parts = line.split(",");
// Result: ["100% Bran", "70", "10", "5", "0.33"]

// Step 2: Extract each piece
String name = parts[0];           // Already a String
int calories = Integer.parseInt(parts[1]);     // Convert to int
int fiber = Integer.parseInt(parts[2]);        // Convert to int
int carbs = Integer.parseInt(parts[3]);        // Convert to int
double cups = Double.parseDouble(parts[4]);    // Convert to double

// Step 3: Create the object
Cereal cereal = new Cereal(name, calories, fiber, carbs, cups);
```

**Important:** The `split()` method returns an array of Strings. You need to convert numeric strings to their proper types using `parseInt()` and `parseDouble()`.

#### Reading the Whole File

To process an entire CSV file, you'll combine file reading with this parsing logic:

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataLoader {
    private ArrayList<Cereal> cereals;
    
    public DataLoader() {
        cereals = new ArrayList<>();
        
        try {
            File file = new File("cerealSubset.csv");
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                // Parse the line
                String[] parts = line.split(",");
                String name = parts[0];
                int calories = Integer.parseInt(parts[1]);
                int fiber = Integer.parseInt(parts[2]);
                int carbs = Integer.parseInt(parts[3]);
                double cups = Double.parseDouble(parts[4]);
                
                // Create object and add to collection
                Cereal c = new Cereal(name, calories, fiber, carbs, cups);
                cereals.add(c);
            }
            
            scanner.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
    
    public ArrayList<Cereal> getCereals() {
        return cereals;
    }
}
```

**Pattern to remember:** Read line → Split line → Parse each part → Create object → Add to ArrayList

### Utility Methods: Objects Computing Their Own Results

One of the most powerful aspects of OOP is that objects can answer questions about themselves. Instead of writing static methods that take an object as a parameter, we write instance methods that operate on the object's data directly.

Let's switch to a different example to illustrate this concept. Imagine you're working with book sales data:

```java
public class Book {
    private String title;
    private String author;
    private double price;
    private int pageCount;
    private int unitsSold;
    
    public Book(String title, String author, double price, int pages, int sold) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.pageCount = pages;
        this.unitsSold = sold;
    }
    
    // Accessor methods
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public int getPageCount() { return pageCount; }
    public int getUnitsSold() { return unitsSold; }
}
```

Now let's add utility methods that let each book compute its own results:

```java
/**
 * Calculate total revenue generated by this book
 */
public double totalRevenue() {
    return price * unitsSold;
}

/**
 * Calculate price per page (value metric)
 */
public double pricePerPage() {
    return price / pageCount;
}

/**
 * Determine if this is a bestseller (over 10,000 copies sold)
 */
public boolean isBestseller() {
    return unitsSold > 10000;
}

/**
 * Compare value: is this cheaper per page than another book?
 */
public boolean isBetterValueThan(Book other) {
    return this.pricePerPage() < other.pricePerPage();
}
```

#### Why Write Methods Inside the Class?

Compare these two approaches:

**Static approach** (what you've done before):

```java
public static double calculateRevenue(Book b) {
    return b.getPrice() * b.getUnitsSold();
}

// Usage:
double revenue = calculateRevenue(myBook);
```

**Instance method** (what we're doing now):

```java
public double totalRevenue() {
    return price * unitsSold;
}

// Usage:
double revenue = myBook.totalRevenue();
```

The instance method is:

* **Cleaner:** No need to pass the object as a parameter
* **Encapsulated:** Direct access to private instance variables
* **Object-oriented:** The book knows how to calculate its own data
* **Reusable:** Can be called on any Book object

#### Using Utility Methods in Analysis

Once you've added utility methods to your data class, you can write clean analysis code:

```java
// Find books that generated over $50,000 in revenue
public ArrayList<Book> findHighRevenue() {
    ArrayList<Book> results = new ArrayList<>();
    
    for (Book b : books) {
        if (b.totalRevenue() > 50000) {
            results.add(b);
        }
    }
    
    return results;
}

// Find the book with the best value (lowest price per page)
public Book bestValue() {
    if (books.isEmpty()) return null;
    
    Book best = books.get(0);
    
    for (int i = 1; i < books.size(); i++) {
        Book current = books.get(i);
        if (current.pricePerPage() < best.pricePerPage()) {
            best = current;
        }
    }
    
    return best;
}
```

Notice how readable this is. The logic is clear because each object knows how to compute its own values. You're not cluttering your analysis code with calculations—the Book class handles that internally.

#### The Power of Encapsulation

<figure><img src="../.gitbook/assets/smart.gif" alt=""><figcaption></figcaption></figure>

By putting these calculations inside the Book class, you get several benefits:

1. **Less repetition:** Write `book.totalRevenue()` instead of `book.getPrice() * book.getUnitsSold()` everywhere
2. **Easier maintenance:** If the revenue calculation changes (maybe add sales tax?), you only update it in one place
3. **Better organization:** All book-related logic lives in the Book class
4. **Cleaner analysis:** Your filtering and searching methods focus on logic, not arithmetic

This is exactly what encapsulation is about—keeping related data and behaviors bundled together.

### Putting It All Together

<figure><img src="../.gitbook/assets/assemble.gif" alt=""><figcaption></figcaption></figure>

The workflow for data science in Java:

1. **Design your data class** - What fields do you need? What calculations make sense?
2. **Write the constructor** - Takes all the data needed to create one instance
3. **Add accessor methods** - Getters for each field
4. **Add utility methods** - Calculations and comparisons
5. **Parse the CSV file** - Read, split, convert types, create objects
6. **Store in a collection** - Usually an ArrayList
7. **Analyze the data** - Filtering, finding max/min, calculating statistics

This is the same pattern professional developers use when working with databases, APIs, and data files.

### Data Lab Assignment

You're now ready to work with real-world nutritional data! In the next assignment, you'll:

* Download authentic cereal data from Kaggle
* Create a complete data class with multiple fields
* Write a CSV parser that loads dozens of records into an ArrayList
* Implement filtering and max-finding algorithms
* Discover a data quality issue in the dataset

The lab includes warm-up activities with live weather data using the Sinbad library, showing you how professional data scientists verify their data sources and fetch real-time information.

**You'll get a GitHub Classroom link to set up the project.** Follow the detailed instructions in the README to complete each activity. This lab brings together everything you've learned in Unit 3: class creation, ArrayLists, and traversal algorithms.
