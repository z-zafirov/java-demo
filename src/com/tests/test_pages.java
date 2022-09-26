package com.tests;

import com.pages.page_elements;
import com.pages.page_home;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test_pages {

    WebDriver driver;
    page_elements pageElements;
    page_home pageHome;

    // Note that the @BeforeTest will run once for all @Tests i.e. the tests will inherit the driver
    @BeforeTest
    public void loadTheHomePage() throws InterruptedException {
        pageHome = new page_home();
        pageElements = new page_elements();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(pageHome.getHomePageUrl());
        Thread.sleep(1000);
    }

    // Note that priority value is set as otherwise the tests will be run by name and this might break the inheritance chain
    @Test(priority = 0)
    public void testTheHomePageUrl() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("[ERROR] Different than the expected URL!", "https://demoqa.com/", currentUrl);
    }

    @Test(priority = 1)
    public void testGoToElementsPage() throws InterruptedException {
        // Build the expected URL
        String expectedUrl = pageHome.getHomePageUrl() + pageElements.getPageUrl();
        // Click on the elements button on the home page
        pageHome.clickElementsButton(driver);
        // Wait for the upcoming page to be loaded and then get its URL
        Thread.sleep(1500);
        String currentUrl = driver.getCurrentUrl();
        // Assert if the next page (elements) is loaded properly
        Assert.assertEquals("[ERROR] ", expectedUrl, currentUrl);
    }

    @Test(priority = 2)
    public void testGoToTextForm() throws InterruptedException {
        // Click on the text box button on the elements page
        pageElements.clickTextBoxButton(driver);
        Thread.sleep(1500);
        String currentUrl = driver.getCurrentUrl();
        // Assert if the next page (elements) is loaded properly
        Assert.assertEquals("[ERROR] ", "https://demoqa.com/text-box", currentUrl);
    }

    @AfterTest
    public void cleanup() {
        driver.quit();
    }
}
