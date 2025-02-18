package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class EmptyCartTest extends BaseTest {

    @Test
    public void testEmptyCart() {
        driver.get("https://magento.softwaretestingboard.com/");

        // Hapja e Shportës
        driver.findElement(By.cssSelector(".action.showcart")).click();

        // Fshirja e artikujve
        while (driver.findElements(By.cssSelector(".cart-table .item")).size() > 0) {
            driver.findElement(By.cssSelector(".action.delete")).click();
        }

        // Verifikimi i mesazhit të zbrazjes
        Assert.assertTrue(driver.getPageSource().contains("You have no items in your shopping cart."));
    }
}
