package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2ESauceDemoTest extends BaseTest {

    @Test
    public void e2eSuccessfulTest() throws InterruptedException {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password()).isPageOpened();
        Thread.sleep(2000);

        addToCartSteps.addToCart().isPageOpened();
        Thread.sleep(2000);

        navigationSteps.navigateToAddProjectPage().isPageOpened();
        Thread.sleep(2000);

        addToCartSteps.followToCheckoutPage().isPageOpened();
        Thread.sleep(2000);

        paymentSteps.fillInformationFields().isPageOpened();
        Thread.sleep(2000);

        Assert.assertTrue(paymentSteps.completePayment().isPageOpened());
    }
}