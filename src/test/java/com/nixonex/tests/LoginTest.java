package com.nixonex.tests;

import com.nixonex.base.BaseTest;
import com.nixonex.pages.HomePage;
import com.nixonex.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void userLoginTest() throws InterruptedException {
        HomePage homePage = new HomePage(com.nixonex.base.DriverManager.getDriver());
        LoginPage loginPage = new LoginPage(com.nixonex.base.DriverManager.getDriver());

        homePage.clickLogin();
        Thread.sleep(2000); // Small wait for popup

        loginPage.enterUsername("TestUser123");
        loginPage.enterPassword("TestPass123");
        loginPage.clickLoginButton();

        // Add proper validation later
        Thread.sleep(3000);
    }
}