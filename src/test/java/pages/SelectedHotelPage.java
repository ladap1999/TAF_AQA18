package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectedHotelPage extends BasePage {
    @FindBy(css= "[aria-label ='Scored 8.9 ']")
    public WebElement hotelRating;

    public SelectedHotelPage(WebDriver driver) {
        super(driver);
    }
}
