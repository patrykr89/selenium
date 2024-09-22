package shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUsername() {
        WebElement userNameLabel = driver.findElement(By.cssSelector(".account"));
        return userNameLabel.getText();
    }
}
