Selenium E-Commerce Website E2E Testing

Project Overview

This project focuses on automating end-to-end (E2E) testing for an e-commerce website using Selenium WebDriver. The framework is designed using the Page Object Model (POM) and is integrated with TestNG for test management, Maven for build automation, and Java as the primary programming language. The Carina framework is utilized for enhanced automation capabilities.

Technologies Used

Programming Language: Java

Automation Tool: Selenium WebDriver

Testing Framework: TestNG

Build Tool: Maven

Design Pattern: Page Object Model (POM)

Automation Framework: Carina Framework

Project Structure

├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── ecommerce
│   │               ├── pages          # POM classes for different web pages
│   │               ├── utils          # Utility classes
│   │               └── base           # Base classes and configurations
│   └── test
│       └── java
│           └── com
│               └── ecommerce
│                   └── tests         # Test cases
├── pom.xml                           # Maven configuration file
├── testng.xml                        # TestNG configuration file
└── README.md                         # Project documentation

Key Features

Page Object Model (POM): Modular design for easy maintenance and scalability.

TestNG Integration: Structured test execution with detailed reporting.

Maven Integration: Simplified build and dependency management.

Carina Framework: Enhances automation with reusable components and utilities.

Cross-Browser Testing: Compatible with major browsers (Chrome, Firefox, Edge).

Detailed Reporting: Integrated reports for test execution results.
