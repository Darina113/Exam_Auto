import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SearchResultPageTest extends BaseTest{
    @Test
    public void resultSearchTest(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.searchByText("Мобільні телефони Iphone");
        System.out.println(searchResultPage.getTextFromH1());
        assertEquals(searchResultPage.getTextFromH1(),"«Мобільні телефони Iphone»");//переделать на собств.ассерті
        //assertions.equalsOfElementAndLabelText(searchResultPage.getTextFromH1(), "Мобільні телефони Iphone");
        //searchResultPage.checkLabelElementContainsText("Мобільні телефони Iphone");
    }
}
