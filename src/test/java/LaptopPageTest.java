import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LaptopPageTest extends BaseTest{
    @Test(priority = 1)
    public void titleLaptopPageTest(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.acceptCity();//мы обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.switchToSectionLaptop();
        String titleNamelaptop="Ноутбуки у Дніпрі - купити за найкращою ціною у Дніпрі - Фокстрот";
        assertions.equalsOfStrings(driver.getTitle(),titleNamelaptop);
    }

    @Test(priority = 2)
    public void sectionLaptopTest(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.acceptCity();//мы обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.switchToSectionLaptop();
        List<WebElement> listFiltr=driver.findElements
                (By.xpath("//div[@class='listing__sidebar listing__sidebar_main js-listing-sidebar order--1 listing-filter']/div/following-sibling::div/following-sibling::div/div/p"));
        assertTrue(listFiltr.size()==37);

    }
    @Test(priority = 3)
    public void filtrLaptopByTMTest(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.acceptCity();//мы обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.switchToSectionLaptop();
        laptopPage.choiceFilterOnSectionLaptop();
        String resFiltr="Торгова марка: DELL";
        System.out.println(elements.getTextFromElementBy(By.xpath("//div[@class='listing__sidebar listing__sidebar_main js-listing-sidebar order--1 listing-filter']/div/ul[@class='listing__sidebar-tags']")));
        //assertions.equalsOfElementAndLabelText(elements.getTextFromElementBy
        //  (By.xpath("//div[@class='listing__sidebar listing__sidebar_main js-listing-sidebar order--1 listing-filter']/div/ul[@class='listing__sidebar-tags']")),resFiltr);
        assertEquals(elements.getTextFromElementBy(By.xpath("//div[@class='listing__sidebar listing__sidebar_main js-listing-sidebar order--1 listing-filter']/div/ul[@class='listing__sidebar-tags']")),resFiltr);
    }

    @Test(priority = 4)
    public void addLaptopToBasket(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.acceptCity();//мы обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.switchToSectionLaptop();
        laptopPage.addToBasketLaptop();
        String laptopSelected="Ноутбук Lenovo IdeaPad Gaming 3 15ACH6 Shadow Black (82K201N8RA)";
        //System.out.println(elements.getTextFromElementBy(By.xpath("//a[@class='header-tooltip__cards-item__title ']")));
        assertions.equalsOfStrings(elements.getTextFromElementBy(By.xpath("//a[@class='header-tooltip__cards-item__title ']")),laptopSelected);

    }
    @Test(priority = 5)
    public void noLaptopIncompatibleFilters(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.acceptCity();//мы обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.switchToSectionLaptop();
        laptopPage.choiseIncorrectFilterForLaptop();
        System.out.println(elements.getTextFromElementBy(By.xpath("//p[@class='product-listing__empty_text']")));
        String resText="На жаль, товарів по заданих параметрах, не знайдено. Виберіть інші параметри.";
        assertions.equalsOfStrings(elements.getTextFromElementBy(By.xpath("//p[@class='product-listing__empty_text']")),resText);

    }

}
