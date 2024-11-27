package utility;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {

    public void clickOnElement (By by){
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public String getText (By by){
        return driver.findElement(by).getText();
    }

    public void writeTest (By by, String text){

    }

}
