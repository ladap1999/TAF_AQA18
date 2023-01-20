package steps;

import baseEntities.BaseStep;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.products.ListOfProductsPage;

public class UserSteps extends BaseStep {
    private LoginPage loginPage;


    public UserSteps(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
    }

    public void login(String userName, String psw) {
        loginPage.userNameInput.sendKeys(userName);
        loginPage.passwordInput.sendKeys(psw);
        loginPage.logInButton.click();
    }

    public AddToCartSteps loginSuccessful(User user) {
        login(user.getUserName(), user.getUserPassword());

        return new AddToCartSteps(driver);
    }
}
