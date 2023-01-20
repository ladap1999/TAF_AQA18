
package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

public class NavigationStep extends BaseStep {
    public NavigationStep(WebDriver driver) {
        super(driver);
    }

    public AddToCartSteps navigateToAddProjectPage() {
        CartPage cartPage = new CartPage(driver);
        cartPage.openPageByUrl();
        return new AddToCartSteps(driver);
    }
}
