package shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadanie2 {
    private WebDriver driver = new ChromeDriver();

    @Given("an open browser")
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
    }

    @When("I log in with {string} and {string}")
    public void login(String email, String password) {

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();

        WebElement element = driver.findElement(By.cssSelector("#_desktop_user_info > div > a.account > span"));
        element.click();

    }

    @And("I click the Create new address button")
    public void clickCreateNewAddressButton() {



       WebElement addressButton = driver.findElement(By.cssSelector("#addresses-link > span"));
       addressButton.click();

       WebElement updateAddressButton = driver.findElement(By.cssSelector("#content > div.addresses-footer > a > i"));
       updateAddressButton.click();

    }

    @Then("I fill in the fields with the following data {string} {string} {string} {string} {string}")
    public void fillAddressForm(String alias, String address, String city, String postcode, String phone) {
        WebElement aliasField = driver.findElement(By.name("alias"));
        aliasField.clear();
        aliasField.sendKeys(alias);

        WebElement addressField = driver.findElement(By.name("address1"));
        addressField.clear();
        addressField.sendKeys(address);

        WebElement cityField = driver.findElement(By.name("city"));
        cityField.clear();
        cityField.sendKeys(city);

        WebElement postcodeField = driver.findElement(By.name("postcode"));
        postcodeField.clear();
        postcodeField.sendKeys(postcode);

        WebElement phoneField = driver.findElement(By.name("phone"));
        phoneField.clear();
        phoneField.sendKeys(phone);

        WebElement saveButton = driver.findElement(By.cssSelector("button[type='submit']"));
        saveButton.click();

        // Zamykamy przeglądarkę po zakończeniu testu
        driver.quit();
    }
}
