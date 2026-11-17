**Student Database Management System**

This project is a Java application that connects to a PostgreSQL database using JDBC. It allows users to perform basic CRUD (Create, Read, Update, Delete) operations on student records.


**Technologies Used**
- Java
- PostgreSQL
- JDBC
- Maven 
- IntelliJ IDEA

**Database Setup**
1. Create a PostgreSQL database named student_database.
2. Open the database/students.sql file.
3. Execute the SQL statements in pgAdmin to create the students table and insert the initial student records. 

**Database Configuration**
Update the database connection settings in StudentManager.java to match your PostgreSQL configuration:

URL: jdbc:postgresql://localhost:5432/student_database
Username: Your PostgreSQL username
Password: Your PostgreSQL password


**CRUD Operations**
The application implements the following operations:

- getAllStudents(): Retrieves and displays all student records.
- addStudent(): Adds a new student to the database.
- updateStudentEmail(): Updates a student's email using their student ID.
- deleteStudent(): Deletes a student using their student ID.

**How to Run**
- Clone or download this repository.
- Open the project in IntelliJ IDEA.
- Configure the PostgreSQL database connection.
- Ensure Maven dependencies are loaded.
- Run Main.java to execute the CRUD operations.

**Project Structure**
src/main/java/ – Contains the Java source files.
database/students.sql – Contains the database creation and initial data insertion script.
pom.xml – Contains Maven project dependencies.
README.md – Project documentation.
