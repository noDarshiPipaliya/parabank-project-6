package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {


    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Dev");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("devanshi");

        WebElement loginbutton = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        loginbutton.click();

        String expectedMessage = "Accounts Overview";
        WebElement actualMessageelement = driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals("navigate to page area ", expectedMessage, actualMessage);

    }

    @Test
    public void verifyTheErrorMessage() {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("selenium");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("postman");

        WebElement loginbutton = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        loginbutton.click();

        String expectedMessage = "Error!";
        WebElement actualMessageelement = driver.findElement(By.xpath("//h1[contains(text(),'Error!')]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals("navigate to page area ", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldLogoutSuccessfully() {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("dev");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("devanshi");

        WebElement loginbutton = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        loginbutton.click();

        WebElement logoutbutton = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
        logoutbutton.click();

        String expectedMessage = "Customer Login";
        WebElement actualMessageelement = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals("navigate to page area ", expectedMessage, actualMessage);


    }
}
