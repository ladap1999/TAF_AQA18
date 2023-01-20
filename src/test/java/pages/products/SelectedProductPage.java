package pages.products;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectedProductPage extends BasePage {
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addButton;

    @FindBy(id = "back-to-products")
    public WebElement backToProductsButton;

    public SelectedProductPage(WebDriver driver) {
        super(driver);
    }
}
