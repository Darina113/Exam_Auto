package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LaptopPage extends BasePage {
    public LaptopPage(WebDriver driver) {
        super(driver);
    }
    private static class Locators{
        private final static By filterTMByDell=By.xpath("//div[@id='group-9501']/following-sibling::div/a[6]");
        private final static By submitToShow=By.xpath("//div[@class='listing__submit-wrap']/a");
        private final static By textShow=By.xpath("//div[@class='listing__sidebar listing__sidebar_main js-listing-sidebar order--1 listing-filter']/div/ul[@class='listing__sidebar-tags']");
        private final static By violetIcon=By.xpath("//div[@id='listing-submit']/div");

        private final static By laptopToBasket=By.xpath("//div[@data-title='Ноутбук Lenovo IdeaPad Gaming 3 15ACH6 Shadow Black (82K201N8RA)']/following-sibling::div[2]/div");
        private final static By basket=By.xpath("//i[@id='basket-icon']");
        private final static By filterOSByMac=By.xpath("//div[@id='group-10850']/following-sibling::div/div[5]");
        private final static By sectionOS=By.xpath("//div[@id='group-10850']");


    }
    public void choiceFilterOnSectionLaptop(){
        waiters.waitvisabilityOFWebelement(Locators.filterTMByDell);
        elements.clickOnElementBy(Locators.filterTMByDell);
        waiters.waitvisabilityOFWebelement(Locators.submitToShow);
        elements.clickOnElementBy(Locators.submitToShow);
        waiters.waitvisabilityOFWebelement(Locators.textShow);

    }
    public void addToBasketLaptop(){
        waiters.waitvisabilityOFWebelement(Locators.laptopToBasket);
        elements.clickOnElementBy(Locators.laptopToBasket);
        waiters.waitVisibilityOfElementLocated(Locators.basket);
    }
    public void choiseIncorrectFilterForLaptop(){
        waiters.waitvisabilityOFWebelement(Locators.filterTMByDell);
        elements.clickOnElementBy(Locators.filterTMByDell);
        elements.clickOnElementBy(Locators.sectionOS);
        waiters.waitvisabilityOFWebelement(Locators.filterOSByMac);
        elements.clickOnElementBy(Locators.filterOSByMac);
        waiters.waitvisabilityOFWebelement(Locators.violetIcon);
        elements.clickOnElementBy(Locators.violetIcon);
    }


}
