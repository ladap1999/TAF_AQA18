package pages.products;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ListOfProductsPage{
    private final By headerTitleLabelLocator = By.className("title");
    private final By itemToAddLocator = By.xpath("//*[text() = 'Sauce Labs Backpack']");


    public SelenideElement searchItem() {
        return $(itemToAddLocator);
    }
    public SelenideElement displyedTitleLocator() {
        return $(headerTitleLabelLocator);
    }
}
