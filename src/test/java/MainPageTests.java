import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

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
        mainPage.choiceCity("Харків");//мы обращаемся к классу mainPage и вызываем метод кот.принимает город

    }

}
