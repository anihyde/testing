package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class LoginPage {

    WebDriver driver;


    public LoginPage(WebDriver driver) {
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

    public LoginPage findSignUp() {
        driver.get("https://marketplace.appdirect.com/login?543796855");
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sign Up")));
        myDynamicElement.click();
        //driver.findElement(By.linkText("Sign Up")).click();
        return this;
    }

    public LoginPage findEmailBox() {
        WebElement emailBox = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("emailAddress")));
        emailBox.click();
        //driver.findElement(By.name("emailAddress")).click();
        return this;
    }

    public LoginPage signUpButton() {
        driver.get("https://marketplace.appdirect.com/signup?1773402678");
        WebElement signUp = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("userSignupButton")));
        signUp.click();
        //driver.findElement(By.name("userSignupButton")).click();
        return this;
    }

    public LoginPage inputEmail() {
        driver.get("https://marketplace.appdirect.com/signup?1773402678");
        WebElement inputEmail = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("emailAddress")));
        inputEmail.sendKeys("mail@prueba.com");
        //driver.findElement(By.name("emailAddress")).sendKeys("mail@prueba.com");
        signUpButton();
        return this;
    }

    public LoginPage inputWrongEmail() {
        driver.get("https://marketplace.appdirect.com/signup?1773402678");
        WebElement inputWrong = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("emailAddress")));
        inputWrong.sendKeys("mail");
        //driver.findElement(By.name("emailAddress")).sendKeys("mail");
        signUpButton();
        return this;
    }

    public LoginPage correctEmail() {
        driver.get("https://marketplace.appdirect.com/signup?1773402678");
        WebElement correct = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("emailAddress")));
        correct.sendKeys(randomString() + "@address.com");
        //driver.findElement(By.name("emailAddress")).sendKeys(randomString() + "@address.com");
        signUpButton();
        driver.getCurrentUrl();
        return this;
    }


}