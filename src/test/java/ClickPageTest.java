import io.qameta.allure.junit4.DisplayName;
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
    @After
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
        assertEquals("This is not a Main page", expectedURL, driver.getCurrentUrl());
    }
}
