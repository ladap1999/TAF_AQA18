package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.products.ListOfProductsPage;
import pages.products.SelectedProductPage;

public class AddToCartSteps extends BaseStep {
    private ListOfProductsPage productPage;
    private SelectedProductPage selectedProductPage;

    private CartPage cartPage;

    public AddToCartSteps(WebDriver driver) {
        super(driver);
        productPage = new ListOfProductsPage(driver);
        selectedProductPage = new SelectedProductPage(driver);
        cartPage = new CartPage(driver);
    }

    public NavigationStep addToCart() throws InterruptedException {
        productPage.itemToAdd.click();
        selectedProductPage.addButton.click();
        Thread.sleep(3000);
        return new NavigationStep(driver);
    }

    public PaymentSteps followToCheckoutPage(){
        cartPage.checkoutButton.click();
        return new PaymentSteps(driver);
    }
}
