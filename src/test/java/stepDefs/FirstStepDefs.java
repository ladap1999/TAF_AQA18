package stepDefs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.LoginPage;
import pages.payment.CheckoutPage;
import pages.payment.CompletePage;
import pages.payment.OverviewPage;
import pages.products.ListOfProductsPage;
import pages.products.SelectedProductPage;
import services.WaitsService;

import static baseEntities.BaseCucumberTest.driver;


public class FirstStepDefs {
    private LoginPage loginPage;
    private ListOfProductsPage productPage;
    private SelectedProductPage selectedProductPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private OverviewPage overviewPage;
    private CompletePage completePage;

    private BaseCucumberTest baseCucumberTest;
    private WaitsService waitsService;


    public FirstStepDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Given("open browser")
    public void startBrowser() {
        driver = new BrowserFactory().getDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @When("loginPage is opened")
    public void openLoginPage() {
        driver.get(ReadProperties.getUrl());
    }

    @When("user {string} with password {string} logged in")
    public void userWithPasswordLoggedIn(String userName, String password) {
        loginPage = new LoginPage(driver);
        loginPage.userNameInput.sendKeys(userName);
        loginPage.passwordInput.sendKeys(password);
        loginPage.logInButton.click();
    }

    @When("user adds an item to the cart")
    public void user_adds_an_item_to_the_cart() {
        productPage = new ListOfProductsPage(driver);
        selectedProductPage = new SelectedProductPage(driver);
        productPage.itemToAdd.click();
        selectedProductPage.addButton.click();
    }

    @When("user follows to the cartPage")
    public void followToTheCartPage() {
        cartPage = new CartPage(driver);
        cartPage = new CartPage(driver);
        cartPage.openPageByUrl();
    }

    @When("user follows to the checkoutPage")
    public void followToTheCheckoutPage() {
        waitsService = new WaitsService(driver);
        waitsService.waitsForVisibilityElement(cartPage.checkoutButton).click();
    }

    @When("user fills payment information fields: name {string}, secondName {string}, zipCode {string}")
    public void fillPaymentInformationFields(String firstName, String secondName, String zipCode) {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.userFirstNameInput.sendKeys(firstName);
        checkoutPage.userSecondNameInput.sendKeys(secondName);
        checkoutPage.zipCodeInput.sendKeys(zipCode);
        checkoutPage.continueButton.click();
    }

    @When("user completes payment")
    public void completePayment() {
        overviewPage = new OverviewPage(driver);
        completePage = new CompletePage(driver);
        overviewPage.finishButton.click();
        completePage.backHomeButton.click();
        new ListOfProductsPage(driver);
    }

    @Then("page ListOfProduct is opened")
    public void isListOfProductPageOpened() {
        Assert.assertTrue(productPage.isPageOpened());
    }
}
