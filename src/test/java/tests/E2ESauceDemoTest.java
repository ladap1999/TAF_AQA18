package tests;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import configuration.ReadProperties;
import models.PaymentData;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.products.ListOfProductsPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.open;

public class E2ESauceDemoTest extends BaseTest {

    @Test
    public void e2eSuccessfulTest() throws InterruptedException {
        User user = new User(ReadProperties.userName(),ReadProperties.password());

        PaymentData paymentData = new PaymentData.Builder()
                .withFirstName(ReadProperties.firstName())
                .withSecondName(ReadProperties.secondName())
                .withZipCode(ReadProperties.zipCode())
                .build();

        open("/");
        userStep
                .loginSuccessful(user)
                .addToCart()
                .navigateToAddProjectPage()
                .followToCheckoutPage()
                .fillInformationFields(paymentData)
                .completePayment()
                .displyedTitleLocator().shouldBe(exist);
    }
}