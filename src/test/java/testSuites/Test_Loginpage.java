package testSuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FirstPage;
import pages.Login;

public class Test_Loginpage {
    public static WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        Login login = new Login();
        login.initSetup();
        login.loginValid();
        driver = login.driver;
    }

    @AfterClass
    public void tearDown(){

    }

    @Test
    public void test_logout(){
        FirstPage firstPage = PageFactory.initElements(driver,FirstPage.class);
        firstPage.userclick();
        firstPage.gotoSetting();
//        firstPage.logout();
    }
}
