package pages.products;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectedProductPage extends BasePage {

    private final By addButtonLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By backToProductsButtonLocator = By.id("back-to-products");

    public SelectedProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return backToProductsButtonLocator;
    }

    public WebElement findAddButton() {
        return driver.findElement(addButtonLocator);
    }
}
