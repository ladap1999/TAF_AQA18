package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.project.AddTestCasePage;
import pages.project.TestCasePage;

public class TestCaseSteps extends BaseStep {
    private TestCasePage testCasePage;
    private AddTestCasePage addTestCasePage;

    public TestCaseSteps(WebDriver driver) {
        super(driver);
        testCasePage = new TestCasePage(driver);
        addTestCasePage = new AddTestCasePage(driver);
    }

    public void navigateToDropDown() {
        testCasePage.getAddTestCaseButtonElement().click();
        addTestCasePage.getDropDownElement().dropDownClick();
    }

    public void openDropDownMenu() {
        addTestCasePage.getDropDownElement().dropDownClick();
    }
}
