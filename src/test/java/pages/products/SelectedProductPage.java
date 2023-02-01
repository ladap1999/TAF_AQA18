package pages.products;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SelectedProductPage {
    private final By addButtonLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By backToProductsButtonLocator = By.id("back-to-products");
    private final By cartButtonLocator = By.className("shopping_cart_link");


    public SelenideElement findAddButton() {
        return $(addButtonLocator);
    }
    public SelenideElement findCartButton() {
        return $(cartButtonLocator);
    }
}
