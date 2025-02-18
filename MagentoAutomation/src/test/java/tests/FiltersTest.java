package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FiltersPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.BaseTest;
import java.time.Duration;
import java.util.List;

public class FiltersTest extends BaseTest {

    @Test
    public void testFiltersAndAddToCart() {
        driver.get("https://magento.softwaretestingboard.com/");

        // **Kyçja në llogari**
        driver.findElement(By.linkText("Sign In")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("ketli@gmail.com", "Test1234");

        // **Navigimi te Women > Tops > Jackets**
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Women"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Tops"))).click();

        FiltersPage filtersPage = new FiltersPage(driver);

        // **Hap kategorinë 'Color' para se të zgjedhësh ngjyrën**
        WebElement colorCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-role='title' and text()='Color']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", colorCategory);

        // **Sigurohu që ngjyra 'Black' është e dukshme dhe e klikueshme**
        WebElement blackColor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[aria-label='Black']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", blackColor);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".product-item")));

        // **Hap kategorinë 'Price' përpara se të zgjedhësh filtrin e çmimit**
        WebElement priceCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-role='title' and text()='Price']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", priceCategory);

        // **Kliko në filtrin $50.00 - $59.99 pasi të jetë i dukshëm**
        WebElement priceFilter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='price=50-60']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", priceFilter);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".product-item")));

        // **Verifikimi i numrit të produkteve të filtruar**
        List<WebElement> filteredProducts = filtersPage.getFilteredProducts();
        Assert.assertFalse(filteredProducts.isEmpty(), "Nuk u gjetën produkte pas filtrimit!");



    }
}
