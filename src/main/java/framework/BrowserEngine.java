package framework;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BrowserEngine {
    protected String browserName;
    protected String serverURL;
    protected WebDriver driver;
    Logger logger = Logger.getLogger("Testerhome");

    public void initConfigData() throws Exception {
        PropertyConfigurator.configure("./src/main/resources/log4j.properties");
        Properties p = new Properties();
        FileInputStream fis = new FileInputStream("./src/main/java/config/config.properties");
        p.load(fis);
        logger.info("start to select browser name from properties.");
        browserName = p.getProperty("browserName");
        logger.info("You had select test browser is :"+browserName);
        serverURL = p.getProperty("URL");
        logger.info("The test server URL is:"+serverURL);

        fis.close();
    }

    public WebDriver getBrowser(){
        if(browserName.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","/Users/shaozhen/Desktop/Hogwarts/myPath/geckodriver");
            driver = createFirefoxDriver();
            logger.info("Launching Firefox...");
        } else if(browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","/Users/shaozhen/Desktop/Hogwarts/myPath/chromedriver");
            driver = new ChromeDriver();
            logger.info("Launching Chrome...");
        } else if(browserName.equalsIgnoreCase("IE")){

        }

        driver.get(serverURL);
        logger.info("Open URL: "+serverURL);
        driver.manage().window().maximize();
        logger.info("Maximize the browser...");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logger.info("Wait for 30 seconds");
        return driver;
    }

    private WebDriver createFirefoxDriver() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("prefs.converted-to-utf8",true);
        firefoxProfile.setPreference("browser.download.folderList",2);
        firefoxProfile.setPreference("browser.download.dir","./src/main/TestDownload");

        WebDriver driver = new FirefoxDriver();

        return driver;
    }
}
