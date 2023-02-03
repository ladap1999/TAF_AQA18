package steps;


import pages.CartPage;
import pages.products.ListOfProductsPage;
import pages.products.SelectedProductPage;

import static com.codeborne.selenide.Condition.exist;

public class AddToCartSteps {
    private ListOfProductsPage productPage;
    private SelectedProductPage selectedProductPage;

    private CartPage cartPage;

    public AddToCartSteps() {
        productPage = new ListOfProductsPage();
        selectedProductPage = new SelectedProductPage();
        cartPage = new CartPage();
    }

    public NavigationStep addToCart() throws InterruptedException {
        productPage.searchItem().should(exist).click();
        selectedProductPage.findAddButton().shouldBe(exist).click();
        Thread.sleep(3000);
        return new NavigationStep();
    }

    public PaymentSteps followToCheckoutPage() {
        cartPage.findCheckoutButton().shouldBe(exist).click();
        return new PaymentSteps();
    }
}
