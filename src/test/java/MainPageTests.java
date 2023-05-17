import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MainPageTests extends BaseTest{

    @Test(priority = 1)
    public void titleTest() {
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        String title="≡ Інтернет магазин ФОКСТРОТ | Мережа магазинів побутової техніки та електроніки в Україні";
        assertions.equalsOfStrings(driver.getTitle(), title);
    }

    @Test(priority = 2)
    public void locationTest(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.acceptCity();//мы обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.changeCity();//мы обращаемся к классу mainPage и вызываем метод мой стандартный до момента ввода необходимого города
        mainPage.choiceCity("Львів");//мы обращаемся к классу mainPage и вызываем метод кот.принимает город
    }
    @Test(priority = 3)
    public void switchLangTest(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.acceptCity();//мы обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.switchLanguage();
        String elementToTest="Актуальные предложения";
        assertions.equalsOfElementAndLabelText(By.xpath("//div[@class='current-offer-head']/div[@class='page__title']"),elementToTest);
    }
    @Test(priority = 4)
    public void comeBackToMainPage(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.acceptCity();//мы обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.searchByText("iPhone");
        tvPage.waitForH1Loaded();
        tvPage.clickOnIcon();//мы обращаемся к классу searchResultPage и вызываем метод кликанья на логотип Фокстрота
        String currentURL="https://www.foxtrot.com.ua/uk/shop/dnepr.html";
        assertions.equalsOfStrings(driver.getCurrentUrl(), currentURL);

    }
    @Test(priority = 5)
    public void rederectToFacebook(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.acceptCity();//мы обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        Set<String> setFirst = driver.getWindowHandles(); //получаем идент.номер первого окна из множества открытых окон
        mainPage.clickOnSocialNet();
        Set<String> setSecond = driver.getWindowHandles(); //получаем идент.номер второго окна из множества открытых окон
        setSecond.removeAll(setFirst);//убираем дубликаты
        String secondDesc = setSecond.iterator().next(); //получаем дискриптор нужного нам окна
        driver.switchTo().window(secondDesc);
        String curURLFB="https://www.facebook.com/foxtrotinfo";
        System.out.println(driver.getCurrentUrl());
        assertions.equalsOfStrings(driver.getCurrentUrl(),curURLFB);

    }

}
