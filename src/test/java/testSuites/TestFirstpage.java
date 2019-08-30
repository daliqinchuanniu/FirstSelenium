package testSuites;

import framework.BrowserEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FirstPage;
import pages.HomePage;
import pages.LoginPage;


public class TestFirstpage {
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
    public void gotoLogin(){
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        homePage.gotologin();
    }

    @Test(dependsOnMethods = {"gotoLogin"})
    public void test_login(){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.login_Success("daliqinchuanniu@163.com","CHRDW*hdhxt");
        FirstPage firstPage = PageFactory.initElements(driver,FirstPage.class);
        firstPage.userclick();
        Assert.assertEquals(firstPage.getUsername(),"daliqinchuanniu");
    }
}
