package pages;

import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//b[text()='TesterHome']")
    private WebElement wlogo;
    @FindBy(xpath = "//a[text()='社区']")
    private WebElement topics;
    @FindBy(xpath = "//a[text()='Bug 曝光台']")
    private WebElement bugs;
    @FindBy(xpath = "//a[text()='问答']")
    private WebElement questions;
    @FindBy(xpath = "//a[text()='社团']")
    private WebElement teams;
    @FindBy(xpath = "//a[text()='招聘']")
    private WebElement jobs;
    @FindBy(xpath = "//a[text()='Wiki']")
    private WebElement wiki;
    @FindBy(xpath = "//a[text()='开源项目']")
    private WebElement opensource;
    @FindBy(xpath = "//input[@class='form-control']")
    private WebElement txt_search;
    @FindBy(xpath = "//a[text()='登录']")
    private WebElement btn_login;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage gotologin(){
        click(btn_login);
        return new LoginPage(driver);
    }
}
