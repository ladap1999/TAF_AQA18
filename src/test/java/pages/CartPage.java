package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage{
    private final static String pagePath = "/cart.html";
    private final By headerTitleLabelLocator = By.className("title");
    private final By checkoutButtonLocator = By.id("checkout");

    public SelenideElement findCheckoutButton(){
        return $(checkoutButtonLocator);
    }
}
