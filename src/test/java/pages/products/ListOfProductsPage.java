package pages.products;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListOfProductsPage extends BasePage {
    @FindBy(className = "title")
    public WebElement headerTitleLabel;

    @FindBy(xpath = "//*[text() = 'Sauce Labs Backpack']" )
    public WebElement itemToAdd;

    private Logger logger = LogManager.getLogger(ListOfProductsPage.class);

    public ListOfProductsPage(WebDriver driver) {
        super(driver);
        logger.info("PageFactory pattern is implemented in ListOfProductsPage");
    }

    public boolean isPageOpened() {
        return headerTitleLabel.isDisplayed();
    }
}
