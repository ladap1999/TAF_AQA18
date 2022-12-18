package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2ESauceDemoTest extends BaseTest {

    @Test
    public void e2eSuccessfulTest() throws InterruptedException {
        Assert.assertTrue(userStep.loginSuccessful(ReadProperties.username(),
                ReadProperties.password()).isPageOpened());
        Thread.sleep(2000);

        Assert.assertTrue(addToCartSteps.addToCart().isPageOpened());
        Thread.sleep(2000);

        Assert.assertTrue(navigationSteps.navigateToAddProjectPage().isPageOpened());
        Thread.sleep(2000);

        Assert.assertTrue(addToCartSteps.followToCheckoutPage().isPageOpened());
        Thread.sleep(2000);

        Assert.assertTrue(paymentSteps.fillInformationFields().isPageOpened());
        Thread.sleep(2000);

        Assert.assertTrue(paymentSteps.completePayment().isPageOpened());
    }
}