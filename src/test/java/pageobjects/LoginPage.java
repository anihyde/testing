package pageobjects;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class LoginPage  {

    WebDriver driver;

    public  LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    protected String randomString() { //Generate random emails for testing
        String randomString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder builder = new StringBuilder();
        Random rnd = new Random();
        while (builder.length() < 10) {
            int index = (int) (rnd.nextFloat() * randomString.length());
                builder.append(randomString.charAt(index));
        }
        String saltStr = builder.toString();
        return saltStr;

    }
    public LoginPage findSignUp()   {
        driver.findElement(By.linkText("Sign Up")).click();
        return this;
    }

    public LoginPage findEmailBox(){
        driver.findElement(By.name("emailAddress")).click();
        return this;
    }

    public LoginPage signUpButton(){
        driver.findElement(By.name("userSignupButton")).click();
        return this;
    }

    public LoginPage inputEmail(){
        driver.findElement(By.name("emailAddress")).sendKeys("mail@prueba.com");
        signUpButton();
        return this;
    }

    public LoginPage inputWrongEmail(){
        driver.findElement(By.name("emailAddress")).sendKeys("mail");
        signUpButton();
        return this;
    }

    public LoginPage correctEmail(){
        driver.findElement(By.name("emailAddress")).sendKeys(randomString() + "@address.com");
        signUpButton();
        driver.getCurrentUrl();
        return this;
    }


}