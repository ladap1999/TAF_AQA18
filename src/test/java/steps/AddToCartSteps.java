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

    public SelectedProductPage addToCart() throws InterruptedException {
        productPage.searchItem().click();
        selectedProductPage.findAddButton().click();
        Thread.sleep(3000);
        return new SelectedProductPage(driver);
    }

    public CartPage followToCheckoutPage(){
        cartPage.findCheckoutButton().click();
        return new CartPage(driver);
    }
}
