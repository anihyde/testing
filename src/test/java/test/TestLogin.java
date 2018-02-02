package test;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utilities.WebDriverManager;

public class TestLogin extends WebDriverManager {

    @Test(priority=1) //TC01 Succesfully enter AppDirect's webpage
    public void testHomePage(){
       driver.get("http://www.appdirect.com");
        Assert.assertEquals(driver.getTitle(), "The end-to-end commerce platform for selling digital… - AppDirect");
    }

    @Test(priority = 2) //TC02 Access Log In Page
    public void testLogInPage() {
        testHomePage();
        new HomePage(driver).clickLoginButton();

    }

    @Test(priority = 3) //TC03 Proceed to Sign Up page
    public void testSignUpPage() {
        testLogInPage();
        driver.get("https://marketplace.appdirect.com/login?543796855");
        new LoginPage(driver).findLogIn();
        Assert.assertEquals(driver.getTitle(), "Sign Up for AppDirect");

    }

    @Test(priority = 4) //TC04 Test email box functionality
    public void testEmailBox() throws InterruptedException {
        testSignUpPage();
        new LoginPage(driver).findEmailBox();
        Thread.sleep(10);
    }

    @Test(priority = 5) //TC05 Input existing email on box
    public void testExistingEmailInput() throws InterruptedException {
        driver.get("https://marketplace.appdirect.com/signup?1773402678");
        new LoginPage(driver).inputEmail();
        Thread.sleep(10);
    }

    @Test(priority = 6) //TC06 Input wrong type of email
    public void testIncorrectEmail() throws InterruptedException {
        driver.get("https://marketplace.appdirect.com/signup?1773402678");
        LoginPage email = new LoginPage(driver).inputWrongEmail();
        Thread.sleep(10);
    }

}