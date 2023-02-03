package pages.payment;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class InformationPage {
    private final By userFirstNameInputLocator = By.id("first-name");
    private final By userSecondNameInputLocator = By.id("last-name");
    private final By zipCodeInputLocator = By.id("postal-code");
    private final By continueButtonLocator = By.id("continue");

    public SelenideElement getFirstNameInput() {
        return $(userFirstNameInputLocator);
    }

    public SelenideElement getSecondNameInput() {
        return $(userSecondNameInputLocator);
    }

    public SelenideElement getZipCodeInput() {
        return $(zipCodeInputLocator);
    }

    public SelenideElement getContinueButton() {
        return $(continueButtonLocator);
    }
}
