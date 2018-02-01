package pageobjects;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage  {

    WebDriver driver;

    public  LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage findLogIn()   {
        driver.findElement(By.linkText("Sign Up")).click();

        return this;
    }

    public LoginPage findEmailBox(){
        driver.findElement(By.cssSelector("input[type='email'][value='email@address.com']")).click();
        return this;
    }

    public LoginPage inputEmail(){
        driver.findElement(By.cssSelector("input[type='email'][value='email@address.com']")).sendKeys("mail@prueba.com");
        driver.findElement(By.id("idb")).click();
        return this;
    }
}