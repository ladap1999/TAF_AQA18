package steps;

import baseEntities.BaseStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.products.ListOfProductsPage;
import pages.products.SelectedProductPage;

public class AddToCartSteps extends BaseStep {
    private ListOfProductsPage productPage;

    private SelectedProductPage selectedProductPage;

    private CartPage cartPage;

    private Logger logger = LogManager.getLogger(AddToCartSteps.class);

    public AddToCartSteps(WebDriver driver) {
        super(driver);
        logger.info("AddToCartSteps object was initialize");
        productPage = new ListOfProductsPage(driver);
        selectedProductPage = new SelectedProductPage(driver);
        cartPage = new CartPage(driver);
    }

    public NavigationStep addToCart() throws InterruptedException {
        productPage.itemToAdd.click();
        selectedProductPage.addButton.click();
        Thread.sleep(3000);
        logger.info("ChainOfInvocation pattern is implemented in AddToCart step." +
                " NavigationStep object was returned.");
        return new NavigationStep(driver);
    }

    public PaymentSteps followToCheckoutPage(){
        cartPage.checkoutButton.click();
        logger.info("ChainOfInvocation pattern is implemented in followToCheckoutPage step." +
                " PaymentStep object was returned.");
        return new PaymentSteps(driver);
    }
}
