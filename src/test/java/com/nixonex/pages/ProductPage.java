package com.nixonex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By firstProductLink = By.xpath("//div[@id='tbodyid']/div[1]//a");  // Samsung galaxy s6
    private By addToCartButton = By.xpath("//a[text()='Add to cart']");

    // Actions
    public void selectFirstProduct() {
        driver.findElement(firstProductLink).click();
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public By addToCartButtonLocator() {
        return addToCartButton;
    }
}