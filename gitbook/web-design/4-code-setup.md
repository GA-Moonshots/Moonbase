# 4: Code Setup

### Learning Targets

* I can install and configure VS Code for web development
* I can use Live Server to preview my websites locally
* I can collaborate with others using Live Share
* I can manage my code with GitHub Desktop and GitHub Classroom
* I can follow a proper Git workflow (commit, push, pull)
* I can use professional templates as starting points for projects

### Why Do We Need All These Tools?

Think of web development like building a house. You wouldn't just show up with a hammer and start swinging – you'd need a complete toolkit, blueprints, and a way to work with others. Your development environment is your complete toolkit for building websites.

Here's what each tool does:

* **VS Code**: Your code editor – like Microsoft Word, but designed specifically for writing code
* **Live Server**: Instantly preview your website as you work – no need to constantly refresh
* **Live Share**: Collaborate in real-time, like Google Docs but for code
* **GitHub Desktop**: Manage versions of your code and sync your work across computers
* **GitHub Classroom**: Submit assignments and receive starter code

Together, these tools create a professional workflow that real web developers use every day.

### Installing VS Code

Visual Studio Code (VS Code) is a free, powerful code editor created by Microsoft. It's become the industry standard for web development.

#### Download and Install VS Code

1. Visit [https://code.visualstudio.com/](https://code.visualstudio.com/)
2. Click the big **Download** button (it will automatically detect your operating system)
3. Once downloaded, run the installer
4. Follow the installation prompts (the default settings work great)
5. Launch VS Code when installation completes

**First Launch Tips:**

* VS Code might ask if you want to install recommended extensions – say yes!
* You can customize the theme (dark mode is popular) by going to **File > Preferences > Color Theme**
* The interface might feel overwhelming at first – that's normal! You'll get comfortable with it quickly.

### Essential Extensions: Live Server and Live Share

Extensions are like apps for VS Code – they add powerful features that make development easier.

#### Installing Live Server

Live Server automatically refreshes your webpage whenever you save changes. No more manually hitting refresh!

**Installation Steps:**

1. In VS Code, click the **Extensions** icon in the left sidebar (it looks like four squares)
2. In the search box, type `Live Server`
3. Look for "Live Server" by Ritwick Dey (it should be the top result)
4. Click the **Install** button
5. Once installed, you'll see a "Go Live" button in the bottom-right corner of VS Code

**Using Live Server:**

* Open any HTML file in VS Code
* Click the **Go Live** button in the bottom-right corner
* Your default browser will open with your website
* Make changes to your code, save (Ctrl+S or Cmd+S), and watch the page automatically update!

#### Installing Live Share

Live Share lets you collaborate with others in real-time. It's like Google Docs for code – multiple people can work on the same files simultaneously.

**Installation Steps:**

1. In the **Extensions** panel, search for `Live Share`
2. Look for "Live Share" by Microsoft
3. Click **Install**
4. You'll need to sign in with your Microsoft or GitHub account
5. Follow the prompts to complete the authentication

**Why Live Share Matters:** This is your primary way to get help! When you're stuck, you'll share a Live Share link with me via Google Chat, and I can join your workspace to help you debug or work through problems together. Later in the course, you'll use Live Share to collaborate on group projects.

### Installing GitHub Desktop

GitHub Desktop makes version control visual and easy to understand. While professional developers often use command-line Git, GitHub Desktop provides a friendly interface that helps you learn the concepts.

#### Download and Install

1. Visit [https://desktop.github.com/](https://desktop.github.com/)
2. Download GitHub Desktop for your operating system
3. Run the installer
4. Launch GitHub Desktop
5. Sign in with your GitHub account (create one if you don't have it yet)

**Why GitHub?** GitHub is where developers store and share code. Think of it as a combination of:

* **Save points**: Like saving your game – you can always go back to previous versions
* **Cloud backup**: Your code is safe even if your computer crashes
* **Collaboration**: Work with others without emailing files back and forth

### Setting Up GitHub Classroom

GitHub Classroom is how you'll receive and submit assignments in this class.

#### Accepting Your First Assignment

1. I'll share a GitHub Classroom link (it looks like: `https://classroom.github.com/a/...`)
2. Click the link and authorize GitHub Classroom to access your GitHub account
3. GitHub will create a repository (repo) for you – this is your personal copy of the assignment
4. Click the green **Code** button, then **Open with GitHub Desktop**
5. Choose a location on your computer to save the project
6. Click **Clone**

**What Just Happened?** You now have a copy of the assignment on your computer that's connected to GitHub. Any changes you make can be synced back to GitHub, where I can see your work.

#### Opening Your Project in VS Code

1. In GitHub Desktop, with your repository selected, click **Repository > Open in Visual Studio Code**
2. Alternatively, in VS Code, go to **File > Open Folder** and select your cloned repository folder

Now you're ready to start coding!

### Collaboration and Getting Help: Using Live Share

When you need help, follow this process:

#### Starting a Live Share Session

1. In VS Code, click the **Live Share** button in the bottom status bar
2. Click **Start collaboration session**
3. VS Code will generate a unique link and copy it to your clipboard
4. Send this link to me via **Google Chat**
5. I'll click the link and join your workspace

**What I Can Do in Your Session:**

* See your code and files
* Edit alongside you (like Google Docs)
* Help debug problems
* Answer questions about your code

**Important**: Always start a Live Share session **before** asking for help. Don't just say "I'm stuck" – say "I'm stuck with \[specific problem], here's my Live Share link: \[link]"

#### Using Live Share for Group Projects

Later in the course, you'll work on group projects. Live Share makes this easy:

* One person hosts the Live Share session
* Team members join via the link
* Everyone can edit simultaneously
* Changes are saved on the host's computer

The host is responsible for committing and pushing changes (more on that next).

### The Git Workflow: Commit, Push, and Pull

This is the most important section to understand. Proper Git workflow prevents lost work and merge conflicts.

#### The Golden Rules

**At the END of every work session:**

1. **Commit** your changes (save a snapshot)
2. **Push** to GitHub (sync to the cloud)

**At the START of every work session:**

1. **Pull** from GitHub (download any changes)

#### Why This Matters

Imagine you work on a project at school, then go home and work on it there. If you don't push at school, your home computer won't have your latest work. If you don't pull at home before starting, you might be working on an old version.

#### Step-by-Step Git Workflow

**Committing Changes (Creating a Save Point)**

1. After working, save all your files in VS Code (Ctrl+S or Cmd+S)
2. Switch to GitHub Desktop
3. You'll see a list of changed files on the left
4. In the bottom-left corner, write a **commit message** describing what you did:
   * Good: "Added hero section with background image"
   * Bad: "stuff" or "changes"
5. Click **Commit to main**

**Think of commits like save points in a video game** – you can always go back to any commit if something breaks.

**Pushing to GitHub (Syncing to the Cloud)**

1. After committing, click **Push origin** in GitHub Desktop (top-right area)
2. This uploads your changes to GitHub
3. Now your work is backed up and I can see your progress

**Pulling from GitHub (Getting Latest Changes)**

1. At the start of each work session, open GitHub Desktop
2. Click **Fetch origin** (top-right)
3. If there are changes, click **Pull origin**
4. Now you have the latest version of your code

#### When You'll Use Pull

* **Different computers**: When you work at school then at home
* **Group projects**: When a teammate makes changes
* **My feedback**: When I make changes to your code during help sessions

#### Common Mistakes to Avoid

❌ **Don't** forget to push at the end of class – your work won't be backed up\
❌ **Don't** start working without pulling first – you might create conflicts\
❌ **Don't** write vague commit messages like "update" or "fixed stuff"\
❌ **Don't** work directly in the GitHub website – always work locally and push

✅ **Do** commit frequently (every major change)\
✅ **Do** write descriptive commit messages\
✅ **Do** push at the end of every session\
✅ **Do** pull at the start of every session

### Using Templates to Build Faster

Just like Bootstrap helps us build responsive websites faster, templates give us professional starting points for our projects.

#### Why Use Templates?

Professional web developers don't reinvent the wheel for every project. Templates provide:

* **Professional design**: Beautiful layouts created by experienced designers
* **Tested code**: Proven structures that work across browsers
* **Time savings**: Focus on customization instead of starting from scratch
* **Learning opportunities**: Study how professionals organize and style their code

#### StartBootstrap.com (Free Templates)

For most projects this semester, we'll use templates from [StartBootstrap.com](https://startbootstrap.com/).

**How to Use a StartBootstrap Template:**

1. Browse [https://startbootstrap.com/](https://startbootstrap.com/)
2. Find a template that fits your project
3. Click **Download** on the template's page
4. Unzip the downloaded file
5. In GitHub Desktop, copy the template files into your assignment repository
6. Commit and push the files
7. Open in VS Code and start customizing!

**What You'll Customize:**

* Text content (replace placeholder text with your own)
* Images (swap demo images for your own)
* Colors (modify the CSS to match your design)
* Layout adjustments (add or remove sections as needed)

#### ThemeForest.net (Premium Templates)

For final projects, we'll explore premium templates from [ThemeForest.net](https://themeforest.net/). These offer more sophisticated designs and features.

**The Template Philosophy:** Templates aren't "cheating" – they're professional practice. The skill is in:

1. Choosing the right template for your needs
2. Understanding how the template works
3. Customizing it to make it your own
4. Adding unique content and features

Think of it like music: you learn to play by practicing songs others have written, then eventually you compose your own.

### Putting It All Together: Your Daily Workflow

Here's what a typical work session looks like:

#### Starting Your Session

1. Open GitHub Desktop
2. Click **Fetch origin**, then **Pull origin** if there are changes
3. Click **Repository > Open in Visual Studio Code**
4. Start the Live Server (click "Go Live")
5. Begin coding!

#### During Your Session

1. Make changes in VS Code
2. Save frequently (Ctrl+S or Cmd+S)
3. Preview automatically updates in browser
4. If you get stuck, start a Live Share session and send me the link via Google Chat

#### Ending Your Session

1. Save all files in VS Code
2. Switch to GitHub Desktop
3. Review your changes
4. Write a descriptive commit message
5. Click **Commit to main**
6. Click **Push origin**
7. Verify the push completed (the button changes to "Fetch origin")

**Never leave class without pushing!** This is the #1 cause of lost work.

### Key Takeaways

Remember these essential practices:

* **VS Code + Live Server** = Your coding environment with instant preview
* **Live Share** = Your collaboration and help tool (always include the link when asking for help!)
* **GitHub Desktop** = Your version control and backup system
* **Commit + Push** = Your end-of-session ritual
* **Pull** = Your start-of-session ritual
* **Templates** = Your professional starting points, not shortcuts
