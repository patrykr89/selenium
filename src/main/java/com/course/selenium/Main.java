package com.course.selenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxOptions;


public class Main {
    public static void main(String[] args) {

        FirefoxOptions options = new FirefoxOptions();
      //  options.addPreference("network.cookie.cookieBehavior", 0); // Akceptowanie ciasteczek
      //  options.addPreference("privacy.trackingprotection.enabled", false); // Wyłączenie ochrony przed śledzeniem

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        WebElement acceptButton = driver.findElement(By.id("L2AGLb"));
        acceptButton.click();
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("dupa");
        element.submit();
        //  driver.quit();
    }
}