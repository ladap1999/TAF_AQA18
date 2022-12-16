package pages.payment;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompletePage extends BasePage {

    private final By headerTitleLabelLocator = By.xpath("//*[text() = 'Checkout: Complete!']");

    private final By backHomeButtonLocator = By.id("back-to-products");

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public WebElement searchBackHomeButton() {
        return driver.findElement(backHomeButtonLocator);
    }
}
