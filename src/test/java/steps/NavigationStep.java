
package steps;

import baseEntities.BaseStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

public class NavigationStep extends BaseStep {
    private Logger logger = LogManager.getLogger(NavigationStep.class);

    public NavigationStep(WebDriver driver) {
        super(driver);
        logger.info("NavigationStep object was initialize");
    }

    public AddToCartSteps navigateToAddProjectPage() {
        CartPage cartPage = new CartPage(driver);
        cartPage.openPageByUrl();
        logger.info("ChainOfInvocation pattern is implemented in navigateToAddProjectPage step." +
                " AddToCartStep object was returned.");
        return new AddToCartSteps(driver);
    }
}
