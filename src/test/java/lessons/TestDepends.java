package lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestDepends {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/shaozhen/Desktop/Hogwarts/myPath/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    }

    @Test
    public void openTesterhome(){
        driver.get("https://testerhome.com/");
        System.out.println(driver.getTitle());
    }

    @Test(dependsOnMethods = {"openTesterhome"})
    public void gotoLogin(){
        driver.findElement(By.xpath("//a[text()='登录']")).click();
    }

    @Test(dependsOnMethods = {"gotoLogin"})
    public void test_login(){
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("daliqinchuanniu@163.com");
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys("CHRDW*hdhxt");
        driver.findElement(By.xpath("//input[@value='登录']")).click();
    }

    @Test(dependsOnMethods = {"test_login"},enabled = false)
    public void test_Notification(){
        driver.findElement(By.xpath("//a[@href='/notifications']")).click();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
