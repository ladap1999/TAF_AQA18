package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.project.TestCasePage;
import pages.project.AddProjectPage;
import pages.project.TodoPage;

public class NavigationSteps extends BaseStep {
    public NavigationSteps(WebDriver driver) {
        super(driver);
    }

    public AddProjectPage navigateToAddProjectPage() {

        AddProjectPage page = new AddProjectPage(driver);
        page.openPageByUrl();

        return page;
    }

    public TodoPage navigateToTodoPage() {
        TodoPage todoPage = new TodoPage(driver);
        todoPage.openPageByUrl();
        return new TodoPage(driver);
    }

    public TestCasePage navigateToTestCasePage() {
        TestCasePage testCasePage = new TestCasePage(driver);
        testCasePage.openPageByUrl();
        return new TestCasePage(driver);
    }
}
