package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private static class Locators{
        private final static By searchField = By.xpath("//input[@type='search']");
        private final static By searchButton = By.xpath("//input[@class='header-search__button evinent-search-button']");
    }

    private static class Label{
        private final static String url = "https://www.foxtrot.com.ua/";
    }

    public void searchByText(String text){
        elements.sendKeysToElementBy(Locators.searchField,text);
        elements.clickOnElementBy(Locators.searchButton);
    }
    public void openPage(){
        driver.get(Label.url);
    }
}
