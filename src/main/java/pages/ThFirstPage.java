package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThFirstPage {

    @FindBy(xpath = "//a[text()='注册']")
    private WebElement btn_register;
    @FindBy(xpath = "//a[text()='登录']")
    private WebElement btn_login;


    public void gotologin(){
        btn_login.click();
    }

}
