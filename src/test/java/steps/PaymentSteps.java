package steps;

import baseEntities.BaseStep;
import models.PaymentData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.payment.CompletePage;
import pages.payment.InformationPage;
import pages.payment.OverviewPage;
import pages.products.ListOfProductsPage;

public class PaymentSteps extends BaseStep {
    private InformationPage checkoutPage;

    private OverviewPage overviewPage;

    private CompletePage completePage;

    private Logger logger = LogManager.getLogger(PaymentSteps.class);

    public PaymentSteps(WebDriver driver) {
        super(driver);
        logger.info("PaymentStep object was initialize");
        checkoutPage = new InformationPage(driver);
        overviewPage = new OverviewPage(driver);
        completePage = new CompletePage(driver);
    }

    public PaymentSteps fillInformationFields(PaymentData paymentData){
        checkoutPage.userFirstNameInput.sendKeys(paymentData.getFirstName());
        checkoutPage.userSecondNameInput.sendKeys(paymentData.getSecondName());
        checkoutPage.zipCodeInput.sendKeys(paymentData.getZipCode());
        checkoutPage.continueButton.click();
        logger.info("FillInformationFields step gets paymentData object with value:" + paymentData);
        logger.info("ChainOfInvocation pattern is implemented in fillInformationFields step." +
                " PaymentSteps object was returned.");
        return new PaymentSteps(driver);
    }

    public ListOfProductsPage completePayment(){
        overviewPage.finishButton.click();
        completePage.backHomeButton.click();
        logger.info("ChainOfInvocation pattern is implemented in completePayment step." +
                "ListOfProductsPage object was returned.");
        return new ListOfProductsPage(driver);
    }
}
