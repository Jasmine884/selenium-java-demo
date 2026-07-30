package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class GoogleTest {

    public static void main(String[] args) {

        // Tell Selenium where ChromeDriver is
        System.setProperty(
            "webdriver.chrome.driver",
            "/usr/local/bin/chromedriver"
        );

        ChromeOptions options = new ChromeOptions();

        // Tell Selenium where Chrome browser is
        options.setBinary("/opt/chrome/chrome");

        // Codespaces/Linux container settings
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.manage().timeouts()
                  .implicitlyWait(Duration.ofSeconds(5));

            driver.get("https://www.google.com");

            System.out.println("Page title: " + driver.getTitle());

            if (driver.getTitle().contains("Google")) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED");
            }

        } finally {
            driver.quit();
        }
    }
}