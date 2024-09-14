package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the updated chromedriver executable
        System.setProperty("webdriver.chrome.driver", "E://WebDrivers//chromedriver.exe");

        // Initialize the WebDriver
        driver = new ChromeDriver();

        // Maximize the window
        driver.manage().window().maximize();

        // Set a default wait time for elements to appear
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to the test site
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser and end the session
        if (driver != null) {
            driver.quit();
        }
    }
}
