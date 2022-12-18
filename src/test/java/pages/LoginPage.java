package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final By userNameInputLocator = By.id("user-name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    public WebElement getEmailInput() { return driver.findElement(userNameInputLocator);}

    public WebElement getPassword() { return driver.findElement(passwordInputLocator);}

    public WebElement getLogInButton() { return driver.findElement(logInButtonLocator);}
}
