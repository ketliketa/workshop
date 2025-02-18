package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class HomePage extends BasePage {
    private By signInLink = By.linkText("Sign In");
    private By products = By.cssSelector(".product-item");

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("https://magento.softwaretestingboard.com/");
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
    }

    public List<WebElement> getProducts() {
        return driver.findElements(products);
    }



}
