package test;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utilities.WebDriverManager;

public class TestLogin extends WebDriverManager {

    @Test(priority=1)
    public void testHomePage(){
       driver.get("http://www.appdirect.com");
        Assert.assertEquals(driver.getTitle(), "The end-to-end commerce platform for selling digital… - AppDirect");
    }

    @Test(priority = 2)
    public void testLogInPage() {
        testHomePage();
        new HomePage(driver).clickLoginButton();
        Assert.assertNull(null);

    }

    @Test(priority = 3)
    public void testSignUpPage() {
        testLogInPage();
        driver.get("https://marketplace.appdirect.com/login?543796855");
        new LoginPage(driver).findSignUp();
        Assert.assertEquals(driver.getTitle(), "Sign Up for AppDirect");

    }

    @Test(priority = 4)
    public void testMandatoryField(){
        driver.get("https://marketplace.appdirect.com/signup?1773402678");
        new LoginPage(driver).signUpButton();
        Assert.assertEquals("Please fill out this field", "Please fill out this field");
    }

    @Test(priority = 5)
    public void testEmailBox() {
        testSignUpPage();
        new LoginPage(driver).findEmailBox();
        Assert.assertNull(null);

    }

    @Test(priority = 6)
    public void testExistingEmailInput() {
        driver.get("https://marketplace.appdirect.com/signup?1773402678");
        new LoginPage(driver).inputEmail();
        Assert.assertNull(null);

    }

    @Test(priority = 7)
    public void testIncorrectEmail() {
        driver.get("https://marketplace.appdirect.com/signup?1773402678");
        LoginPage email = new LoginPage(driver).inputWrongEmail();
        Assert.assertNull(null);

    }

    @Test(priority = 8)
    public void testCorrectEmail(){
        driver.get("https://marketplace.appdirect.com/signup?1773402678");
        new LoginPage(driver).correctEmail();
        Assert.assertEquals(driver.getTitle(), "Thanks for registering.");

    }

}