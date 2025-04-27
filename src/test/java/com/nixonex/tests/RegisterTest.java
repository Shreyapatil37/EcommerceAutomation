package com.nixonex.tests;

import com.nixonex.base.BaseTest;
import com.nixonex.base.DriverManager;
import com.nixonex.pages.HomePage;
import com.nixonex.pages.RegisterPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest extends BaseTest {

    @Test
    public void userRegistrationTest() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        RegisterPage registerPage = new RegisterPage(DriverManager.getDriver());

        homePage.clickSignUp();

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.usernameInputLocator()));

        registerPage.enterUsername("TestUser123");
        registerPage.enterPassword("TestPass123");
        registerPage.clickSignUpButton();

        // Alert handling will happen automatically during tearDown now
    }
}