package com.nixonex.tests;

import org.openqa.selenium.By;
import com.nixonex.base.BaseTest;
import com.nixonex.base.DriverManager;
import com.nixonex.pages.CartPage;
import com.nixonex.pages.CheckoutPage;
import com.nixonex.pages.ProductPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShoppingTest extends BaseTest {

	@Test
	public void shoppingFlowTest() {
	    ProductPage productPage = new ProductPage(DriverManager.getDriver());
	    CartPage cartPage = new CartPage(DriverManager.getDriver());
	    CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver());

	    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='tbodyid']/div[1]//a"))); // wait for product

	    productPage.selectFirstProduct();

	    wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.addToCartButtonLocator()));
	    productPage.addToCart();

	    wait.until(ExpectedConditions.alertIsPresent());
	    DriverManager.getDriver().switchTo().alert().accept();

	    cartPage.clickCart();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Place Order']")));
	    cartPage.clickPlaceOrder();

	    // Wait for Place Order Modal to be visible
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))); // Wait for Name field

	    checkoutPage.enterName("Test User");
	    checkoutPage.enterCountry("India");
	    checkoutPage.enterCity("Mumbai");
	    checkoutPage.enterCard("4111111111111111");
	    checkoutPage.enterMonth("12");
	    checkoutPage.enterYear("2025");

	    checkoutPage.clickPurchase();
	}
}