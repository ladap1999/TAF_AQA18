package pages.payment;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class CompletePage{
    private final By backHomeButtonLocator = By.id("back-to-products");

    public SelenideElement searchBackHomeButton() {
        return $(backHomeButtonLocator);
    }
}

