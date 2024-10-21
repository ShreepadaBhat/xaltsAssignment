package webUITesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestClass {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
    	// Set the path for ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shreepada\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://xaltsocnportal.web.app");
        WebDriverWait wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

