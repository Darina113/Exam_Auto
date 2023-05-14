import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ManePageTests  extends BaseTest{

    @Test
    public void searchFoxOne() {
        String input = "restofrest";
        mainPage.openPage();
        mainPage.searchByText(input);
        searchResultPage.waitForPageLoaded();
        searchResultPage.waitForH1Loaded();
        if(searchResultPage.getTextFromH1().contains("Найдено по запросу")){
            searchResultPage.checkH1ElementContainsText(input);
        }else if(searchResultPage.getTextFromH1().contains("Результаты поиска")){
            searchResultPage.checkLabelElementContainsText(input);
        }
    }

    @Test
    public void searchFoxTwo() {
        String input = "input";
        mainPage.openPage();
        mainPage.searchByText(input);
        searchResultPage.waitForPageLoaded();
        searchResultPage.waitForH1Loaded();
        if(searchResultPage.getTextFromH1().contains("Найдено по запросу")){
            searchResultPage.checkH1ElementContainsText(input);
        }else if(searchResultPage.getTextFromH1().contains("Результаты поиска")){
            searchResultPage.checkLabelElementContainsText(input);
        }
    }

    @Test
    public void searchFoxThree() {
        String input = "car";
        mainPage.openPage();
        mainPage.searchByText(input);
        searchResultPage.waitForPageLoaded();
        searchResultPage.waitForH1Loaded();
        if(searchResultPage.getTextFromH1().contains("Найдено по запросу")){
            searchResultPage.checkH1ElementContainsText(input);
        }else if(searchResultPage.getTextFromH1().contains("Результаты поиска")){
            searchResultPage.checkLabelElementContainsText(input);
        }
    }
    @Test
    public void searchFoxFour() {
        String input = "car";
        mainPage.openPage();
        mainPage.searchByText(input);
        searchResultPage.waitForPageLoaded();
        searchResultPage.waitForH1Loaded();
        if(searchResultPage.getTextFromH1().contains("Найдено по запросу")){
            searchResultPage.checkH1ElementContainsText(input);
        }else if(searchResultPage.getTextFromH1().contains("Результаты поиска")){
            searchResultPage.checkLabelElementContainsText(input);
        }
        assertions.equalsOfStrings("Strri","svsvvsd");
    }
}
