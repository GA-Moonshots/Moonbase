---
description: >-
  We will review the basics of object-oriented programming and how Java is
  configured. This is primarily a build-up of vocabulary. This unit moves
  quickly as there are limited practical applications.
---

# 1-B: How Java Works

## Learning Targets

* I can describe the benefits of using the JRE.
* I can identify the three types of errors when programming.
* I can describe the attributes of Java’s main function, including scope, instantiation, and return value.

{% embed url="http://youtu.be/9jIF4aZarKk?hd=1" %}

## Java is Portable

Java's strength is also its greatest weakness. The JVM allows the same Java code to run on almost any machine. It does this by hosting a virtual machine, a simulated computer system that facilitates the interpretation of your code.   &#x20;

<figure><img src="../.gitbook/assets/image (289).png" alt=""><figcaption><p>We use the JDK so the JVM and its JIT will show us our code in the final result we call the JRE.</p></figcaption></figure>

<figure><img src="../.gitbook/assets/image (285).png" alt=""><figcaption></figcaption></figure>

### Respect to Dennis Ritchie

With his partner Ken Thompson, Dennis Ritchie solved a very big program for programmers. It's hard enough for programmers to design an app. It's just crazy if you have to program an app in assembly, telling the CPU and RAM how to handle each and every little operation. Programming languages like Ritchie's C allow coders to focus more on the app and less on how it has to interact with the machine. It's like the first, really powerful book of spells made for magicians.&#x20;

If you'd like to learn more about the history of Computer Science, I [found this video](https://www.youtube.com/watch?v=fCDsn7OTNMg) to be very charming.

<figure><img src="../.gitbook/assets/image (288).png" alt=""><figcaption></figcaption></figure>

### Just in Time

When you install an app on your computer, the JIT will interpret the developer's code and set it up to run on the given machine. The install process takes longer and it might not be compatible with every machine, but then the app is ready to run very quickly. Java doesn't play like that. Instead, it interprets the code in real-time while running through a virtual machine. So while it can run pretty much everywhere, there's a bottleneck in how fast it can perform.&#x20;

#### Extra Information

