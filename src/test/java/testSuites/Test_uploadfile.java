package testSuites;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.personal.PersonalPage;

public class Test_uploadfile {

    @BeforeClass
    public void setUp(){

    }

    @AfterClass
    public void tearDown(){
        Test_Loginpage.driver.quit();
    }

    @Test
    public void test_upload(){
        PersonalPage personalPage = PageFactory.initElements(Test_Loginpage.driver,PersonalPage.class);
        personalPage.setUploadfile();
    }
}
