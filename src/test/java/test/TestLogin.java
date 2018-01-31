package test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utilities.WebDriverManager;

public class TestLogin extends WebDriverManager {

    @Test(priority=1)
    public void test() throws InterruptedException{
        driver.get("http://www.appdirect.com");

        new HomePage(driver).clickLoginButton();
//      fill the login form
//        new LoginPage(driver)
//                .usernameAs("foo@bar.com")
//                .passwordAs("secret")
//                .submit();
//      check if redirected to account page with user name foo@bar.com
//        String accountHeading = new HomePage(driver).getHomeHeading() ;
//        Assert.assertEquals(accountHeading, "Welcome foo@bar.com ", "not at the account page");
    }
}