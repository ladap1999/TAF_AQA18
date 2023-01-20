package pages.payment;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompletePage extends BasePage {
    @FindBy(xpath = "//*[text() = 'Checkout: Complete!']")
    public WebElement headerTitle;

    @FindBy(id = "back-to-products")
    public WebElement backHomeButton;

    public CompletePage(WebDriver driver) {
        super(driver);
    }
}

