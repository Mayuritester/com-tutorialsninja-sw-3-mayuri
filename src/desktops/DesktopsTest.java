package desktops;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

public class DesktopsTest extends Utility {

    String baseURL = "http://tutorialsninja.com/demo/index.php";


    @Before
    public void setup (){
        openBrowser(baseURL);
    }
@Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
//        1.1 Mouse hover on the Desktops Tab. and click
        WebElement desktops = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(desktops).click().build().perform();

//        1.2 Click on “Show AllDesktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));

//        1.3 Select Sort By position "Name: Z to A"
        WebElement atoz = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select position = new Select(atoz);
        position.selectByVisibleText("Name (Z - A)");

//        1.4 Verify the Product will be arranged in Descending order.
        String expectedText = "Name (Z - A)";
        String actualText = getText(By.xpath("//option[contains(text(),'Name (Z - A)')]"));
        Assert.assertEquals("Not is descending order",expectedText,actualText);

    }
   @Test
    public void verifyProductAddedToShoppingCartSuccessFully(){

//       2.1 Mouse hover on the Currency Dropdown and click
       WebElement currancy = driver.findElement(By.xpath("//span[contains(text(),'Currency')]"));
       Actions action = new Actions(driver);
       action.moveToElement(currancy).click().build().perform();

//       2.2 Mouse hover on the £Pound Sterling and click
       WebElement pound = driver.findElement(By.xpath("//button[contains(text(),'£Pound Sterling')]"));
       Actions currancyPounds = new Actions(driver);
       currancyPounds.moveToElement(pound).click().build().perform();

//       2.3 Mouse hover on the Desktops Tab.
       WebElement desktops = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
       Actions action1 = new Actions(driver);
       action1.moveToElement(desktops).click().build().perform();

//       2.4 Click on the “Show AllDesktops”
       clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));

//       2.5 Select the Sort By position "Name: A to Z"
       WebElement ztoa = driver.findElement(By.xpath("//select[@id='input-sort']"));
       Select position2 = new Select(ztoa);
       position2.selectByVisibleText("Name (A - Z)");

       //2.6 Select product “HP LP3065”
       clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));

//       2.7 Verify the Text "HP LP3065"
       String expectedText = "HP LP3065";
       String actualText = getText(By.partialLinkText("HP LP30"));
       Assert.assertEquals("Incorrect product",expectedText,actualText);

//       2.8 Select Delivery Date "2024-11-27"
       driver.findElement(By.xpath("//input[@id='input-option225']")).clear();
       driver.findElement(By.xpath("//input[@id='input-option225']")).sendKeys("2024-11-27");

//       2.9.Enter Qty "1” using Select class.
         clickOnElement(By.xpath("//input[@id='input-quantity']"));

//       2.10 Click on the “Add to Cart” button
       clickOnElement(By.xpath("//button[@id='button-cart']"));

//       2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
       String actualText2 = getText(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible"));
       System.out.println(actualText2);
       Assert.assertTrue("no order added",actualText2.contains(actualText2));


//       2.12 Click on the link “shopping cart” displayed in a success message
       clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

//       2.13 Verify the text "Shopping Cart"
       String expectedText3 = "Shopping Cart  (1.00kg)";
       String actualText3 = getText(By.cssSelector("body:nth-child(2) div.container:nth-child(4) div.row div.col-sm-12 > h1:nth-child(1)"));
       Assert.assertEquals("no order added",expectedText3,actualText3);

//       2.14 Verify the Product name "HP LP3065"
       String expectedText4 = "HP LP3065";
       String actualText4 = getText(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
       Assert.assertEquals("incorrect product",expectedText4,actualText4);

//       2.15 Verify the Delivery Date "2024-11-27"
       String expectedText5 = "Delivery Date:2024-11-27";
       String actualText5 = getText(By.xpath("//small[contains(text(),'Delivery Date:2024-11-27')]"));
       Assert.assertEquals("incorrect date",expectedText5,actualText5);

//       2.16 Verify the Model "Product21"
       String expectedText6 = "Product 21";
       String actualText6 = getText(By.xpath("//td[contains(text(),'Product 21')]"));
       Assert.assertEquals("incorrect date",expectedText6,actualText6);


//       2.17 Verify the Totat "£74.73"
       String expectedText7 = "£74.73";
       String actualText7 = getText(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
       Assert.assertEquals("incorrect total",expectedText7,actualText7);

   }

   public void teardown(){
        driver.quit();
   }


}
