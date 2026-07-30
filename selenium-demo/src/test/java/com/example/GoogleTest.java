package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleTest {

    @Test
    public void googleTitleTest() {

        System.setProperty(
            "webdriver.chrome.driver",
            "/usr/local/bin/chromedriver"
        );

        ChromeOptions options = new ChromeOptions();

        options.setBinary("/opt/chrome/chrome");

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        WebDriver driver = new ChromeDriver(options);

        try {

            driver.get("https://www.google.com");

            String title = driver.getTitle();

            System.out.println("Page title: " + title);

            assertTrue(title.contains("Google"));

        } finally {

            driver.quit();

        }
    }
}