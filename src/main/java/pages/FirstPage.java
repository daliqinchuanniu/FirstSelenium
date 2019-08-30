package pages;

import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.personal.*;

public class FirstPage extends BasePage {

    @FindBy(xpath = "//a[@class='dropdown-toggle'][1]") //点击才能显示如下的内容
    private WebElement usereditplus;

    @FindBy(xpath = "//ul[@class='dropdown-menu'][1]/li[1]/a")  //显示用户名
    private WebElement user;

    @FindBy(xpath = "//a[text()='个人资料设置']")              //个人资料设置
    private WebElement setting;

    @FindBy(xpath = "//a[text()='我的专栏']")                //我的专栏
    private WebElement columns;

    @FindBy(xpath = "//a[text()='我的收藏']")             //我的收藏
    private WebElement favorities;

    @FindBy(xpath = "//a[text()='记事本']")                   //记事本
    private WebElement notes;

    @FindBy(xpath = "//a[text()='退出']")                     //退出
    private WebElement exit;

    public FirstPage(WebDriver driver) {
        super(driver);
    }

    public void userclick(){
        click(usereditplus);
    }


    //获取用户名称
    public String getUsername(){
        return user.getText();
    }

    public UserPage gotoUserPage(){
        click(user);
        return new UserPage(driver);
    }
    //个人资料设置页面
    public PersonalPage gotoSetting(){
        click(setting);
        return new PersonalPage(driver);
    }

    //我的专栏页面
    public ColumnPage gotoColumn(){
        click(columns);
        return new ColumnPage(driver);
    }

    //我的收藏页面
    public FavorityPage gotoFavority(){
        click(favorities);
        return new FavorityPage(driver);
    }

    //记事本页面
    public NotePage havenewNote(){
        click(notes);
        return new NotePage(driver);
    }

    //退出用户页面
    public HomePage logout(){
        click(exit);
        return new HomePage(driver);
    }
}
