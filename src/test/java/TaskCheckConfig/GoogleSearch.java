package TaskCheckConfig;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class GoogleSearch {


    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("dupa");
        element.submit();
      //  driver.quit();
    }

}