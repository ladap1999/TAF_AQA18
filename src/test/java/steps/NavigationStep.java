
package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

public class NavigationStep extends BaseStep {
    public NavigationStep(WebDriver driver) {
        super(driver);
    }

    public CartPage navigateToAddProjectPage() {
        CartPage cartPage = new CartPage(driver);
        cartPage.openPageByUrl();
        return cartPage;
    }
}
