package pages.payment;

import baseEntities.BasePage;
import org.openqa.selenium.By;
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

    public InformationPage(WebDriver driver) {
        super(driver);
    }
}
