package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchHotelPage extends BasePage {
    @FindBy(css = "[name = 'ss']")
    public WebElement hotelName;
    @FindBy(css = "[type = 'submit']")
    public WebElement searchHotelButton;

    public SearchHotelPage(WebDriver driver) {
        super(driver);
    }
}
