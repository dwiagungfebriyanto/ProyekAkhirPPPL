package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginObject {
    WebDriver driver;
    WebDriverWait wait;

    public LoginObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
