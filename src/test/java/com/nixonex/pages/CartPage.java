package com.nixonex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By cartLink = By.id("cartur");
    private By placeOrderButton = By.xpath("//button[text()='Place Order']");

    // Actions
    public void clickCart() {
        driver.findElement(cartLink).click();
    }

    public void clickPlaceOrder() {
        driver.findElement(placeOrderButton).click();
    }
}