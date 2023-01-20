package pages.products;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListOfProductsPage extends BasePage {
    @FindBy(className = "title")
    public WebElement headerTitleLabel;

    @FindBy(xpath = "//*[text() = 'Sauce Labs Backpack']" )
    public WebElement itemToAdd;

    public ListOfProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return headerTitleLabel.isDisplayed();
    }
}
