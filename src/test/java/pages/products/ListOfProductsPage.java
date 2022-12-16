package pages.products;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListOfProductsPage extends BasePage {
    private final By headerTitleLabelLocator = By.className("title");
    private final By itemToAddLocator = By.xpath("//*[text() = 'Sauce Labs Backpack']");

    public ListOfProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public WebElement searchItem() {
        return driver.findElement(itemToAddLocator);
    }
}
