package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage {
    private By cartIcon = By.cssSelector(".minicart-wrapper .action.showcart");
    private By cartItems = By.cssSelector(".product-item-details"); // Produkte në shportë
    private By loader = By.cssSelector(".loading-mask");
    private By cartContainer = By.cssSelector(".block-minicart");
    private By removeItemButton = By.cssSelector(".action.delete");
    private By confirmRemoveButton = By.cssSelector(".modal-popup.confirm .action-primary");
    private By emptyCartMessage = By.cssSelector(".cart-empty");

    public CartPage(WebDriver driver) {
        super(driver);
    }


    public void openCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cart.click();

        // **Sigurohemi që shporta është ngarkuar plotësisht**
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartContainer));
    }


    public void removeFirstItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        List<WebElement> items = driver.findElements(cartItems);
        if (items.isEmpty()) {
            throw new RuntimeException("Shporta është bosh, nuk ka asnjë produkt për të fshirë!");
        }

        WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(removeItemButton));
        removeButton.click();


        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(confirmRemoveButton));
        confirmButton.click();


    }
}
