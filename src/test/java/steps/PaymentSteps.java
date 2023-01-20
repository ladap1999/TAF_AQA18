package steps;

import baseEntities.BaseStep;
import models.PaymentData;
import org.openqa.selenium.WebDriver;
import pages.payment.CompletePage;
import pages.payment.InformationPage;
import pages.payment.OverviewPage;
import pages.products.ListOfProductsPage;

public class PaymentSteps extends BaseStep {
    private InformationPage checkoutPage;

    private OverviewPage overviewPage;

    private CompletePage completePage;

    public PaymentSteps(WebDriver driver) {
        super(driver);
        checkoutPage = new InformationPage(driver);
        overviewPage = new OverviewPage(driver);
        completePage = new CompletePage(driver);
    }

    public PaymentSteps fillInformationFields(PaymentData paymentData){
        checkoutPage.userFirstNameInput.sendKeys(paymentData.getFirstName());
        checkoutPage.userSecondNameInput.sendKeys(paymentData.getSecondName());
        checkoutPage.zipCodeInput.sendKeys(paymentData.getZipCode());
        checkoutPage.continueButton.click();
        return new PaymentSteps(driver);
    }

    public ListOfProductsPage completePayment(){
        overviewPage.finishButton.click();
        completePage.backHomeButton.click();
        return new ListOfProductsPage(driver);
    }
}
