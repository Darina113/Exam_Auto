import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TVPageTest extends BaseTest{
    @Test(priority = 1)
    public void titleTVPageTest(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        //mainPage.acceptCity();//мы обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.switchToSectionTV();
        tvPage.checkNameOfPage();
        //String titleNameTV="Телевізори у Дніпрі купити в Фокстрот";
        //assertions.equalsOfStrings(driver.getTitle(),titleNameTV);
    }
    @Test(priority = 2)
    public void sectionTMonTVTest(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        //mainPage.acceptCity();//мы обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.switchToSectionTV();
        tvPage.clickOnElement(By.xpath("//div[@id='group-9501']"));
        List<WebElement> listTM=driver.findElements(By.xpath("//div[@id='group-9501']//following-sibling::div/a/div/label"));
        assertTrue(listTM.size()==18);

    }
    @Test(priority =3)
    public void compareTv(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        //mainPage.acceptCity();//мы обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.switchToSectionTV();
        tvPage.addTwoTVtoCompare();
        tvPage.checkToIncludesInCompare();
        List<WebElement> listOfCompare=driver.findElements(By.xpath("//div[@class='header-tooltip__cards-col groups-to-compare']/div/div/div/following-sibling::div[2]/a"));
        String[] massivIsTexta={"Телевізор SAMSUNG UE43BU8000UXUA","Телевізор HISENSE 50A6BG"};
        for (int i = 0; i < massivIsTexta.length; i++) {
                assertions.equalsOfStrings(listOfCompare.get(i).getText(),massivIsTexta[i]);
        }
    }

    @Test(priority = 4)
    public void changePricePerMonthTest(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        //mainPage.acceptCity();//мы обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.switchToSectionTV();
        tvPage.switchToPricePerMonth();
        assertions.equalsOfStrings(elements.getTextFromElementBy(By.xpath("//a[@data-id='4429']/span[2]")),"1900");

    }

    @Test(priority = 5)
    public void fromCheapToExpensiveTVTest(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        //mainPage.acceptCity();//мы обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.switchToSectionTV();
        tvPage.switchToFirstCheapToExpensiveProducts();
        String theMinPrice="3 899 ₴";
        assertions.equalsOfStrings(elements.getTextFromElementBy(By.xpath("//div[@data-id='3643']/following-sibling::div/div[2]/div/div/div[2]")),theMinPrice);

    }
}
