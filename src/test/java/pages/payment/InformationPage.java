package pages.payment;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformationPage extends BasePage {
    @FindBy(id = "first-name")
    public WebElement userFirstNameInput;

    @FindBy(id = "last-name")
    public WebElement userSecondNameInput;

    @FindBy(id = "postal-code")
    public WebElement zipCodeInput;

    @FindBy(id = "continue")
    public WebElement continueButton;

    private Logger logger = LogManager.getLogger(InformationPage.class);

    public InformationPage(WebDriver driver) {
        super(driver);
        logger.info("PageFactory pattern is implemented in InformationPage");
    }
}
