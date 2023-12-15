package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePageObject {

    private final static String mainPage = "http://uitestingplayground.com/";

    @FindBy(id = "title")
    protected WebElement pageTitle;

    @FindBy(linkText = "Click")
    protected WebElement linkClick;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage() {
        getDriver().get(mainPage);
    }

    public String getTitle() {
        return waitForVisibility(pageTitle).getText();
    }

    public void clickClickPageLink() {
        waitForVisibility(linkClick).click();
    }
}
