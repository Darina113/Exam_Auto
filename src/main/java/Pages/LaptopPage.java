package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LaptopPage extends BasePage {
    public LaptopPage(WebDriver driver) {
        super(driver);
    }
    private static class Locators{
        private final static By filterTMByDell=By.xpath("//div[@id='group-9501']/following-sibling::div/a[6]");
        private final static By filterContainsDell=By.xpath("//div[@class='listing__sidebar listing__sidebar_main js-listing-sidebar order--1 listing-filter']/div/ul[@class='listing__sidebar-tags']");
        private final static By submitToShow=By.xpath("//div[@class='listing__submit-wrap']/a");
        private final static By textShow=By.xpath("//div[@class='listing__sidebar listing__sidebar_main js-listing-sidebar order--1 listing-filter']/div/ul[@class='listing__sidebar-tags']");
        private final static By violetIcon=By.xpath("//div[@id='listing-submit']/div");

        private final static By laptopToBasket=By.xpath("//div[@data-title='Ноутбук Lenovo IdeaPad Gaming 3 15ACH6 Shadow Black (82K201N8RA)']/following-sibling::div[2]/div");
        private final static By basket=By.xpath("//i[@id='basket-icon']");
        private final static By filterOSByMac=By.xpath("//div[@id='group-10850']/following-sibling::div/div[6]");
        private final static By sectionOS=By.xpath("//div[@id='group-10850']");
        private final static By warningForIncorrectFilter=By.xpath("//p[@class='product-listing__empty_text']");

    }
    private static class Text{
        private final static String resFiltrDell="Торгова марка: DELL";
        private final static String incorrectFilter="На жаль, товарів по заданих параметрах, не знайдено. Виберіть інші параметри.";;
        private final static String titleNameOfLaptop="Ноутбуки у Дніпрі - купити за найкращою ціною у Дніпрі - Фокстрот";;
    }
    public void checkNameOfPage(){
        assertions.equalsOfStrings(driver.getTitle(), Text.titleNameOfLaptop);
    }
    public void choiceFilterOnSectionLaptop(){
        elements.clickOnElementBy(Locators.filterTMByDell);//ожидания добавила в clickOnElementBy
        elements.clickOnElementBy(Locators.submitToShow);//ожидания добавила в clickOnElementBy
        waiters.waitvisabilityOFWebelement(Locators.textShow);

    }
    public void addToBasketLaptop(){
        elements.clickOnElementBy(Locators.laptopToBasket);//ожидания добавила в clickOnElementBy
        waiters.waitVisibilityOfElementLocated(Locators.basket);
    }
    public void choiseIncorrectFilterForLaptop(){
        waiters.waitvisabilityOFWebelement(Locators.filterTMByDell);
        elements.clickOnElementBy(Locators.filterTMByDell);//ожидания добавила в clickOnElementBy
        elements.clickOnElementBy(Locators.sectionOS);
        elements.clickOnElementBy(Locators.filterOSByMac);
        waiters.waitvisabilityOFWebelement(Locators.violetIcon);
        elements.clickOnElementBy(Locators.violetIcon);
    }
    public void checkFilterContainsDell(){
        assertions.equalsOfStrings(elements.getTextFromElementBy(Locators.filterContainsDell), Text.resFiltrDell);
    }
    public void checkIncorrectFilter(){
        waiters.waitVisibilityOfElementLocated(Locators.warningForIncorrectFilter);
        assertions.equalsOfStrings(elements.getTextFromElementBy(Locators.warningForIncorrectFilter), Text.incorrectFilter);
    }

}
