package pages.personal;

import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalPage extends BasePage {
    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user_avatar")
    private WebElement uploadfile;
    @FindBy(xpath = "//button[text()='更新资料']")
    private WebElement b_click;

    public void setUploadfile(){
        uploadfile.sendKeys("/Users/shaozhen/Desktop/Hogwarts/Pictures/sheli10.jpeg");//是可以的
        click(b_click);
    }
}
