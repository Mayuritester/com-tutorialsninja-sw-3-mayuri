package homepage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

public class TopMenuTest extends Utility {
    String baseURL = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setup (){
        openBrowser(baseURL);
    }

    public void selectMenu (String menu){
        clickOnElement(By.linkText(menu));
    }
@Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
//        1.1 Mouse hover on the “Desktops” Tab and click
        WebElement desktops = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(desktops).click().build().perform();

//        1.2 call the selectMenu() method and pass the menu = “Show AllDesktops”
          selectMenu("Show AllDesktops");


//        1.3 Verify the text ‘Desktops’
    String expectedText = "Desktops";
    String actualText = getText(By.xpath("//h2[contains(text(),'Desktops')]"));
    Assert.assertEquals("Wrong page",expectedText,actualText);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
//        2.1 Mouse hover on the “Laptops & Notebooks” Tab and click
          WebElement laptopsNotebooks = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
          Actions laptops = new Actions(driver);
          laptops.moveToElement(laptopsNotebooks).click().build().perform();

//        2.2 call selectMenu() method and pass the menu = “Show AllLaptops & Notebooks”
             selectMenu("Show AllLaptops & Notebooks");

//        2.3 Verify the text ‘Laptops & Notebooks’
        String expectedText1 = "Laptops & Notebooks";
        String actualText1 = getText(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
        Assert.assertEquals("Wrong page", expectedText1,actualText1);

    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){

//        3.1 Mouse hover on the “Components” Tab and click
          WebElement components = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
          Actions component = new Actions(driver);
          component.moveToElement(components).click().build().perform();

//        3.2 call the selectMenu() method and pass the menu = “Show AllComponents”
          selectMenu("Show AllComponents");

//        3.3 Verify the text ‘Components’
        String expectedText2 = "Components";
        String actualText2 = getText(By.xpath("//h2[contains(text(),'Components')]"));
        Assert.assertEquals("Wrong page", expectedText2,actualText2);
    }

    public void tearDown(){
        driver.quit();
    }

}
