package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage  {
    WebDriver driver;

    By username = By.id("email");
    By password = By.name("email");
    By submitButton = By.cssSelector("input[type='submit']");
    public  LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage usernameAs(String email)   {
        driver.findElement(username).sendKeys(email);
        return  this;
    }
    public LoginPage passwordAs(String pass)    {
        driver.findElement(password).sendKeys(pass);
        return  this;
    }
    public void submit(){
        driver.findElement(submitButton).click();
    }
}