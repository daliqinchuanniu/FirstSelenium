package pages;

import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user_login")
    private WebElement username;
    @FindBy(id = "user_password")
    private WebElement password;
    @FindBy(xpath = "//input[@value='登录']")
    private WebElement btn_commit;
    @FindBy(xpath = "//div[@class='alert-warning']/a")
    private WebElement F_msg;
    private String F_message;

    public FirstPage login_Success(String username,String password){
        type(this.username,username);
        type(this.password,password);
        click(btn_commit);

        return new FirstPage(driver);
    }

    public String login_Failed(String username,String password){
        type(this.username,username);
        type(this.password,password);
        click(btn_commit);

        return F_message = F_msg.getText();
    }

}
