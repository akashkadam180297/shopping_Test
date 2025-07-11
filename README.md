🛒 Shopping Test Automation Project
This project demonstrates automated UI testing for a shopping web application using two different frameworks and technologies:

✅ Selenium with Java using IntelliJ IDEA

✅ Playwright with TypeScript using Visual Studio Code

📁 Frameworks & Tools Used
1. Selenium (Java)
Language: Java

Build Tool: Maven

Editor: IntelliJ IDEA

Testing Framework: TestNG

Reporting Tool: Allure Reports

JDK Version: 17.0.12

✅ Required Maven Dependencies:
xml
Copy
Edit
<!-- TestNG -->
<dependency>
  <groupId>org.testng</groupId>
  <artifactId>testng</artifactId>
  <version>7.8.0</version>
  <scope>test</scope>
</dependency>

<!-- Allure TestNG -->
<dependency>
  <groupId>io.qameta.allure</groupId>
  <artifactId>allure-testng</artifactId>
  <version>2.29.0</version>
</dependency>

<!-- Selenium -->
<dependency>
  <groupId>org.seleniumhq.selenium</groupId>
  <artifactId>selenium-java</artifactId>
  <version>4.33.0</version>
</dependency>
2. Playwright (TypeScript)
Language: TypeScript

Editor: Visual Studio Code

Test Runner: Playwright Test

Node Version: v22.14.0

NPM Version: 11.4.2

✅ Project Setup Steps:
bash
Copy
Edit
# Initialize npm project
npm init -y

# Install required dev dependencies
npm i -D playwright typescript ts-node @playwright/test

# Install Playwright browsers
npx playwright install
▶️ Running the Tests
✅ Playwright (TypeScript)
To run a specific test file:

bash
Copy
Edit
npx playwright test Shopping.spec.ts
To view the test execution report in HTML:

bash
Copy
Edit
npx playwright show-report
✅ Selenium (Java)
Use IntelliJ IDEA or the command line (e.g., mvn test) to run your TestNG test cases.

To generate and view Allure reports:

bash
Copy
Edit
# Generate the report
allure generate allure-results --clean -o allure-report

# Open the report in browser
allure open allure-report
📌 Notes
Make sure Java and Node.js are properly installed and configured in your system.




        
