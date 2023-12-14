import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pageobjects.ClickPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class ClickPageTest {
    WebDriver driver;
    ClickPage objClickPage;

    @BeforeEach
    @DisplayName("Launch the driver")
    public void before() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        objClickPage = new ClickPage(driver);
        objClickPage.openClickPage();
    }

    @DisplayName("Teardown")
    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @DisplayName("BadButton changed the class name")
    @Test
    public void badButtonIsSucceedAfterClick() {
        objClickPage.clickButton();
        assertTrue(objClickPage.isBadButtonSuccess());
    }

    @DisplayName("BadButton button is in the initial state")
    @Test
    public void badButtonInitialState() {
        assertFalse(objClickPage.isBadButtonSuccess());
    }

    @DisplayName("Return back to MainPage")
    @Test
    public void returnBackToMainPage() {
        objClickPage.openClickPage();
        objClickPage.clickUITAPBtn();
        String expectedURL = "http://uitestingplayground.com/";
        assertEquals( expectedURL, driver.getCurrentUrl(),"This is not a Main page");
    }
}
