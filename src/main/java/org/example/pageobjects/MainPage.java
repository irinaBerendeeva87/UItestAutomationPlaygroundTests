package org.example.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    private final static String mainPage = "http://uitestingplayground.com/";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By pageTitle = By.id("title");

    private final By linkClick = By.linkText("Click");

    @Step("Open main Page")
    public void openMainPage() {
        driver.get(mainPage);
    }

    @Step("Check Title ")
    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    @Step("Click  ClickPage link")
    public void clickClickPageLink() {
        driver.findElement(linkClick).click();
    }
}
