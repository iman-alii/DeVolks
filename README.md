# DeVolkskrant
This project covers some of the Positive and Negative scenarios for the Volkskrant Login Page https://www.volkskrant.nl/
**Frameworks & Tools & Language**
*Java JDK 16
*Selenium
*Junit 5
*Intellij IDEA
*GitHub & GitHub Actions
*Maven
Scope
The test was done only for the Login page in https://www.volkskrant.nl/ together with search and navigation between tiles scenarios
Test Coverage
Scenarios covered:

Full Login Scenario (Positive Critical Path)
Negative Scenarios which should lead to an unsuccessful login (Negative Scenarios) e.g wrong/missing email or passowrd
Browser Back and Forward (Positive Scenarios)covered in the Tile Navigation Scenario
Search functionality for Random and known keywords

Approach & Considerations
Used maven to manage dependencies and build
All test cases should pass
![2022-07-21 (4)](https://user-images.githubusercontent.com/77646020/180223403-38a4c066-6e9b-4e1d-9d1f-0289681cd218.png)
Test Suite Structure that contains before and after test scenarios 
Used Page Object Model
Every test case has it's own driver session to run independently
The driver closes after each test
The test runs in headfull mood but also can run headless if you remove the comment from this line in base.basepage.options.addArguments("--headless"); (line25)
Each test case has test objective commented inside it
Also the whole test suite is commented to be easy to follow the test steps

How to run the test
Locally: Clone the project to your local Machine through gitbub App or by downloading it --> Open the project using intellij IDE --> Go to terminal --> Run the project using the Maven command : mvn clean verify (as in the screenshot)
![2022-07-21 (3)](https://user-images.githubusercontent.com/77646020/180223207-2dfcd83f-367a-4682-81c2-002a2dce0161.png)
Make sure that you have on your machine Java 16.0.2 & mvn 3.8.4
Locally: Clone the project to your local Machine --> Open the project using intellij IDE --> You can run each individual test by right click --> run 
![2022-07-21](https://user-images.githubusercontent.com/77646020/180219815-4deabc47-0d89-4e27-a62e-110a60f705a4.png)

Challenges and Problems :
Switching between iFrame to accept cookies and swich back to default frame
Using Automation entering a wrong or missing password for a registered account leads to 406 Not Found page 
The button (LOGIN ALS ABONEE) was not visible yesterday while bulding the test so used the Services --> Login instead 
There was an error "selenium / seleniumwire unknown error: cannot determine loading status from unknown error: unexpected command response" I googled it and found out that it's related to the driver version 103 so I downloaded manually the 104 

Improvements if I had more time: 
CICD using GitHub Actions 
Possibility to change browser/enviroment 
Code Refactor 
