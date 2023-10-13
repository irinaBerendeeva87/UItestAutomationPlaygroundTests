package org.example.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickPage {
    private final WebDriver driver;
    private final static String clickPage = "http://uitestingplayground.com/click";

    public ClickPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By UITAPBtn = By.xpath("//a[@class='navbar-brand' and @href='/']");
    private final By badButton = By.id("badButton");

    @Step("Open 'Click Page'")
    public void openClickPage() {
        driver.get(clickPage);
    }

    @Step("Click badButton")
    public void clickButton() {
        driver.findElement(badButton).click();
    }

    @Step("Get badButton color")
    public String getButtonColor() {
        return driver.findElement(badButton).getCssValue("background-color");
    }

    @Step("Click UITAP button")
    public void clickUITAPBtn() {
        driver.findElement(UITAPBtn).click();
    }
}
