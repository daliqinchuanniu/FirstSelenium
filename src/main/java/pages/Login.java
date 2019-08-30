package pages;

import framework.BrowserEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Login {
    public WebDriver driver;

    public void initSetup() throws Exception {
        BrowserEngine browserEngine = new BrowserEngine();
        browserEngine.initConfigData();
        driver = browserEngine.getBrowser();
    }

    public void loginValid(){
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        homePage.gotologin();

        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.login_Success("daliqinchuanniu@163.com","CHRDW*hdhxt");
    }
}
