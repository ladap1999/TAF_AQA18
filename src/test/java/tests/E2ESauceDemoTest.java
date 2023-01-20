package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.PaymentData;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.products.ListOfProductsPage;

public class E2ESauceDemoTest extends BaseTest {

    @Test
    public void e2eSuccessfulTest() throws InterruptedException {
        User user = new User(ReadProperties.userName(),ReadProperties.password());

        PaymentData paymentData = new PaymentData.Builder()
                .withFirstName(ReadProperties.firstName())
                .withSecondName(ReadProperties.secondName())
                .withZipCode(ReadProperties.zipCode())
                .build();

        ListOfProductsPage listOfProductsPage = userStep
                .loginSuccessful(user)
                .addToCart()
                .navigateToAddProjectPage()
                .followToCheckoutPage()
                .fillInformationFields(paymentData)
                .completePayment();

        Assert.assertTrue(listOfProductsPage.isPageOpened());
    }
}