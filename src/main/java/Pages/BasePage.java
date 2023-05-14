package Pages;

import Functions.AssertionsClass;
import Functions.ElementsClass;
import Functions.WaitersClass;
import org.openqa.selenium.WebDriver;
import Functions.ActionClass;

public class BasePage {
    protected static WebDriver driver;
    static WaitersClass waiters;
    static ActionClass action;
    static AssertionsClass assertions;
    static ElementsClass elements;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        waiters = new WaitersClass(driver);
        assertions = new AssertionsClass(driver);
        action = new ActionClass(driver);
        elements = new ElementsClass(driver);
    }
}
