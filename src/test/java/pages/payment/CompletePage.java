package pages.payment;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompletePage extends BasePage {
    @FindBy(xpath = "//*[text() = 'Checkout: Complete!']")

    private Logger logger = LogManager.getLogger(CompletePage.class);

    @FindBy(id = "back-to-products")
    public WebElement backHomeButton;

    public CompletePage(WebDriver driver) {
        super(driver);
        logger.info("PageFactory pattern is implemented in CompletePage");
    }
}

