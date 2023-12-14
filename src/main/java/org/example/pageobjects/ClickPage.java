package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickPage {
    private final WebDriver driver;
    private final static String clickPage = "http://uitestingplayground.com/click";

    public ClickPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By UITAPBtn = By.xpath("//*[@class='navbar-brand']");
    private final By badButton = By.id("badButton");

    public void openClickPage() {
        driver.get(clickPage);
    }

    public void clickButton() {
        driver.findElement(badButton).click();
    }

    public Boolean isBadButtonSuccess() {
        String classValue = driver.findElement(badButton).getAttribute("class");
        return classValue.contains("btn-success");
    }

    public void clickUITAPBtn() {
        driver.findElement(UITAPBtn).click();
    }
}