Who made the Java programming language? When and why?[ Check it out](https://en.wikipedia.org/wiki/Java_\(programming_language\)#History).&#x20;

## Editing Code

The JDK is a type of [SDK](https://en.wikipedia.org/wiki/Software_development_kit). We'll use tools to build apps like an [IDE](https://en.wikipedia.org/wiki/Integrated_development_environment) and an [interpreter](https://en.wikipedia.org/wiki/Interpreter_\(computing\)). We're going to have lots of bugs or errors in our code. They will take three different forms...

### Three types of errors

1. **Syntax** or **Compile-time**: You can't compile this code. Something is way off and Java won't touch your mess.
2. **Runtime** or **crash**: Something breaks while it's running as if you asked the computer to divide a number by zero.&#x20;
3. **Logic**: Everything runs okay. Nothing crashes. However, the answer you get is just wrong. If your app says `4+4` is `10`, you've got a logic error.&#x20;

## Java's Code Structure

In Java, **all code** must be written inside **methods**, and all methods belong to a **class**. This means that every Java program is essentially a collection of classes, each containing methods that define the behavior of your program.

* **Classes** must be defined inside a file that shares the **exact same name** as the class. For example, if your class is called `MyProgram`, then the file must be named `MyProgram.java`.
* The entry point of every Java program is the **`main` method**, which tells Java where to begin executing your code.

{% hint style="info" %}
Exceptions

While every class usually matches its file name, there are a few exceptions:

* You can define **inner classes** within another class.
* Files may contain more than one class, but only **one** can be `public` and match the file name.
{% endhint %}

### Java's Main Method

Every Java app starts the same way, from a static method that returns nothing. Let's introduce these concepts now. Many of these ideas will seem strange, but they'll make more sense as you build up your background knowledge. You'll come back to this section later on and smile. But for right now, let's take a plunge into the deep end of the pool. We'll hurry right back to the basics but let's take a peek at how all Java apps start.\
`public static void main(String[] args){}`  <=\[ _all Java apps start from that method!_ ]

<figure><img src="../.gitbook/assets/image (273).png" alt=""><figcaption></figcaption></figure>

### Scope

Who can access this method or this variable? The main method must always be `public` because it's being triggered from outside the class.&#x20;

### Instantiation&#x20;

Does this method belong to an instance of the class? What's the difference between an instance and a static class? Imagine we're building a game. We've got one file or **class** that describes a player and another that has helpful functions like drawing a random number. Every person that plays the game gets their own **instance** of the player class. It tracks each player's health and abilities in the computer's memory. But the helper class can be static, just one master copy--no instance needed.

### Return Type

As the method closes, does it return anything? If so, what type of data is returned? The main method must always return **void** because it's the point of origin--there's nothing to return data to.&#x20;

## Install&#x20;

Version control is essential for tracking changes in your code and collaborating on projects. We'll install Git command line tools first, then GitHub Desktop for a user-friendly interface.

### 1. Git and GitHub Desktop

#### For Windows Users

**Installing Git for Windows**

1. Visit [git-scm.com](https://git-scm.com/download/win)
2. Download the latest version for Windows
3. Run the installer with these recommended settings:
   * Use Visual Studio Code as Git's default editor
   * Use Git from the command line and also from 3rd-party software
   * Use the OpenSSL library
   * Checkout Windows-style, commit Unix-style line endings
   * Use Windows' default console window
4. Complete the installation

**Verify Git Installation:**

1. Open Command Prompt
2. Type: `git --version`
3. You should see the Git version number

#### For Mac Users

**Installing Git via Xcode Command Line Tools**

1. Open Terminal (Applications > Utilities > Terminal)
2. Type: `git --version`
3. If Git isn't installed, macOS will prompt you to install developer tools
4. Click "Install" and follow the prompts
5. Wait for the installation to complete (this may take several minutes)

**Verify Git Installation:**

1. In Terminal, type: `git --version`
2. You should see the Git version number

#### GitHub Desktop Installation (Both Platforms)

Now that Git is installed, we'll add GitHub Desktop for an easier graphical interface:

1. Visit [desktop.github.com](https://desktop.github.com/)
2. Download GitHub Desktop for your operating system (Windows or Mac)
3. Install the application
4. Launch GitHub Desktop
5. Sign in with your GitHub account (create one at [github.com](https://github.com) if needed)
6. Complete the initial setup wizard

#### Configure Git Settings

1. Open Command Prompt (Windows) or Terminal (Mac)
2.  Configure Git with your information:bash

    ```bash
    git config --global user.name "Your Name"
    git config --global user.email "your.email@example.com"
    ```

### 2. Java Development Kit (JDK) Installation

The AP Computer Science A course requires Java 17 or later (Java 22 recommended). We'll provide multiple options for JDK installation.

#### Option A: Eclipse Temurin (Recommended)

Eclipse Temurin is a free, open-source JDK that's widely used in educational settings.

**For Windows:**

1. Visit [adoptium.net](https://adoptium.net/)
2. Select your operating system (Windows)
3. Choose the latest LTS version (Java 17 or 21)
4. Download the .msi installer
5. Run the installer with default settings
6. **Important**: Check "Set JAVA\_HOME variable" during installation

**For Mac:**

1. Visit [adoptium.net](https://adoptium.net/)
2. Select macOS
3. Choose the latest LTS version
4. Download the .pkg installer
5. Run the installer with default settings

#### Option B: Oracle Java SE

Oracle provides the official Java implementation, though it requires registration for recent versions.

**For Windows/Mac:**

1. Visit [oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)
2. Create a free Oracle account if prompted
3. Download the appropriate installer for your operating system
4. Run the installer with default settings

### 3. Visual Studio Code Setup

{% embed url="https://code.visualstudio.com/Download" %}

#### Required Extensions

Install these extensions for optimal Java development:

**Essential Java Extensions:**

1. **Extension Pack for Java** (Microsoft)
   * Includes: Language Support, Debugger, Test Runner, Maven, Project Manager
   * Install this first - it includes most of what you need
2. **Code Runner** (Jun Han)
   * Allows quick running of Java files with Ctrl+F5

**Helpful Additional Extensions:** 3. **Bracket Pair Colorizer 2** (CoenraadS)

* Colors matching brackets for easier code reading

4. **GitLens** (GitKraken)
   * Enhanced Git capabilities within VS Code
5. **Java Code Generators** (Sohibe)
   * Helps generate common Java code patterns
6. **vscode-icons** (VSCode Icons Team)
   * Better file icons for easier navigation



#### Configuring Java in VS Code

1. Open VS Code
2. Press Ctrl+Shift+P (Cmd+Shift+P on Mac) to open the command palette
3. Type "Java: Cofigure Java Runtime" and select it
4. Verify that your installed JDK appears in the list
5. If not detected automatically, manually add the path to your JDK installation

