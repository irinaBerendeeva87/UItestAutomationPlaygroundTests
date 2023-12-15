package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClickPage extends BasePageObject {
    private final static String clickPage = "http://uitestingplayground.com/click";

    @FindBy(xpath = "//*[@class='navbar-brand']")
    protected WebElement UITAPBtn;

    @FindBy(id = "badButton")
    protected WebElement badButton;

    public ClickPage(WebDriver driver) {
        super(driver);
    }

    public void openClickPage() {
        getDriver().get(clickPage);
    }

    public void clickButton() {
        waitForVisibility(badButton).click();
    }

    public Boolean isBadButtonSuccess() {
        String classValue = waitForVisibility(badButton).getAttribute("class");
        return classValue.contains("btn-success");
    }

    public void clickUITAPBtn() {
        waitForVisibility(UITAPBtn).click();
    }
}