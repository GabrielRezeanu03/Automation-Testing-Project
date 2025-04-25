package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.NoSuchElementException;
import java.time.Duration;
import java.util.List;

public class UserInterfacePage {
    private WebDriver driver;

    public UserInterfacePage(WebDriver driver) {
        this.driver = driver;
    }

    // Inputs a string into the 'name' field.
    public void enterName(String name) {
        WebElement NameInput = driver.findElement(By.id("name"));
        NameInput.sendKeys(name);
    }

    // Inputs a string into the 'email' field.
    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys(email);
    }

    // Inputs a string into the 'phone' field.
    public void enterPhoneNumber(String phone) {
        WebElement phoneNumberInput = driver.findElement(By.id("phone"));
        phoneNumberInput.sendKeys(phone);
    }

    // Inputs a string into the 'address' field.
    public void enterAdress(String adress) {
        WebElement adressInput = driver.findElement(By.id("textarea"));
        adressInput.sendKeys(adress);
    }

    // Clicks the gender radio button if it's not already selected.
    public void selectGender(String gender) {
        WebElement genderRadioButton = driver.findElement(By.id("male"));
        if (!genderRadioButton.isSelected()) {
            genderRadioButton.click();
        }
    }

    // Checks if the gender radio button is selected.
    public boolean isGenderSelected(String gender) {
        WebElement genderRadioButton = driver.findElement(By.id("male"));
        return genderRadioButton.isSelected();
    }

    // Verifies the existence of checkboxes for each day of the week.
    public void verifyCheckboxExistence() {
        String[] days = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
        for (String day : days) {
            List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and @value='" + day + "']"));
            if (!checkboxes.isEmpty()) {
                System.out.println(day + " checkbox exists.");
            } else {
                System.out.println(day + " checkbox does not exist.");
            }
        }
    }

    // Checks all checkboxes for each day of the week.
    public void checkAllDays() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String[] days = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
        for (String day : days) {
            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox' and @value='" + day + "']")));
            if (!checkbox.isSelected()) {
                checkbox.click();
                System.out.println("Checked: " + day);
            }
        }
    }

    // Verifies if a specific checkbox for a day is checked.
    public boolean isDayChecked(String day) {
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox' and @value='" + day + "']"));
        return checkbox.isSelected();
    }

    public boolean verifyCountryDropdownExists() {
        List<WebElement> countryDropdown = driver.findElements(By.id("country"));
        boolean exists = !countryDropdown.isEmpty();
        System.out.println("Country dropdown " + (exists ? "exists." : "does not exist."));
        return exists;
    }

    public void selectCountry(String countryName) {
        Select countrySelect = new Select(driver.findElement(By.id("country")));
        countrySelect.selectByVisibleText(countryName);
        System.out.println("Selected country: " + countryName);
    }

    public String getSelectedCountry() {
        Select countrySelect = new Select(driver.findElement(By.id("country")));
        return countrySelect.getFirstSelectedOption().getText();
    }

    // Existing methods for color dropdown
    public boolean verifyColorDropdownExists() {
        List<WebElement> colorDropdown = driver.findElements(By.id("colors"));
        boolean exists = !colorDropdown.isEmpty();
        System.out.println("Color dropdown " + (exists ? "exists." : "does not exist."));
        return exists;
    }

    public void selectColor(String colorName) {
        Select colorSelect = new Select(driver.findElement(By.id("colors")));
        colorSelect.selectByVisibleText(colorName);
        System.out.println("Selected color: " + colorName);
    }

    public String getSelectedColor() {
        Select colorSelect = new Select(driver.findElement(By.id("colors")));
        return colorSelect.getFirstSelectedOption().getText();
    }

    // Method to check if the date picker input field exists
    public boolean verifyDatePickerExists() {
        try {
            WebElement datePickerInput = driver.findElement(By.id("datepicker")); // Assuming the ID is "datepicker"
            return datePickerInput.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Method to set a specific date in the date picker
    public void setDate(String expectedMonthYear, String day) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Închide cookie banner dacă apare
        try {
            WebElement cookieBanner = driver.findElement(By.id("cookieChoiceDismiss"));
            if (cookieBanner.isDisplayed()) {
                cookieBanner.click();
                System.out.println("Cookie banner closed.");
            }
        } catch (Exception e) {
            System.out.println("No cookie banner present.");
        }

        // Deschide datepicker-ul
        WebElement datePickerInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("datepicker")));
        datePickerInput.click();

        int maxTries = 24; // max 2 ani în avans
        int tries = 0;

        while (tries < maxTries) {
            WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-title")));
            String currentMonthYear = header.getText().trim();

            if (currentMonthYear.equals(expectedMonthYear)) {
                break;
            }

            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-datepicker-next")));
            nextButton.click();

            // Așteaptă schimbarea lunii
            wait.until(ExpectedConditions.not(
                    ExpectedConditions.textToBePresentInElementLocated(By.className("ui-datepicker-title"), currentMonthYear)
            ));

            tries++;
        }

        // Selectează ziua dorită
        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + day + "']")));
        dayElement.click();

        System.out.println("Date selected: " + day + " " + expectedMonthYear);
    }

    // Method to get the entered date from the input field
    public String getEnteredDate() {
        WebElement datePickerInput = driver.findElement(By.id("datepicker")); // Assuming the ID is "datepicker"
        return datePickerInput.getAttribute("value");
    }

}
