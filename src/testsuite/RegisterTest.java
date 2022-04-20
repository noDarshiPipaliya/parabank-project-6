package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        WebElement registerlink = driver.findElement(By.linkText("Register"));
        registerlink.click();

        String expectedMessage = "Signing up is easy!";
        WebElement actualMessageelement = driver.findElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals("navigate to page area ", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        WebElement registerlink = driver.findElement(By.linkText("Register"));
        registerlink.click();

        WebElement firstname = driver.findElement(By.id("customer.firstName"));
        firstname.sendKeys("Devanshi");

        WebElement lastname = driver.findElement(By.name("customer.lastName"));
        lastname.sendKeys("Pipaliya");

        WebElement address = driver.findElement(By.name("customer.address.street"));
        address.sendKeys("Margeholes");

        WebElement city = driver.findElement(By.name("customer.address.city"));
        city.sendKeys("Watford");

        WebElement state = driver.findElement(By.name("customer.address.state"));
        state.sendKeys("Northen Ireland");

        WebElement zipcode = driver.findElement(By.id("customer.address.zipCode"));
        zipcode.sendKeys("1234");

        WebElement phone = driver.findElement(By.name("customer.phoneNumber"));
        phone.sendKeys("9536148210");

        WebElement SSN= driver.findElement(By.name("customer.ssn"));
        SSN.sendKeys("563245");

        WebElement username = driver.findElement(By.name("customer.username"));
        username.sendKeys("Dev");

        WebElement password = driver.findElement(By.name("customer.password"));
        password.sendKeys("devanshi");

        WebElement confirm = driver.findElement(By.name("repeatedPassword"));
        confirm.sendKeys("devanshi");

        WebElement registerbutton = driver.findElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        registerbutton.click();

        String expectedMessage = "Your account was created successfully. You are now logged in.";
        WebElement actualMessageelement = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals("navigate to page area ", expectedMessage, actualMessage);










    }


}
