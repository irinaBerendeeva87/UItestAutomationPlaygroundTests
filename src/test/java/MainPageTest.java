import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pageobjects.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MainPageTest {
    WebDriver driver;
    MainPage objMainPage;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        objMainPage = new MainPage(driver);
        objMainPage.openMainPage();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void checkTitleTextTest(){
        String expected = "UI Test Automation\nPlayground";
        String actual = objMainPage.getTitle();
        Assert.assertEquals("Title doesn't equal", expected, actual);
    }

    @Test
    public void checkClickElementInOverviewTest(){
        objMainPage.clickClickPageLink();
        String expectedURL = "http://uitestingplayground.com/click";
        Assert.assertEquals("Click page  didn't open",expectedURL, driver.getCurrentUrl());
    }

}
