package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.amazon.avod.thirdpartyclient:id/splash_screen_root\"]")
    WebElement splashscreen;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"ap_email_login\"]")
    WebElement email;
    @FindBy(xpath = "//android.view.View[@resource-id=\"continue\"]")
    WebElement continueButton;
    @FindBy(xpath = "//android.view.View[@resource-id=\"auth-password-container\"]")
    WebElement password;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"signInSubmit\"]")
    WebElement signInSubmit;


    public WebElement splashscreen(WebDriver driver) {
        return (splashscreen);
    }

    public WebElement email(WebDriver driver) {
        return (email);
    }

    public WebElement continueButton(WebDriver driver) {
        return (continueButton);
    }
    public WebElement password(WebDriver driver) {
        return (password);
    }
    public WebElement signInSubmit(WebDriver driver) {
        return (signInSubmit);
    }



}
