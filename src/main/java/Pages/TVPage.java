package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TVPage extends BasePage{
    //создался конструктор на основе родительского
    public TVPage(WebDriver driver) {
        super(driver);
    }
    //создаем вложенный класс с локаторами на странице результатов
    private static class Locators{
        private final static By h1Element = By.xpath("//h1[text()]");
        private final static By labelElement = By.xpath("//div[@class='search-page__box-title']/label");
        private final static By icon=By.xpath("//div[@class='header-logo']");
        private final static By firstTVtoCompare=By.xpath("//div[@data-url='L3VrL3Byb2R1Y3RzL2dldHNob3J0cHJvcGVydGllcy80NDI5P2NsYXNzSWQ9OTc3']");
        private final static By buttonToCompareFirst=By.xpath("//div[@data-id='4429']/label");
        private final static By buttonToCompareFirstField=By.xpath("//div[@data-id='4429']/label/span[text()='У порівнянні']");
        private final static By secondTVtoCompare=By.xpath("//div[@data-url='L3VrL3Byb2R1Y3RzL2dldHNob3J0cHJvcGVydGllcy80MzEwP2NsYXNzSWQ9OTc3']");
        private final static By buttonToCompareSecond=By.xpath("//div[@data-id='4310']/label");
        private final static By buttonToCompareSecondField=By.xpath("//div[@data-id='4310']/label/span[text()='У порівнянні']");
        private final static By buttonCompare=By.xpath("//div[@class='header-tooltip unselectable']");
        private final static By buttonCompareDeployed=By.xpath("//div[@id='comparisonTooltip']");
        private final static By pricePerMonth=By.xpath("//label[@class='filter-label filter-label-price-month']");
        private final static By pricePerMonthFor1TV=By.xpath("//a[@data-id='4429']/span[2]");
        private final static By filterFromCheapToExpensive=By.xpath("//ul[@class='listing__body-sort']/li[4]");
        private final static By theCheapestTV=By.xpath("//ul[@class='listing__body-sort']/li[4]");

    }

    private static class Text{
        private final static String titleNameTV="Телевізори у Дніпрі купити в Фокстрот";

    }

    public void checkNameOfPage(){
        assertions.equalsOfStrings(driver.getTitle(), Text.titleNameTV);
    }
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
        String resultOfReach = elements.getTextFromElementBy(Locators.h1Element).replace("Apple  ", "").replace(" у Дніпрі","");
        assertions.equalsOfStrings(resultOfReach, ""+input+"");
    }

    public void clickOnIcon(){
        elements.clickOnElementBy(Locators.icon);
    }
    public void clickOnElement(By by){
        elements.clickOnElementBy(by);
    }
    public void addTwoTVtoCompare(){
        action.moveToElementLocation(Locators.firstTVtoCompare);
        action.moveToElementLocation(Locators.buttonToCompareFirst);
        elements.clickOnElementBy(Locators.buttonToCompareFirst);
        waiters.waitvisabilityOFWebelement(Locators.buttonToCompareFirstField);

        action.moveToElementLocation(Locators.secondTVtoCompare);
        action.moveToElementLocation(Locators.buttonToCompareSecond);
        elements.clickOnElementBy(Locators.buttonToCompareSecond);
        waiters.waitvisabilityOFWebelement(Locators.buttonToCompareSecondField);

    }
    public void checkToIncludesInCompare(){
        waiters.waitvisabilityOFWebelement(Locators.buttonCompare);
        action.moveToElementLocation(Locators.buttonCompare);
        elements.clickOnElementBy(Locators.buttonCompare);
        waiters.waitvisabilityOFWebelement(Locators.buttonCompareDeployed);

    }
    public void switchToPricePerMonth(){
        elements.clickOnElementBy(Locators.pricePerMonth);//ожидания добавила в clickOnElementBy
        waiters.waitvisabilityOFWebelement(Locators.pricePerMonthFor1TV);
    }
    public void switchToFirstCheapToExpensiveProducts(){
        elements.clickOnElementBy(Locators.filterFromCheapToExpensive);//ожидания добавила в clickOnElementBy
        waiters.waitvisabilityOFWebelement(Locators.theCheapestTV);
    }

}
