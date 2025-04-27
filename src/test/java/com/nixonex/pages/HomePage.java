package com.nixonex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    // ========== Locators ==========
    private By signUpLink = By.id("signin2"); // Sign Up link
    private By loginLink = By.id("login2");   // Log In link
    private By homeLink = By.xpath("//a[@class='nav-link' and text()='Home ']"); // Home tab

    // ========== Constructor ==========
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ========== Actions ==========
    public void clickSignUp() {
        driver.findElement(signUpLink).click();
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public boolean isHomeLinkDisplayed() {
        return driver.findElement(homeLink).isDisplayed();
    }
}
