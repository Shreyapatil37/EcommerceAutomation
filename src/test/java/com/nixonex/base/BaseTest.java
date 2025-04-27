package com.nixonex.base;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.nixonex.utilities.ExtentReportManager;
import com.nixonex.utilities.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected ExtentReports extent;
    protected ExtentTest test;
    protected WebDriver driver;

    @BeforeMethod
    public void setup(java.lang.reflect.Method method) {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
        driver.get("https://www.demoblaze.com/");

        extent = ExtentReportManager.getReports();
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            // Handle unexpected alert before taking screenshot
            DriverManager.getDriver().switchTo().alert().accept();
        } catch (Exception e) {
            // No alert present, continue
        }

        if (result.getStatus() == ITestResult.SUCCESS) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, result.getName());
            test.pass("Test Passed").addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, result.getName());
            test.fail(result.getThrowable()).addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped");
        }

        DriverManager.quitDriver();
        extent.flush();
    }
}