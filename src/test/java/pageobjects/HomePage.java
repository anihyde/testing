package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage   {
    WebDriver driver;
    By loginButton = By.id("login");
    public  HomePage(WebDriver driver)  {
        this.driver = driver;
    }

    public HomePage clickLoginButton()  {
        driver.findElement(loginButton).click();
        return  this;
    }
}
