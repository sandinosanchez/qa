package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "inputEmail")
    private WebElement email;

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy()
    private WebElement captcha;

    @FindBy()
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
