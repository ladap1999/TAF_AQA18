package stepDefs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.SearchHotelPage;
import services.WaitsService;

import static baseEntities.BaseCucumberTest.driver;

public class SearchHotelStepDefs {
    private BaseCucumberTest baseCucumberTest;
    private WaitsService waitsService;
    private SearchHotelPage searchHotelPage;

    public SearchHotelStepDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }
    @Given("searchHotelPage is opened")
    public void openLoginPage() {
        driver.get(ReadProperties.getUrl());
    }

    @And("user enter the name of hotel")
    public void enterTheNameOfHotel() {
        searchHotelPage = new SearchHotelPage(driver);
        waitsService = new WaitsService(driver);
        waitsService.waitsForVisibilityElement(searchHotelPage.hotelName).sendKeys("Victoria");
    }

    @And("user click searchButton")
    public void clickSearchButton() {
       waitsService.waitsForVisibilityElement(searchHotelPage.searchHotelButton).submit();
    }
}
