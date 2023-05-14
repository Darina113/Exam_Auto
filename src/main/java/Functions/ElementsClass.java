package Functions;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ElementsClass {
        static final Logger logger = LoggerFactory.getLogger(ElementsClass.class);
        private final WebDriver driver;
        private final WaitersClass waiters;

        public ElementsClass(WebDriver driver){
            this.driver=driver;
            waiters = new WaitersClass(driver);
        }

        public WebElement findSingleElement(By by){
            try {
                waiters.waitvisabilityOFWebelement(by);
                logger.info("trying to find element by locator "+by.toString());
                return driver.findElement(by);
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
            return null;
        }

        public WebElement findElementByXpath(String xpath){//стринга и есть наш локатор
            try {
                waiters.waitvisabilityOFWebelement(By.xpath(xpath));
                return driver.findElement(By.xpath(xpath));
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
            return null;
        }
        public boolean isElementDisplayed(String xpath){
            return findElementByXpath(xpath).isDisplayed();
        }
    public boolean isElementDisplayed(By by){
        return findSingleElement(by).isDisplayed();
    }
    public boolean isElementSelected(By by){
            return findSingleElement(by).isSelected();
    }
    public boolean isElementSelected(String locator){
        return findElementByXpath(locator).isSelected();
    }

        public String getTextFromElementXpath(String xpath){
            return  findElementByXpath(xpath).getText();
        }
        public String getTextFromElementBy(By locator){
            logger.info("getting text from element "+locator.toString());
            return  findSingleElement(locator).getText();
        }
        public void clickOnElementByXpath(String xpath){
            findElementByXpath(xpath).click();
        }
        public void clickOnElementBy(By locators){
            logger.info("clicking on Element "+locators.toString());
            findSingleElement(locators).click();
        }
        public void sendKeysToElementWithXpath(String xpath,String text){
            findElementByXpath(xpath).sendKeys(text);
        }
        public void sendKeysToElementBy(By locator,String text){
            findSingleElement(locator).sendKeys(text);

        }


    }

