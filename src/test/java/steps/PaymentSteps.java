package steps;

import com.codeborne.selenide.Condition;
import models.PaymentData;
import pages.payment.CompletePage;
import pages.payment.InformationPage;
import pages.payment.OverviewPage;
import pages.products.ListOfProductsPage;

import static com.codeborne.selenide.Condition.exist;

public class PaymentSteps{
    private InformationPage checkoutPage;

    private OverviewPage overviewPage;

    private CompletePage completePage;

    public PaymentSteps() {
        checkoutPage = new InformationPage();
        overviewPage = new OverviewPage();
        completePage = new CompletePage();
    }

    public PaymentSteps fillInformationFields(PaymentData paymentData){
        checkoutPage.getFirstNameInput().shouldBe(exist).setValue(paymentData.getFirstName());
        checkoutPage.getSecondNameInput().shouldBe(exist).setValue(paymentData.getSecondName());
        checkoutPage.getZipCodeInput().shouldBe(exist).setValue(paymentData.getZipCode());
        checkoutPage.getContinueButton().shouldBe(exist).click();
        return new PaymentSteps();
    }

    public ListOfProductsPage completePayment(){
        overviewPage.searchFinishButton().shouldBe(exist).click();
        completePage.searchBackHomeButton().shouldBe(exist).click();
        return new ListOfProductsPage();
    }
}
