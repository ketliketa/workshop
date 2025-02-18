package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.AccountPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.linkText("Sign In")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("ketli@gmail.com", "Test1234");


    }
}
