package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage{
    //создался конструктор на основе родительского
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    //создаем вложенный класс с локаторами на странице результатов
    private static class Locators{
        private final static By h1Element = By.xpath("//h1[@class='catalog-heading ng-star-inserted']");
        private final static By labelElement = By.xpath("//div[@class='search-page__box-title']/label");
    }

    private static class Label{
        private final static String resultText = "Мобільні телефони Iphone";
    }

    //public void waitForPageLoaded(){
       // waiters.waitTitleContainsText(Label.partOfUrlText);
    //}
    public void waitForH1Loaded(){
        elements.findSingleElement(Locators.h1Element);
    }
    public String getTextFromH1(){
        return elements.getTextFromElementBy(Locators.h1Element);
    }
    public String getTextFromLabel(){
        return elements.getTextFromElementBy(Locators.labelElement);
    }

    public void checkH1ElementContainsText(String input){
        String resultOfReach = elements.getTextFromElementBy(Locators.h1Element).replace("Найдено по запросу ", "");
        assertions.equalsOfStrings(resultOfReach, "«"+input+"»" );
    }
    public void checkLabelElementContainsText(String input){
        String resultOfSearch = elements.getTextFromElementXpath(Label.resultText);
        assertions.equalsOfStrings(resultOfSearch, "«"+input+"»");
    }
}
