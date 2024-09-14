# Automation Testing Project

This project is an automation testing suite designed to interact with various elements on a practice automation website. It utilizes Selenium WebDriver with Java to automate and verify functionality such as form inputs, dropdown selections, checkboxes, radio buttons, and date pickers.

## Features

- **Automated Form Testing**: Automates the process of entering and verifying form inputs.
- **Dropdown Selection**: Verifies the existence of dropdowns and selects specified options.
- **Checkbox and Radio Button Testing**: Checks and verifies the state of checkboxes and radio buttons.
- **Date Picker Interaction**: Automates date selection using a date picker widget.
- **Comprehensive Test Coverage**: Includes assertions and validation for each automated step to ensure accuracy.

## Test Cases

### 1. Form Inputs
- **Objective**: To test the input fields for name, email, phone number, and address.
- **Test Steps**:
  1. Verify each input field exists.
  2. Enter data into the fields.
  3. Verify that the data is correctly entered.
- **Expected Outcome**: The form fields should accept the entered data.

### 2. Gender Selection
- **Objective**: To verify the functionality of gender radio buttons.
- **Test Steps**:
  1. Verify the 'Male' radio button exists.
  2. Select 'Male' and verify it's selected.
- **Expected Outcome**: The 'Male' radio button should be selectable and verifiable.

### 3. Checkbox Verification
- **Objective**: To check all checkboxes in the "Days" section.
- **Test Steps**:
  1. Verify each checkbox exists (Monday to Sunday).
  2. Check each checkbox one by one.
  3. Verify that each checkbox is selected.
- **Expected Outcome**: All checkboxes should be selected and verified.

### 4. Country Dropdown
- **Objective**: To verify the country dropdown and select a country.
- **Test Steps**:
  1. Verify the country dropdown exists.
  2. Select "Canada" from the dropdown.
  3. Verify that "Canada" is selected.
- **Expected Outcome**: The dropdown should contain "Canada" and allow selection.

### 5. Color Dropdown
- **Objective**: To verify the color dropdown and select a color.
- **Test Steps**:
  1. Verify the color dropdown exists.
  2. Select "Green" from the dropdown.
  3. Verify that "Green" is selected.
- **Expected Outcome**: The dropdown should contain "Green" and allow selection.

### 6. Date Picker
- **Objective**: To interact with the date picker and select a specific date.
- **Test Steps**:
  1. Verify the date picker field exists.
  2. Open the date picker and select "February 11, 2025".
  3. Verify the selected date is correctly entered in the input field.
- **Expected Outcome**: The input field should display "02/11/2025".

## How to Run

1. **Prerequisites**:
   - Java 22.0.2 or higher
   - IntelliJ IDEA or any compatible IDE
   - ChromeDriver installed and set up in the project
   - Selenium WebDriver dependencies included in the project

2. **Cloning the Repository**:
   ```bash
   git clone https://github.com/GabrielRezeanu03/Automation-Testing-Project.git

3. **Running the Tests**:
- Open the project in your IDE.
- Navigate to the UserInterfaceTest.java file.
- Run the tests directly from the IDE or use the following command in the terminal:
```bash
  mvn test
