package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterObject {
    WebDriver driver;

    public RegisterObject(WebDriver driver) {
        this.driver = driver;
    }

    // ACCOUNT DETAILS
    public By getInputEmail() {
        return By.id("email");
    }

    public By getInputPhone() {
        return By.id("phone");
    }

    public By getInputConfirmPassword() {
        return By.id("confirm-password");
    }

    public By getInputPassword() {
        return By.id("password");
    }

    public By getEmailOuter() {
        return By.xpath("(//div[@class='v-field__field'])[1]");
    }

    public By getPhoneOuter() {
        return By.xpath("(//div[@class='v-field__field'])[2]");
    }

    public By getPasswordOuter() {
        return By.xpath("(//div[@class='v-field__field'])[3]");
    }

    public By getConfirmPasswordOuter() {
        return By.xpath("(//div[@class='v-field__field'])[4]");
    }

    public By getNextBtn() {
        return By.id("btn-next");
    }

    public By getTextInformasiAkun() {
        return By.xpath("//*[contains(text(), 'Informasi Akun')]");
    }

    // PERSONAL INFORMATION
    public By getInputName() {
        return By.id("name");
    }

    public By getInputNisn() {
        return By.id("nisn");
    }

    public By getDropdownClass() {
        return By.xpath("(//div[@class='v-field__field'])[7]");
    }

    public By getInputDateOfBirth() {
        return By.xpath("(//div[@class='v-field__field'])[8]");
    }

    public By getInputEntryYear() {
        return By.id("year-in");
    }

    public By getNameOuter() {
        return By.xpath("(//div[@class='v-field__field'])[5]");
    }

    public By getNisnOuter() {
        return By.xpath("(//div[@class='v-field__field'])[6]");
    }

    public By getEntryYearOuter() {
        return By.xpath("(//div[@class='v-field__field'])[9]");
    }

    public By getPrevBtn() {
        return By.id("btn-prev");
    }

    public WebElement getMonthDropdown() {
        return driver.findElement(By.className("flatpickr-monthDropdown-months"));
    }

    public By getInputYear() {
        return By.xpath("//input[contains(@class, 'numInput') and contains(@class, 'cur-year')]");
    }

    public By getTextInformasiPersonal() {
        return By.xpath("//*[contains(text(), 'Informasi Personal')]");
    }

    public By getSubmitBtn() {
        return By.id("btn-submit");
    }

    public By getTextSuccessRegistrationMessage() {
        return By.id("snackbar-success");
    }
}
