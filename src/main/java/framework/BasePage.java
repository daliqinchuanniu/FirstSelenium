package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class BasePage {
    protected static WebDriver driver;
    protected static String pageTitle;
    protected static String pageUrl;

    protected BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected void type(WebElement element,String text){
        if (element.isEnabled()){
            element.clear();
            element.sendKeys(text);
        }
    }

    protected void click(WebElement element){
        if (element.isEnabled()){
            element.click();
        }
    }

    protected String getCurrentPageTile(){
        return pageTitle = driver.getTitle();
    }

    protected String getCurrentPageUrl(){
        return pageUrl = driver.getCurrentUrl();
    }

    public void switchWindow(){
        String currentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        while (it.hasNext()){
            if (currentWindow == it.next()){
                continue;
            }
            driver.close();
            WebDriver window = driver.switchTo().window(it.next());
        }
    }
}
