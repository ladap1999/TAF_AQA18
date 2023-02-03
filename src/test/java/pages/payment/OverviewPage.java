package pages.payment;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OverviewPage{
    private final By finishButtonLocator = By.id("finish");
    public SelenideElement searchFinishButton() {
        return $(finishButtonLocator);
    }
}
