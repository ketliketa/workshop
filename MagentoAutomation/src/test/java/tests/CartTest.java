package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.BaseTest;
import java.time.Duration;
import java.util.List;

public class CartTest extends BaseTest {

    @Test
    public void testAddAndRemoveSingleProductFromCart() {
        driver.get("https://magento.softwaretestingboard.com/");

        HomePage homePage = new HomePage(driver);
        List<WebElement> products = homePage.getProducts();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement product = products.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(product)).click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("product-addtocart-button")));

        ProductPage productPage = new ProductPage(driver);


        productPage.selectSizeAndColor();


        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("product-addtocart-button")));
        try {
            addToCartButton.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", addToCartButton);
        }


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-success")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-mask")));


        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();


        cartPage.removeFirstItem();

        List<WebElement> cartItems = driver.findElements(By.cssSelector(".product-item-details"));

    }
}
