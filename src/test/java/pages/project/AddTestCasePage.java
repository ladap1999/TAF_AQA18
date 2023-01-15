package pages.project;

import baseEntities.BasePage;
import elements.DropDownMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTestCasePage extends BasePage {
    private final static String dropDownId = "priority_id_chzn";
    private final static By dropDownLocator  = By.id("priority_id_chzn");

    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public DropDownMenu getType() {
        return new DropDownMenu(driver, dropDownId);
    }

    public DropDownMenu getDropDownElement() {
        DropDownMenu dropDownMenu = new DropDownMenu(driver, dropDownLocator);
        return dropDownMenu;
    }
}
