package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage   {
    WebDriver driver;
    By loginButton = By.id("login");
    public  HomePage(WebDriver driver)  {
        this.driver = driver;
    }
    //get the heading (the main heading which is present at the home page)
//    public String getHomeHeading()  {
//        String heading = driver.findElement(homeHeading).getText();
//        return  heading;
//    }
    public HomePage clickLoginButton()  {
        driver.findElement(loginButton).click();
        return  this;
    }
}
