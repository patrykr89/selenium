package shop;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Zadanie {
    public WebDriver driver;


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
    }

    @Test
    public void shouldLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("patroz@abc.pl", "patroz");

        WebElement Clothes = this.driver.findElement(By.id("category-3"));
        Clothes.click();

        WebElement sweter = this.driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div[1]/div[2]/article/div/div[1]/a/img"));
        sweter.click();

        WebElement selectElement = this.driver.findElement(By.id("group_1"));
        selectElement.click();
        Select select = new Select(selectElement);
        select.selectByVisibleText("M");

        WebElement quantityWanted = this.driver.findElement(By.id("quantity_wanted"));

        Actions actions = new Actions(driver);
        actions.moveToElement(quantityWanted).click().doubleClick().perform();
        quantityWanted.sendKeys(Keys.DELETE);
        quantityWanted.sendKeys("5");


        WebElement addToCart = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button"));
        addToCart.click();
        WebElement chceckoutOne = this.driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a"));
        chceckoutOne.click();
        WebElement chceckoutTwo = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[2]/div[1]/div[2]/div/a"));
        chceckoutTwo.click();

        WebElement confirmAddress = this.driver.findElement(By.name("confirm-addresses"));
        confirmAddress.click();

        WebElement confirmDeliveryOption = this.driver.findElement(By.name("confirmDeliveryOption"));
        confirmDeliveryOption.click();
        WebElement paymentOption = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[1]/section[4]/div/div[2]/div[1]/div/span/input"));
        paymentOption.click();
        WebElement paymentOptionChceckBox = this.driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        paymentOptionChceckBox.click();
        WebElement placeOrder = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[1]/section[4]/div/div[3]/div[1]/button"));
        placeOrder.click();

    }

    @After

    public void cleanup() throws IOException {

        // Pobranie screenshotu jako pliku
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Zapisanie screenshotu do pliku
        FileUtils.copyFile(screenshot, new File("screenshot.png"));
        System.out.println("Screenshot został zapisany!");

        //  driver.quit();
    }

}
