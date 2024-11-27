package laptopsandnotebooks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

public class LaptopsAndNotebooksTest extends Utility {

    String baseURL = "http://tutorialsninja.com/demo/index.php";


    @Before
    public void setup (){
        openBrowser(baseURL);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
//        1.1 Mouse hover on the Laptops & Notebooks Tab. and click
        WebElement laptopsNotebooks = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        Actions laptops = new Actions(driver);
        laptops.moveToElement(laptopsNotebooks).click().build().perform();

//        1.2 Click on “Show AllLaptops & Notebooks”
           clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));


//        1.3 Select the Sort By "Price (High > Low)"
        WebElement highToLow = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select sort = new Select(highToLow);
        sort.selectByVisibleText("Price (High > Low)");

//        1.4 Verify the Product price will be arranged in High to Low orders.
        String expectedText = "Price (High > Low)";
        String actualText = getText(By.xpath("//option[contains(text(),'Price (High > Low)')]"));
        Assert.assertEquals("incorrect order",expectedText,actualText);


    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully(){

//        2.1 Mouse hover on the Laptops & Notebooks Tab and click
        WebElement laptopsNotebooks = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        Actions laptops = new Actions(driver);
        laptops.moveToElement(laptopsNotebooks).click().build().perform();

//        2.2 Click on the “Show AllLaptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));


//        2.3 Select Sort By "Price (High > Low)"
        WebElement highToLow = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select sort = new Select(highToLow);
        sort.selectByVisibleText("Price (High > Low)");

//        2.4 Select Product “MacBook”
              clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));

//        2.5 Verify the text “MacBook”
        String expectedText = "MacBook";
        String actualText = getText(By.xpath("//h1[contains(text(),'MacBook')]"));
        Assert.assertEquals("incorrect product",expectedText,actualText);

//        2.6 Click on the ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

//        2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String expectedText1 = "Success: You have added MacBook to your shopping cart!";
        String actualText1 = getText(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible"));
        Assert.assertTrue("product not added",expectedText1.contains(expectedText1));

//        2.8 Click on the link “shopping cart” display into the success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

//        2.9 Verify the text "Shopping Cart"
        String expectedText3 = "Shopping Cart  (0.00kg)";
        String actualText3 = getText(By.cssSelector("body:nth-child(2) div.container:nth-child(4) div.row div.col-sm-12 > h1:nth-child(1)"));
        Assert.assertEquals("no order added",expectedText3,actualText3);

//        2.10 Verify the Product name "MacBook"
        String expectedText4 = "MacBook";
        String actualText4 = getText(By.xpath("//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        Assert.assertEquals("incorrect product name",expectedText4,actualText4);

//        2.11 Change the Quantity "2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).sendKeys("2");

//        2.12 Click on the “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));

//        2.13 Verify the message “Success: You have modified your shopping cart!”
        String expectedText5 = "Success: You have modified your shopping cart!";
        String actualText5 = getText(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible"));
        Assert.assertTrue("product not added",actualText5.contains(expectedText5));

//        2.14 Verify the Total £737.45
        String expectedText6 = "£737.45";
        String actualText6 = getText(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        Assert.assertEquals("product not added",expectedText6, actualText6);


//        2.15 Click on the “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));

//        2.16 Verify the text “Checkout”

//        2.17 Verify the Text “New Customer”
//        2.18 Click on the “Guest Checkout” radio button
//        2.19 Click on “Continue” tab
//        2.20 Fill the mandatory fields
//        2.21 Click on “Continue”Button
//        2.22 Add Comments About your order into the text area
//        2.23 Check the Terms & Conditions check box
//        2.24 Click on the “Continue” button
//        2.25 Verify the message “Warning: Payment method required!”
    }

    public void teardown(){
        driver.quit();
    }

}
