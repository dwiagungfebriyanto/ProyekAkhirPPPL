package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginObject {
    WebDriver driver;

    public LoginObject(WebDriver driver) {
        this.driver = driver;
    }

    public By getInputEmail() {
        return By.id("email");
    }

    public By getInputPassword() {
        return By.id("password");
    }

    public By getEmailOuter() {
        return By.xpath("(//div[@class='v-field__field'])[1]");
    }

    public By getPasswordOuter() {
        return By.xpath("(//div[@class='v-field__field'])[2]");
    }

    public By getSubmitBtn() {
        return By.id("btn-submit");
    }

    public By getRegisterBtn() {
        return By.id("to-register");
    }
}
