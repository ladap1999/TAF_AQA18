package pages.payment;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage {
    @FindBy(xpath = "//*[text() = 'Checkout: Overview']" )
    public WebElement headerTitleLabel;

    @FindBy(id = "finish")
    public WebElement finishButton;

    public OverviewPage(WebDriver driver) {
        super(driver);
    }
}
