package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class FiltersPage {
    WebDriver driver;
    WebDriverWait wait;

    // Lokatorët
    private By jacketsMenu = By.id("ui-id-11");
    private By blackColorFilter = By.cssSelector("a[aria-label='Black']");
    private By priceFilter = By.cssSelector("a[href*='price=50-60']");
    private By products = By.cssSelector(".product-item");

    public FiltersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Klikimi në Jackets
    public void selectJacketsCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(jacketsMenu)).click();
    }

    // Zgjedhja e ngjyrës Black
    public void filterByColor() {
        wait.until(ExpectedConditions.elementToBeClickable(blackColorFilter)).click();
    }

    // Zgjedhja e filtrit të çmimit
    public void filterByPrice() {
        wait.until(ExpectedConditions.elementToBeClickable(priceFilter)).click();
    }

    // Marrja e listës së produkteve të filtruar
    public List<WebElement> getFilteredProducts() {
        wait.until(ExpectedConditions.presenceOfElementLocated(products));
        return driver.findElements(products);
    }
}