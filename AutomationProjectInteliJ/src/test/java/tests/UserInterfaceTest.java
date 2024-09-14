package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UserInterfacePage;
import utilities.BaseTest;

public class UserInterfaceTest extends BaseTest {
    private UserInterfacePage userInterface;

    // Sets up the page by initializing UserInterfacePage using the driver from BaseTest.
    @BeforeMethod
    public void setUpPage() {
        this.userInterface = new UserInterfacePage(driver);
    }

    // Tests form inputs by entering data and logging the action.
    @Test
    public void testFormInputs() throws InterruptedException {
        userInterface.enterName("Marcelito");
        pauseAndLog("Name entered");

        userInterface.enterEmail("automationtesting12@gmail.com");
        pauseAndLog("Email entered");

        userInterface.enterPhoneNumber("12345678910");
        pauseAndLog("Phone number entered");

        userInterface.enterAdress("Hello, that's an automated message.");
        pauseAndLog("Address entered");
    }

    // Tests if all checkboxes for the days of the week exist.
    @Test
    public void testCheckboxExistence() throws InterruptedException {
        userInterface.verifyCheckboxExistence();
    }

    // Tests the gender selection by selecting 'Male' and verifying it.
    @Test
    public void testGenderSelection() throws InterruptedException {
        userInterface.selectGender("Male");
        pauseAndLog("Gender 'Male' selected");

        boolean isMaleSelected = userInterface.isGenderSelected("Male");
        Assert.assertTrue(isMaleSelected, "Gender selection failed.");

        if (isMaleSelected) {
            System.out.println("Test passed: Male gender selection verified.");
        } else {
            System.out.println("Test failed: Male gender selection could not be verified.");
        }
    }

    // Tests checking each day's checkbox and verifies each.
    @Test
    public void testCheckingEachDayCheckbox() {
        userInterface.checkAllDays();
        Assert.assertTrue(userInterface.isDayChecked("monday"), "Monday checkbox is not checked.");
        Assert.assertTrue(userInterface.isDayChecked("tuesday"), "Tuesday checkbox is not checked.");
        Assert.assertTrue(userInterface.isDayChecked("wednesday"), "Wednesday checkbox is not checked.");
        Assert.assertTrue(userInterface.isDayChecked("thursday"), "Thursday checkbox is not checked.");
        Assert.assertTrue(userInterface.isDayChecked("friday"), "Friday checkbox is not checked.");
        Assert.assertTrue(userInterface.isDayChecked("saturday"), "Saturday checkbox is not checked.");
        Assert.assertTrue(userInterface.isDayChecked("sunday"), "Sunday checkbox is not checked.");
        System.out.println("Test passed: All day checkboxes were checked successfully.");
    }


    @Test
    public void testCountryDropdown() {
        Assert.assertTrue(userInterface.verifyCountryDropdownExists(), "Country dropdown does not exist.");

        String expectedCountry = "Canada";
        userInterface.selectCountry(expectedCountry);
        // Assuming you add a method to get the selected country for assertion
        String selectedCountry = userInterface.getSelectedCountry();
        Assert.assertEquals(selectedCountry, expectedCountry, "The selected country does not match the expected value.");
        System.out.println("Test passed: Country '" + selectedCountry + "' is selected.");
    }

    @Test
    public void testColorDropdown() {
        Assert.assertTrue(userInterface.verifyColorDropdownExists(), "Color dropdown does not exist.");

        String expectedColor = "Green";
        userInterface.selectColor(expectedColor);
        // Assuming you add a method to get the selected color for assertion
        String selectedColor = userInterface.getSelectedColor();
        Assert.assertEquals(selectedColor, expectedColor, "The selected color does not match the expected value.");
        System.out.println("Test passed: Color '" + selectedColor + "' is selected.");
    }


    @Test
    public void testDatePicker() throws InterruptedException {
        // Verify if the date picker exists
        Assert.assertTrue(userInterface.verifyDatePickerExists(), "Date picker does not exist.");
        pauseAndLog("Date picker exists.");

        // Set the date in the format "Month Year" and select the day (e.g., "February 2025", day "11")
        userInterface.setDate("September 2024", "8");
        pauseAndLog("Date set to 11th February 2025.");

        // Verify if the correct date was entered in the date input field
        String enteredDate = userInterface.getEnteredDate();
        Assert.assertEquals(enteredDate, "09/08/2024", "The entered date does not match the expected value.");
        System.out.println("Test passed: The correct date is entered in the input field.");
    }



    // Pauses the test for a given time and logs a message.
    private void pauseAndLog(String message) throws InterruptedException {
        Thread.sleep(5000);  // 5000 milliseconds delay
        System.out.println(message);
    }
}
