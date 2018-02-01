package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebDriverManager {

        public WebDriver driver = null;
        @BeforeTest
        public void setUp() throws Exception {
            // setting the driver executable for chrome browser
            //System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
            driver = new ChromeDriver();                // created a new instance for chrome driver
            driver.manage().window().maximize();
        }

        @AfterTest
        public void tearDown(){
        driver.quit();

        }

}
