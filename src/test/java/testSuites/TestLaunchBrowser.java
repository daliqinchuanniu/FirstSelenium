package testSuites;

import framework.BrowserEngine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLaunchBrowser {
    private WebDriver driver;
    @BeforeClass
    public void setUp() throws Exception {
        BrowserEngine browserEngine = new BrowserEngine();
        browserEngine.initConfigData();
        driver = browserEngine.getBrowser();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void clickNews(){
        driver.findElement(By.xpath("//a[text()='登录']")).click();

    }
}
