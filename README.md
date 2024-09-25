# GitHub Activity Tracker CLI

[PROJECT URL](https://roadmap.sh/projects/github-user-activity)

A simple Command Line Interface (CLI) application that retrieves and displays recent GitHub activity for a specified user. This tool allows you to view the number of commits pushed, issues opened, and repositories starred.

## Features

- `View Recent Activity` : Displays the latest activities of a specified GitHub user.
- `Count Commits` : Shows how many commits were pushed to a specific repository.
- `Track Issues` : Notifies when a new issue is opened in a repository.
- `Starred Repositories` : Indicates if a repository has been starred by the user.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven

### Installation

1. **Clone the Repository:**

   ```bash
   git clone git@github.com:Sean-Thomo/github-activity.git
   cd github-activity
   ```

2. **Install dependencies:**

   ```bash
   mvn install
   ```

3. **Run the application:**
   ```bash
   mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="<username>"
   ```

# Example

    ```bash
    mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="Sean-Thomo"
    ```

Usage
bash

# To view the GitHub activity for a user

github-activity-cli <username>

# Output example:

    ```bash
    Pushed 3 commits to kamranahmedse/developer-roadmap

    Opened a new issue in kamranahmedse/developer-roadmap

    Starred kamranahmedse/developer-roadmap
    ```

### Activity Properties

The application retrieves and displays the following properties:
Commits: The number of commits pushed to the user's specified repository.
Issues: Indicates whether a new issue has been opened in the user's specified repository.
Stars: Shows if the user has starred the specified repository.
This README provides an overview of how to set up and use the GitHub Activity Tracker CLI, allowing users to easily monitor their GitHub activities directly from the command line.
