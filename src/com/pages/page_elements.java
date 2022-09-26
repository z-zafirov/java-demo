package com.pages;

import org.openqa.selenium.WebDriver;

public class page_elements {

        String pageUrl = "/elements";

        public String getPageUrl() {
            return pageUrl;
        }

        public WebDriver goToElementsPage(WebDriver driver, String url) {
            driver.get(url);
            return driver;
        };

}
