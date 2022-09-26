package com.pages;

import org.openqa.selenium.By;

public class page_home {

    String baseUrl = "https://demoqa.com";
    By elementsButtonLocator = By.xpath("//*[@class='category-cards']/div[1]");


    public String getHomePageUrl() {
        return baseUrl;
    }

    public By getElementsButtonLocator() {
        return elementsButtonLocator;
    }

}
