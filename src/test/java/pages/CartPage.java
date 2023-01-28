package pages;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    private final static String pagePath = "/cart.html";

    @FindBy(className = "title")
    public WebElement headerTitleLabel;

    @FindBy(id = "checkout" )
    public WebElement checkoutButton;

    private Logger logger = LogManager.getLogger(CartPage.class);

    public CartPage(WebDriver driver) {
        super(driver);
        logger.info("PageFactory pattern is implemented in CartPage");
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}
