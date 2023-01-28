package pages.payment;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage {
    @FindBy(id = "finish")
    public WebElement finishButton;

    private Logger logger = LogManager.getLogger(OverviewPage.class);

    public OverviewPage(WebDriver driver) {
        super(driver);
        logger.info("PageFactory pattern is implemented in OverviewPage");
    }
}
