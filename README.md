# Java Page Object Model Example

## Overview
The following repo contains a barebone example for Selenium/Java test automation framework.

## Guidelines
Run the example tests by:

1. Clone this repository

2. Load the release directory in IntelliJ

3. Run the /src/com/tests/tests_pages.java file

## Structure and content
```
.
└── src
    └── com                 # Component files
        ├── custom          # Custom libraries and functions
        ├── pages           # Pages descriptions (regarding POM)
        └── tests           # Tests methods (TestNG annotations)
```
     

## Web driver setup
Selected web driver by default is Chrome and it can be changed:

```java
@BeforeTest
public void loadTheHomePage() throws InterruptedException {
        pageHome = new page_home();
        pageElements = new page_elements();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        }
```


## Note
Please note that this is a demo project which is not yet complete <br> i.e. there are broken things in it!