package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage  {
    WebDriver driver;
    // Declaring the xpath for the heading in By class
    By pageHeading = By.xpath("//table//tr[3][@class='heading3']");

    public  MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    //get the heading (username for which the account belongs to)
    public String getHeading()  {
        String heading = driver.findElement(pageHeading).getText();
        return  heading;
    }
}