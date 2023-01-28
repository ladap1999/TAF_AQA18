package steps;

import baseEntities.BaseStep;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class UserSteps extends BaseStep {
    private LoginPage loginPage;

    private Logger logger = LogManager.getLogger(UserSteps.class);

    public UserSteps(WebDriver driver) {
        super(driver);
        logger.info("UserSteps object was initialize");
        loginPage = new LoginPage(driver);
    }

    public void login(String userName, String psw) {
        loginPage.userNameInput.sendKeys(userName);
        loginPage.passwordInput.sendKeys(psw);
        loginPage.logInButton.click();
    }

    public AddToCartSteps loginSuccessful(User user) {
        login(user.getUserName(), user.getUserPassword());
        logger.info("LoginSuccessful step gets User object with value:" + user);
        logger.info("ChainOfInvocation pattern is implemented in LoginSuccessful step." +
                " AddToCardSteps object was returned.");
        return new AddToCartSteps(driver);
    }
}
