package pages.products;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectedProductPage extends BasePage {
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addButton;

    @FindBy(id = "back-to-products")
    public WebElement backToProductsButton;

    private Logger logger = LogManager.getLogger(SelectedProductPage.class);

    public SelectedProductPage(WebDriver driver) {
        super(driver);
        logger.info("PageFactory pattern is implemented in SelectedProductPage");
    }
}
