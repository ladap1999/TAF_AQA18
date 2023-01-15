package pages.project;

import baseEntities.BasePage;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasePage extends BasePage {
    private final By addTestCaseButtonLocator = By.xpath("//*[text() = 'Add Test Case']");

    private final static String pagePath = "index.php?/suites/view/2";

    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return addTestCaseButtonLocator;
    }

    public UIElement getAddTestCaseButtonElement() {
        return new UIElement(driver, addTestCaseButtonLocator);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}
