# Task-7---Java-JDBC-Employee-Database-App

**Project Overview**

This is a simple Java console application to manage employees using a MySQL database.

**It demonstrates JDBC connectivity and CRUD operations:**

-> Create: Add new employees

-> Read: View all employees

-> Update: Modify employee details

-> Delete: Remove employees

**Technologies Used**

-> Java 8+

-> MySQL

-> JDBC Driver (mysql-connector-java)

-> IntelliJ IDEA

**Project Structure**

├── src/

│   ├── model/

│   │   └── Employee.java        # Employee class

│   ├── dao/

│   │   └── EmployeeDAO.java     # CRUD operations

│   ├── util/

│   │   └── DBConnection.java   # Database connection

│   └── MainApp.java             # Main menu and user interaction

└── lib/

    └── mysql-connector-java.jar # MySQL JDBC driver

**Database Setup**
=> Open MySQL and run the following commands :

CREATE DATABASE EmployeeDB;

USE EmployeeDB;

CREATE TABLE Employee (

    id INT PRIMARY KEY AUTO_INCREMENT,
    
    name VARCHAR(50),
    
    department VARCHAR(50),
    
    salary DOUBLE
    
);

