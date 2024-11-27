package myaccounts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {
    String baseURL = "http://tutorialsninja.com/demo/index.php";


    @Before
    public void setup() {
        openBrowser(baseURL);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> alloptions = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a"));
        for (WebElement options : alloptions) {
            if (options.getText().equalsIgnoreCase(option)) {
                options.click();
                break;


            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
//            1.1 Click on the My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

//            1.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

//
//            1.3 Verify the text “Register Account”.
        String expectedText = "Register Account";
        String actualText = getText(By.xpath("//h1[contains(text(),'Register Account')]"));
        Assert.assertEquals("Incorrect page", expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
//    2.1 Click on the My Account Link.
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]"));

//    2.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

//    2.3 Verify the text “Returning Customer”.
        String expectedText = "Returning Customer";
        String actualText = getText(By.xpath(("//h2[normalize-space()='Returning Customer']")));
        Assert.assertEquals("Incorrect page", expectedText, actualText);


    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
//                3.1 Click on the My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

//                3.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

//                3.3 Enter the First Name
        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Sima");

//                3.4 Enter the Last Name
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Patel");
//
//                3.5 Enter the Email
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("computer.0009@gmail.com");
//
//                3.6 Enter the Telephone
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("02083573573");
//                3.7 Enter the Password
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Tester123");
//                3.8 Enter the Password Confirm
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Tester123");

//                3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]"));

//                3.10 Click on the Privacy Policy check box
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));

//                3.11 Click on the Continue button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"));

//                3.12 Verify the message “Your Account Has Been Created!”

        Assert.assertEquals("Account creation message mismatch!", "Your Account Has Been Created!",
                getText(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")));


//                3.13 Click on the Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

//                3.14 Click on the My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

//                3.15 Call the method “selectMyAccountOptions()” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

//                3.16 Verify the text “Account Logout”
        Assert.assertEquals("Not logged out", "Account Logout",
                getText(By.xpath("//h1[normalize-space()='Account Logout']")));

//                3.17 Click on the Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){

//        4.1 Click on the My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

//        4.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

//        4.3 Enter the Email address
             driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("computer.0009@gmail.com");

//

//        4.5 Enter the Password
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Tester123");


//        4.6 Click on the Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));

//        4.7 Verify text “My Account”
        Assert.assertEquals("Not My Account", "My Account",
                getText(By.xpath("//h2[contains(text(),'My Account')]")));
//        4.8 Click on the My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

//        4.9 Call the method “selectMyAccountOptions()” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

//        4.10 Verify the text “Account Logout”

        Assert.assertEquals("Not logged out", "Account Logout",
                getText(By.xpath("//h1[normalize-space()='Account Logout']")));
//        4.11 Click on the Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }

    public void teardown() {
        driver.quit();
    }
}











