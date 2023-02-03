package steps;

import models.User;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exist;

public class UserSteps {
    private LoginPage loginPage;


    public UserSteps() {
        loginPage = new LoginPage();
    }

    public void login(String userName, String psw) {
        loginPage.getEmailInput().should(exist).setValue(userName);
        loginPage.getPassword().should(exist).setValue(psw);
        loginPage.getLogInButton().shouldBe(enabled).click();
    }

    public AddToCartSteps loginSuccessful(User user) {
        login(user.getUserName(), user.getUserPassword());
        return new AddToCartSteps();
    }
}
