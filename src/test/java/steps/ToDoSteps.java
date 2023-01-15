package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.project.TodoPage;

public class ToDoSteps extends BaseStep {
    private TodoPage todoPage;

    public ToDoSteps(WebDriver driver) {
        super(driver);
        todoPage = new TodoPage(driver);
    }

    public void followToFilter(){
        todoPage.getFilterLink().click();
    }
}
