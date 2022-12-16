package pages.payment;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InformationPage extends BasePage {
    private final By headerTitleLabelLocator = By.xpath("//*[text() = 'Checkout: Your Information']");

    private final By userFirstNameInputLocator = By.id("first-name");
    private final By userSecondNameInputLocator = By.id("last-name");
    private final By zipCodeInputLocator = By.id("postal-code");
    private final By continueButtonLocator = By.id("continue");

    public InformationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public WebElement getFirstNameInput() {
        return driver.findElement(userFirstNameInputLocator);
    }

    public WebElement getSecondNameInput() {
        return driver.findElement(userSecondNameInputLocator);
    }

    public WebElement getZipCodeInput() {
        return driver.findElement(zipCodeInputLocator);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButtonLocator);
    }
}
