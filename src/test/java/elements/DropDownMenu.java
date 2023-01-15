package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.WaitsService;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenu {
    private UIElement uiElement;
    private WaitsService waitsService;
    private List<UIElement> uiElementTagList;
    private List<String> textList;
    private UIElement dropDownMenuUIElement;
    private UIElement dropDownUIElement;
    private UIElement inputElement;

    public DropDownMenu(WebDriver driver, By by) {
        uiElement = new UIElement(driver, by);
        waitsService = new WaitsService(driver);
        dropDownMenuUIElement = new UIElement(driver, by).findUIElement(By.className("chzn-results"));
    }

    public DropDownMenu(WebDriver driver, String dropDownId) {
        uiElement = new UIElement(driver, By.id(dropDownId));
        waitsService = new WaitsService(driver);
        dropDownUIElement = new UIElement(driver, By.id(dropDownId));
        inputElement = dropDownUIElement.findUIElement(By.cssSelector("[autocomplete = 'off']"));
        dropDownMenuUIElement = dropDownUIElement.findUIElement(By.className("chzn-results"));
        uiElementTagList = new ArrayList<>();
        textList = new ArrayList<>();

        for (UIElement uiElement : dropDownMenuUIElement.findUIElements(By.tagName("li"))) {
            uiElementTagList.add(uiElement);
            textList.add(uiElement.getAttribute("innerText").trim());
        }
    }

    public void dropDownClick() {
        uiElement.click();
        waitsService.waitsForVisibilityElement(dropDownMenuUIElement);
    }

    public UIElement selectByIndex(int index) {
        UIElement selectedUIElement = uiElementTagList.get(index);
        selectedUIElement.click();
        return selectedUIElement;
    }

    public UIElement selectByText(String text) {
        UIElement selectedUIElement = uiElementTagList.get(textList.indexOf(text));
        selectedUIElement.click();
        return dropDownUIElement;
    }

    public String search(String searchText) {
        dropDownClick();
        inputElement.sendKeys(searchText);
        UIElement selectedElement =
                (UIElement) waitsService.waitsForVisibilityElement(dropDownMenuUIElement.findUIElement(By.className("active-result")));
        selectedElement.click();
        return selectedElement.getAttribute("innerText");
    }
}
