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

        private final static By search=By.xpath("//input[@type='search']");
        private final static By buttonLocation=By.xpath("//i[@class='icon-location-white']");
        private final static By inputCity=By.xpath("//input[@id='city-search']");
        private final static By language=By.xpath("//a[@data-lang='ru']");
        private final static By facebook=By.xpath("//i[@class='icon icon-facebook']");
        private final static By laptopSection=By.xpath("//p[text()='Ноутбуки, ПК, планшети']");
        private final static By section=By.xpath("//i[@class='icon-grid']");
        private final static By laptops=By.xpath("//a[@data-url='L3VrL3Nob3AvZG5lcHIvbm91dGJ1a2kuaHRtbA==']");
        private final static By tvSection=By.xpath("//p[text()='Телевізори, аудіотехніка']");
        private final static By tv=By.xpath("//a[@data-url='L3VrL3Nob3AvZG5lcHIvbGVkX3RlbGV2aXpvcnkuaHRtbA==']");

    }

    private static class Url{
        private final static String url = "https://www.foxtrot.com.ua/uk/";
    }

    public void searchByText(String text){
        elements.sendKeysToElementByAndClick(Locators.search,text);

    }
    public void openPage(){
        driver.get(Url.url);
    }
    public void acceptCity(){
        elements.clickOnElementBy(By.xpath("//a[@class='button user-confirm-location-button']"));
    }

    public void changeCity(){
        elements.clickOnElementBy(Locators.buttonLocation);
        elements.isElementDisplayed(Locators.inputCity);

    }
    public void choiceCity(String city){
        elements.sendKeysToElementBy(Locators.inputCity,city);
        elements.isElementDisplayed(By.xpath("//li[@class='popup__cities_item popup__cities_item-bold']"));
        elements.clickOnElementBy(By.xpath("//li[@class='popup__cities_item popup__cities_item-bold']"));
        assertions.equalsOfStrings(elements.getTextFromElementBy(By.xpath("//p[@class='city-title']")),city);

    }
    public void switchLanguage(){
        waiters.waitVisibilityOfElementLocated(Locators.language);
        elements.clickOnElementBy(Locators.language);
    }

    public void waitPageLoaded(){
        elements.findSingleElement(By.xpath("//div[@class='current-offer-head']/div[@class='page__title']"));
    }

    public void clickOnSocialNet(){
        elements.clickOnElementBy(Locators.facebook);
    }
    public void switchToSectionLaptop(){
        waiters.waitvisabilityOFWebelement(Locators.section);
        action.moveToElementLocationAndClick(Locators.section);
        action.moveToElementLocation(Locators.laptopSection);
        action.moveToElementLocationAndClick(Locators.laptops);

    }
    public void switchToSectionTV(){
        waiters.waitvisabilityOFWebelement(Locators.section);
        action.moveToElementLocationAndClick(Locators.section);
        action.moveToElementLocation(Locators.tvSection);
        action.moveToElementLocationAndClick(Locators.tv);

    }



}
