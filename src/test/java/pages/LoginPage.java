package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage{
    private final By userNameInputLocator = By.id("user-name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("login-button");

    public SelenideElement getEmailInput() { return $(userNameInputLocator);}

    public SelenideElement getPassword() { return $(passwordInputLocator);}

    public SelenideElement getLogInButton() { return $(logInButtonLocator);}
}
