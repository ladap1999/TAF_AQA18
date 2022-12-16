package baseEntities;

import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.*;

public class BaseTest {
    protected WebDriver driver;
    protected UserSteps userStep;
    protected AddToCartSteps addToCartSteps;
    protected PaymentSteps paymentSteps;
    protected NavigationStep navigationSteps;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
        driver.get(ReadProperties.getUrl());

        userStep = new UserSteps(driver);
        addToCartSteps = new AddToCartSteps(driver);
        paymentSteps = new PaymentSteps(driver);
        navigationSteps = new NavigationStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
