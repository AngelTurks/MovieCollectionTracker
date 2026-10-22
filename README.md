# Movie Collection Tracker

## About the Project

The Movie Collection Tracker is a Java application that allows users to manage a personal collection of movies. I started this project to practice Java programming and learn how data structures, algorithms, and databases can be applied to a real-world application.

Rather than building the project once and leaving it finished, I plan to continue improving it as I learn new concepts. Each version builds on the previous one and introduces new programming skills.

## Project Versions

### Version 1 — In-Memory Storage

The first version used Java's `ArrayList` to store and manage `Movie` objects while the application was running.

Each movie contains the following information:

- Title
- Genre
- Rating

**Features:**
- Add movies
- View movies
- Delete movies
- Check for duplicate movie titles

### Version 2 — JDBC and SQLite

Version 2 expands the application by connecting Java to an SQLite database using JDBC (Java Database Connectivity). Instead of storing movies only in memory, the application can save movie information in a database, allowing the data to remain available after the program closes.

**Features:**
- Add movies to the database
- View saved movies
- Delete movies by title
- Check for duplicate movie titles
- Retrieve and manage movie records using SQL queries
- Use `PreparedStatement` to pass SQL parameters safely

## Technologies Used

- **Java** — Application logic and object-oriented programming
- **JDBC** — Connecting Java to the database
- **SQLite** — Storing movie information persistently
- **SQL** — Retrieving and managing database records
- **IntelliJ IDEA** — Development environment
- **Git and GitHub** — Version control and project hosting

## Data Structures and Algorithms

### ArrayList

In Version 1, I used an `ArrayList` to store and manage `Movie` objects. This helped me understand how Java collections can dynamically hold multiple objects and how to search through a collection for matching movie titles.

### Searching

The original version searched through the `ArrayList` to find matching movie titles. In Version 2, I began using SQL queries to search for and manage movie records in a relational database.

Working with both approaches has helped me understand the difference between managing data in Java and retrieving data from a database.

## Future Improvements

- Build a graphical user interface using Java Swing.
- Improve input validation and error handling.
- Add movie search and filtering options.
- Continue practicing data structures, algorithms, and database management.
- Improve the application's organization and maintainability.

## About My Learning Journey

This project reflects my growth as a software development student. I started with an in-memory collection and expanded the application to use a relational database. Through this process, I have gained practical experience with Java, SQL, JDBC, and persistent data storage.

I plan to continue building on this project as I develop my software engineering skills.
