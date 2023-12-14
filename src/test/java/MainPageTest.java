import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pageobjects.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest {
    WebDriver driver;
    MainPage objMainPage;

    @DisplayName("Launch the driver")
    @BeforeEach
    public void before() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        objMainPage = new MainPage(driver);
        objMainPage.openMainPage();
    }

    @DisplayName("Teardown")
    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @DisplayName("Check page title text")
    @Test
    public void checkTitleText() {
        String expected = "UI Test Automation\nPlayground";
        String actual = objMainPage.getTitle();
        assertEquals( expected, actual,"Title doesn't equal");
    }

    @DisplayName("check ClickElement In the Overview@Test")
    @Test
    public void checkClickElementInOverview() {
        objMainPage.clickClickPageLink();
        String expectedURL = "http://uitestingplayground.com/click";
        assertEquals( expectedURL, driver.getCurrentUrl(),"Click page  didn't open");
    }
}