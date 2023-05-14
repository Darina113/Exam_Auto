package Functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionsClass {
    private final ElementsClass elements;
    private final ActionClass actions;
    private final WebDriver driver;
    private final WaitersClass waiters;

    public AssertionsClass(WebDriver driver) {
        this.driver = driver;
        elements = new ElementsClass(driver);
        actions = new ActionClass(driver);
        waiters = new WaitersClass(driver);
    }

    public void elementIsDisplayed(String xpath){
        assertTrue(elements.isElementDisplayed(xpath), "Элемент не отображается, хотя должен был");
    }
    public void equalsOfElementAndLabelText(String xpathOfElement, String expectedString){
        assertEquals(elements.getTextFromElementXpath(xpathOfElement),expectedString,
                "Я ожидал получить "+expectedString+". А получил "+ elements.getTextFromElementXpath(xpathOfElement));
    }

    public void equalsOfStrings(String actualString, String expectedString){
        assertEquals(actualString,expectedString,
                "Я ожидала получить "+expectedString+". А получила "+ actualString);
    }

}
