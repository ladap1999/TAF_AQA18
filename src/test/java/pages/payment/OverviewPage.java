package pages.payment;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage extends BasePage {
    private final By headerTitleLabelLocator = By.xpath("//*[text() = 'Checkout: Overview']");
    private final By finishButtonLocator = By.id("finish");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public WebElement searchFinishButton() {
        return driver.findElement(finishButtonLocator);
    }
}
