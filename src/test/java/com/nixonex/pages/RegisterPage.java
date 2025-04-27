package com.nixonex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    // ========== Locators ==========
    private By usernameInput = By.id("sign-username");
    private By passwordInput = By.id("sign-password");
    private By signupButton = By.xpath("//button[text()='Sign up']");

    // ========== Constructor ==========
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // ========== Actions ==========
    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSignUpButton() {
        driver.findElement(signupButton).click();
    }
    public By usernameInputLocator() {
        return usernameInput;
    }
}