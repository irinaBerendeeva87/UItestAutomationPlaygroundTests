import org.example.pageobjects.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MainPageTest {
    WebDriver driver;
    MainPage objMainPage;

    @Before
    public void before() {
        driver = new ChromeDriver();
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
