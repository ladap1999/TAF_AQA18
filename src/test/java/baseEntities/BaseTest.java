package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import steps.UserSteps;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class BaseTest {
    protected UserSteps userStep;
        @BeforeSuite
        public void setUp() {
            userStep = new UserSteps();
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

            Configuration.browser = ReadProperties.browserName();
            Configuration.baseUrl = ReadProperties.getUrl();
            Configuration.timeout = 15000;
            open(" ");
        }

        @AfterMethod
        public void tearDown() {
            closeWebDriver();
        }
}
