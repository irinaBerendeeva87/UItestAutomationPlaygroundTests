import org.example.pageobjects.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest extends TestBase {
    private MainPage objMainPage;


    @DisplayName("Launch the driver")
    @BeforeEach
    public void before() {
        setUpDriver();
        objMainPage = new MainPage(driver);
        objMainPage.openMainPage();
    }

    @DisplayName("Teardown")
    @AfterEach
    public void teardown() {
        quitDriver();
    }

    @DisplayName("Check page title text")
    @Test
    public void checkTitleText() {
        String expected = "UI Test Automation\nPlayground";
        String actual = objMainPage.getTitle();
        assertEquals(expected, actual, "Title doesn't equal");
    }

    @DisplayName("check ClickElement In the Overview@Test")
    @Test
    public void checkClickElementInOverview() {
        objMainPage.clickClickPageLink();
        String expectedURL = "http://uitestingplayground.com/click";
        assertEquals(expectedURL, objMainPage.getCurrentUrl(), "Click page  didn't open");
    }
}