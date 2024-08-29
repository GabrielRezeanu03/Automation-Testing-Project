import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {


    @Test
    void Setup(){

    System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
    WebDriver webDriver  = new ChromeDriver();
        webDriver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");

    }


}
