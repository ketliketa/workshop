package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;
    private By userName = By.cssSelector("span.logged-in");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserName() {
        return driver.findElement(userName).getText();
    }

    public byte[] getPageTitle() {
        return new byte[0];
    }


}

