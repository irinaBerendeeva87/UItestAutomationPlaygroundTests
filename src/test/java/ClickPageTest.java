import org.example.pageobjects.ClickPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.Assert.*;

public class ClickPageTest {
    WebDriver driver;
    ClickPage objClickPage;

    @Before
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

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void badButtonIsSucceedAfterClick() {
        objClickPage.clickButton();
        assertTrue(objClickPage.isBadButtonSuccess());
    }

    @Test
    public void badButtonInitialState() {
        assertFalse(objClickPage.isBadButtonSuccess());
    }

    @Test
    public void returnBackToMainPage() {
        objClickPage.openClickPage();
        objClickPage.clickUITAPBtn();
        String expectedURL = "http://uitestingplayground.com/";
        assertEquals("This is not a Main page", expectedURL, driver.getCurrentUrl());
    }
}
