import Functions.AssertionsClass;
import Driver.DriverClass;
import Functions.ActionClass;
import Functions.ElementsClass;
import Functions.WaitersClass;
import Pages.BasePage;
import Pages.LaptopPage;
import Pages.MainPage;
import Pages.TVPage;
import Utils.TestResultListeners;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;


@Listeners(TestResultListeners.class)
public class BaseTest {
    static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver = DriverClass.startChromeDriver();
    protected BasePage basePage = new BasePage(driver);
    protected MainPage mainPage = new MainPage(driver);
    protected LaptopPage laptopPage=new LaptopPage(driver);
    protected TVPage tvPage = new TVPage(driver);
    protected WaitersClass waiters = new WaitersClass(driver);
    protected ActionClass action = new ActionClass(driver);
    protected AssertionsClass assertions = new AssertionsClass(driver);
    protected ElementsClass elements = new ElementsClass(driver);

    @AfterSuite
    public void closeDriver(){
        logger.info("driver is closing");
        driver.quit();
    }
}
