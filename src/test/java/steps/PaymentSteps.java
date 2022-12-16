package steps;

import baseEntities.BaseStep;
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

    public OverviewPage fillInformationFields(){
        checkoutPage.getFirstNameInput().sendKeys("Alex");
        checkoutPage.getSecondNameInput().sendKeys("Popov");
        checkoutPage.getZipCodeInput().sendKeys("220106");
        checkoutPage.getContinueButton().click();
        return new OverviewPage(driver);
    }
    public ListOfProductsPage completePayment(){
        overviewPage.searchFinishButton().click();
        completePage.searchBackHomeButton().click();
        return new ListOfProductsPage(driver);
    }
}
