package stepDefs;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.SearchResultPage;
import pages.SelectedHotelPage;
import services.WaitsService;

import static baseEntities.BaseCucumberTest.driver;

public class ResultOfSearchStepDefs {
    private BaseCucumberTest baseCucumberTest;
    private SearchResultPage searchResultPage;
    private SelectedHotelPage selectedHotelPage;
    private WaitsService waitsService;

    public ResultOfSearchStepDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }
    @Then("hotel name {string} is displayed")
    public void isHotelNameDisplayed(String nameHotel) {
        searchResultPage = new SearchResultPage(driver);
        int countHotel = 0;
        for (WebElement element: searchResultPage.listOfSearchResultElement) {
            if(element.getText().equals(nameHotel)){
                countHotel++;
            }
        }
        Assert.assertEquals(countHotel,1,"Search result didn't find required hotel");
    }

    @Then("hotel Victoria Regent Waterfront Hotel & Suites  has rating {string}")
    public void hasHotelRating(String rating) throws InterruptedException {
        searchResultPage = new SearchResultPage(driver);
        waitsService = new WaitsService(driver);
        searchResultPage.linkToHotel.click();

        selectedHotelPage = new SelectedHotelPage(driver);

        Assert.assertEquals(waitsService.waitsForVisibilityElement(selectedHotelPage.hotelRating)
                .getText(),rating,"Search result didn't find required rating");
    }
}
