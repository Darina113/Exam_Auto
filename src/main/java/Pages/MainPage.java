package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private static class Locators{
        private final static By catalog=By.xpath("//ul[@class='menu-categories menu-categories_type_main']");
        private final static By search=By.xpath("//input[@type='search']");
        private final static By buttonLocation=By.xpath("//i[@class='icon-location-white']");
        private final static By windowLocation=By.xpath("//button[@class='button button_size_medium button_color_green']");
        private final static By inputCity=By.xpath("//input[@id='city-search']");
        //private final static By lviv=By.xpath("//ul[@class='popup__cities']//li[2]//a");



    }
    private static class Webelement{
        private final static WebElement catalog= driver.findElement(Locators.catalog);
    }

    private static class Url{
        private final static String url = "https://www.foxtrot.com.ua/uk/";
    }

    public void searchByText(String text){
        elements.sendKeysToElementBy(Locators.search,text);

    }
    public void openPage(){
        driver.get(Url.url);
    }
    public void acceptCity(){
        elements.clickOnElementBy(By.xpath("//a[@class='button user-confirm-location-button']"));
    }

    public void changeCity(){
        elements.clickOnElementBy(Locators.buttonLocation);
        elements.isElementDisplayed(Locators.windowLocation);

    }
    public void choiceCity(String city){
        elements.sendKeysToElementBy(Locators.inputCity,city);
        elements.clickOnElementBy(By.xpath("//li[@class='popup__cities_item popup__cities_item-bold']"));
        assertions.equalsOfStrings(elements.getTextFromElementBy(By.xpath("//p[@class='city-title']")),city);

    }


}
