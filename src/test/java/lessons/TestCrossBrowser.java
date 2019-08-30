package lessons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCrossBrowser {
    @Parameters("Browser")
    @Test
    public void startBrowser(String browser){

        if (browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","/Users/shaozhen/Desktop/Hogwarts/myPath/geckodriver");
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("http://www.baidu.com");
            driver.quit();
        } else if(browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","/Users/shaozhen/Desktop/Hogwarts/myPath/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://www.baidu.com");
            driver.quit();
        }

    }
}
