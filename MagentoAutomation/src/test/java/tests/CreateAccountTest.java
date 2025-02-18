package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class CreateAccountTest extends BaseTest {

    @Test
    public void testCreateAccount() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.linkText("Create an Account")).click();
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

        driver.findElement(By.id("firstname")).sendKeys("Ketli");
        driver.findElement(By.id("lastname")).sendKeys("Keta");
        driver.findElement(By.id("email_address")).sendKeys("ketli@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Test1234");
        driver.findElement(By.id("password-confirmation")).sendKeys("Test1234");
        driver.findElement(By.cssSelector("button[title='Create an Account']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".message-success")).isDisplayed());
        test.pass("Account created successfully.");
    }
}
