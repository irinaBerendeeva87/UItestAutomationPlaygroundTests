import org.example.pageobjects.ClickPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ClickPageTest extends TestBase {
    ClickPage objClickPage;

    @BeforeEach
    @DisplayName("Launch the driver")
    public void before() {
        setUpDriver();
        objClickPage = new ClickPage(driver);
        objClickPage.openClickPage();
    }

    @DisplayName("Teardown")
    @AfterEach
    public void teardown() {
        quitDriver();
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
        assertEquals(expectedURL, objClickPage.getCurrentUrl(), "This is not a Main page");
    }
}