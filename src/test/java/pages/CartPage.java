package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    private final static String pagePath = "/cart.html";

    @FindBy(className = "title")
    public WebElement headerTitleLabel;

    @FindBy(id = "checkout" )
    public WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}
