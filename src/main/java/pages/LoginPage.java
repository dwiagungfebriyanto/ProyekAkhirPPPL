package pages;

import io.cucumber.java.sl.In;
import object.LoginObject;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    LoginObject loginObject;
    String loginUrl = "http://localhost:5173/login";

    public LoginPage(WebDriver driver) {
        super(driver);
        loginObject = new LoginObject(driver);
    }

    public void enterEmail(String email) throws InterruptedException {
        inputText(loginObject.getInputEmail(), email);
    }

    public void enterPassword(String password) throws InterruptedException {
        inputText(loginObject.getInputPassword(), password);
    }

    public void clickEmail() throws InterruptedException {
        click(loginObject.getEmailOuter());
    }

    public void clickPassword() throws InterruptedException {
        click(loginObject.getPasswordOuter());
    }

    public void clickSubmitBtn() throws InterruptedException {
        click(loginObject.getSubmitBtn());
    }

    public void clearEmail() throws InterruptedException {
        clearText(loginObject.getInputEmail());
    }

    public void clearPassword() throws InterruptedException {
        clearText(loginObject.getInputPassword());
    }

    public String getLoginUrl() {
        return loginUrl;
    }
}
