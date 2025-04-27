---
**About Me:**  
Junior QA Automation Engineer passionate about building reliable test automation frameworks and continuously improving quality assurance processes.
---

# UI Automation Practice – Test Automation Practice Blog

This project contains automated UI tests I developed while practicing Selenium WebDriver automation on the [Test Automation Practice](https://testautomationpractice.blogspot.com/) demo site.

I focused mainly on interacting with input fields, radio buttons, checkboxes, dropdowns, and date pickers.

---

## What I Did
✅ Built a UI automation framework using Java, Selenium WebDriver, TestNG, and Maven  
✅ Implemented Page Object Model (POM) structure for maintainability  
✅ Automated form input actions (Name, Email, Phone, Address)  
✅ Validated gender selection using radio buttons  
✅ Checked existence and functionality of weekly day checkboxes  
✅ Selected countries and colors from dropdown menus  
✅ Interacted with date picker widget and set specific dates  
✅ Used WebDriverManager for easy driver management  

---

## Why I Did This
I worked on this project as part of my transition towards automation testing after obtaining my ISTQB CTFL certification.

The goal was to strengthen my practical skills by building a fully functional automation framework — not just learning from tutorials, but applying concepts to a real UI.

---

## Platform I Tested
[https://testautomationpractice.blogspot.com/](https://testautomationpractice.blogspot.com/)

This site offers a variety of UI elements ideal for practicing different types of Selenium interactions.

---

## How to Execute Tests
- To run all tests:
  ```bash
  mvn test
  ```
- To run a specific test class:
  ```bash
  mvn -Dtest=UserInterfaceTest test
  ```

Test results will be available under `target/surefire-reports/`.

---

## Project Organization
The code is organized using the Page Object Model (POM) design pattern, separating page-specific actions from test logic. This improves test maintainability, scalability, and readability.

| Module         | Path                                |
|----------------|-------------------------------------|
| Base Setup     | `src/test/java/utilities/BaseTest.java` |
| Page Objects   | `src/test/java/pages/UserInterfacePage.java` |
| Test Cases     | `src/test/java/tests/UserInterfaceTest.java` |
| Driver         | `src/test/resources/chromedriver.exe` |
| Build Config   | `pom.xml` |

---

## Challenges Faced
- Handled dynamic cookie consent banners during test execution.
- Implemented custom wait conditions for date picker navigation across months and years.

---

## Tools I Used
- Java 17 (programming language)
- Selenium WebDriver 4.23.1 (browser automation)
- TestNG 7.8.0 (test management)
- Maven (build tool and dependency management)
- WebDriverManager 5.8.0 (driver setup automation)
- Chrome browser (for test execution)

---

## Future Improvements
- Integrate ExtentReports for enhanced graphical HTML reporting.
- Add negative test scenarios for field validations.
- Configure a simple CI/CD pipeline using GitHub Actions.
- Extend test coverage to include more advanced UI interactions.

---

## Note
This is a personal learning project intended to practice automation testing skills.  
It is not affiliated with any company, client, or external organization.

---

# Happy Testing!
