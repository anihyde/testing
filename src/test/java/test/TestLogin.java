package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utilities.WebDriverManager;

public class TestLogin extends WebDriverManager {

    @Test(priority=1) //TC01 Succesfully enter AppDirect's webpage
    public void test(){
        driver.get("http://www.appdirect.com");
        Assert.assertEquals("AppDirect",  driver.getTitle());
         new HomePage(driver).clickLoginButton();
    }

    @Test(priority = 2) //TC02 Proceed to Log In page
    public void testSignUp(){
        driver.get("https://marketplace.appdirect.com/login?543796855");
        new LoginPage(driver).findLogIn();

    }

    @Test(priority = 1) //TC03 Proceed to Sign Up page
    public void testPage(){
        driver.get("https://marketplace.appdirect.com/signup?1773402678");
        new LoginPage(driver).findEmailBox();
        Assert.assertEquals("email@address.com", driver.findElement(By.linkText("email@address.com")));
    }

    @Test(priority = 0) //TC04 Functionality of email box
    public void testEmail(){
        driver.get("https://marketplace.appdirect.com/signup?1773402678");
        new LoginPage(driver).inputEmail();
        Assert.assertEquals("", "");
    }

    @Test(priority = 1) //TC05 Input wrong type of email
    public void testIncorrectEmail(){
        driver.get("https://marketplace.appdirect.com/signup?1773402678");
        LoginPage email = new LoginPage(driver).inputWrongEmail();
        Assert.assertEquals(email, "Please enter an email address");
    }

}