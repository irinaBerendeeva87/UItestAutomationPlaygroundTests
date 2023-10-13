import io.qameta.allure.junit4.DisplayName;
import org.example.pageobjects.ClickPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ClickPageTest {
    WebDriver driver;
    ClickPage objClickPage;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        objClickPage = new ClickPage(driver);
        objClickPage.openClickPage();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("Check  Button color changing after click")
    public void checkButtonColorAfterClick(){
        objClickPage.clickButton();
        assertEquals( "rgba(1, 123, 250, 1)",objClickPage.getButtonColor());
    }

    @Test
    @DisplayName("Check initial Button color")
    public void checkInitialButtonColor(){
        assertEquals( "rgba(0, 123, 255, 1)",objClickPage.getButtonColor());
    }

    @Test
    @DisplayName("Check changing Button color")
    public void checkButtonColorChanging(){
        String oldColor = objClickPage.getButtonColor();
        objClickPage.clickButton();
        String newColor = objClickPage.getButtonColor();
        assertNotEquals( oldColor,newColor);
    }

    @Test
    @DisplayName("Return back from  Click Page to Main Page")
    public void returnBackToMainPage(){
        objClickPage.clickUITAPBtn();
        String expectedURL = "http://uitestingplayground.com/";
        assertEquals("This is not a Main page",expectedURL, driver.getCurrentUrl());
    }
}
