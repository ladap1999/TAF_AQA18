package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.project.AddProjectPage;
import pages.project.AddTestCasePage;
import pages.project.TodoPage;
import steps.NavigationSteps;

public class WrappersTest extends BaseTest {

    @Test
    public void radioButtonTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddProjectPage page = new NavigationSteps(driver).navigateToAddProjectPage();
        page.getType().selectByIndex(1);
        page.getType().selectByValue("3");
        page.getType().selectByText("Use a single repository for all cases (recommended)");
    }

    @Test
    public void checkboxTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        TodoPage todoPage = navigationSteps.navigateToTodoPage();
        toDoSteps.followToFilter();
        todoPage.getType().selectByIndex(1);
        Assert.assertTrue(todoPage.getType().clickByText("Failed").isSelected());
    }

    @Test
    public void dropDownTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        navigationSteps.navigateToTestCasePage();
        testCaseSteps.navigateToDropDown();
        AddTestCasePage addTestCasePage = new AddTestCasePage(driver);
        addTestCasePage.getType().selectByIndex(1);
        testCaseSteps.openDropDownMenu();
        Assert.assertTrue(addTestCasePage.getType().selectByText("Low").isDisplayed());
        Assert.assertEquals(addTestCasePage.getType().search("lo"), "Low");
    }
}
