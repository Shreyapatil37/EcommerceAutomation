package com.nixonex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By nameInput = By.id("name");
    private By countryInput = By.id("country");
    private By cityInput = By.id("city");
    private By cardInput = By.id("card");
    private By monthInput = By.id("month");
    private By yearInput = By.id("year");
    private By purchaseButton = By.xpath("//button[text()='Purchase']");

    // Actions
    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterCountry(String country) {
        driver.findElement(countryInput).sendKeys(country);
    }

    public void enterCity(String city) {
        driver.findElement(cityInput).sendKeys(city);
    }

    public void enterCard(String card) {
        driver.findElement(cardInput).sendKeys(card);
    }

    public void enterMonth(String month) {
        driver.findElement(monthInput).sendKeys(month);
    }

    public void enterYear(String year) {
        driver.findElement(yearInput).sendKeys(year);
    }

    public void clickPurchase() {
        driver.findElement(purchaseButton).click();
    }
}
