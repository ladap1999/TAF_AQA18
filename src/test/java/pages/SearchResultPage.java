package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {
    @FindBy(css = "[data-testid = 'title']")
    public List<WebElement> listOfSearchResultElement;
    @FindBy(xpath = "//*[text() ='Victoria Regent Waterfront Hotel & Suites']")
    public WebElement linkToHotel;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
}
