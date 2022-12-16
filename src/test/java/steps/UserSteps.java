package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.products.ListOfProductsPage;

public class UserSteps extends BaseStep {
    private LoginPage loginPage;

    public UserSteps(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
    }

    public void login(String email, String psw) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPassword().sendKeys(psw);
        loginPage.getLogInButton().click();
    }

    public ListOfProductsPage loginSuccessful(String email, String psw) {
        login(email, psw);

        return new ListOfProductsPage(driver);
    }
}
