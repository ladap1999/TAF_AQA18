
package steps;

import pages.products.SelectedProductPage;

import static com.codeborne.selenide.Condition.exist;

public class NavigationStep {
    SelectedProductPage selectedProductPage;

    public NavigationStep() {
        selectedProductPage = new SelectedProductPage();
    }

    public AddToCartSteps navigateToAddProjectPage() {
        selectedProductPage.findCartButton().should(exist).click();
        return new AddToCartSteps();
    }
}
