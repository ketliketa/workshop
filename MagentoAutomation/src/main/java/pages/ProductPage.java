package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage extends BasePage {

    private By sizeOption = By.cssSelector("div.swatch-option.text");
    private By colorOption = By.cssSelector("div.swatch-option.color");
    private By productPrice = By.cssSelector(".price-wrapper .price");
    private By addToCartButton = By.id("product-addtocart-button");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // **Merr çmimin e produktit**
    public double getProductPrice() {
        String priceText = wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice)).getText();
        return Double.parseDouble(priceText.replace("$", "").replace(",", ""));
    }

    // **Zgjedh madhësinë dhe ngjyrën automatikisht**
    public void selectSizeAndColor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // **Zgjedh madhësinë e parë të disponueshme**
        WebElement size = wait.until(ExpectedConditions.elementToBeClickable(sizeOption));
        size.click();

        // **Zgjedh ngjyrën e parë të disponueshme**
        WebElement color = wait.until(ExpectedConditions.elementToBeClickable(colorOption));
        color.click();
    }

    // **Klikimi i butonit "Add to Cart"**
    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // **Sigurohu që opsionet janë zgjedhur**
        selectSizeAndColor();

        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCart.click();
    }


}
