package pages;

import object.RegisterObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {
    RegisterObject registerObject;
    String registerUrl = "http://localhost:5173/register";

    public RegisterPage(WebDriver driver) {
        super(driver);
        registerObject = new RegisterObject(driver);
    }

    // ACCOUNT DETAILS
    public void enterEmail(String email) throws InterruptedException {
        inputText(registerObject.getInputEmail(), email);
    }

    public void enterPhone(String phone) throws InterruptedException {
        inputText(registerObject.getInputPhone(), phone);
    }

    public void enterPassword(String password) throws InterruptedException {
        inputText(registerObject.getInputPassword(), password);
    }

    public void enterConfirmPassword(String confirmPassword) throws InterruptedException {
        inputText(registerObject.getInputConfirmPassword(), confirmPassword);
    }

    public void clickEmail() throws InterruptedException {
        click(registerObject.getEmailOuter());
    }

    public void clickPhone() throws InterruptedException {
        click(registerObject.getPhoneOuter());
    }

    public void clickPassword() throws InterruptedException {
        click(registerObject.getPasswordOuter());
    }

    public void clickConfirmPassword() throws InterruptedException {
        click(registerObject.getConfirmPasswordOuter());
    }

    public void clearEmail() throws InterruptedException {
        clearText(registerObject.getInputEmail());
    }

    public void clearPhone() throws InterruptedException {
        clearText(registerObject.getInputPhone());
    }

    public void clearPassword() throws InterruptedException {
        clearText(registerObject.getInputPassword());
    }

    public void clearConfirmPassword() throws InterruptedException {
        clearText(registerObject.getInputConfirmPassword());
    }

    public void clickNextBtn() throws InterruptedException {
        click(registerObject.getNextBtn());
    }

    public void getTextInformasiAkun() throws InterruptedException {
        verifyElementVisible(registerObject.getTextInformasiAkun());
    }

    // PERSONAL INFORMATION
    public void enterName(String name) throws InterruptedException {
        inputText(registerObject.getInputName(), name);
    }

    public void enterNisn(String nisn) throws InterruptedException {
        inputText(registerObject.getInputNisn(), nisn);
    }

    public void enterClass(String className) throws InterruptedException {
        if (!className.isEmpty()) {
            click(By.xpath("//div[contains(@class, 'v-list-item-title') and contains(text(), '" + className + "')]"));
        }
    }

    public void enterDateOfBirth(String dateOfBirth) throws InterruptedException {
        if (!dateOfBirth.isEmpty()) {
            String[] dateParts = dateOfBirth.split("/");
            String day = dateParts[0];
            String month = dateParts[1];
            String year = dateParts[2];

            Select classDropdown = new Select(registerObject.getMonthDropdown());
            classDropdown.selectByVisibleText(month);

            clearText(registerObject.getInputYear());
            inputText(registerObject.getInputYear(), year);

            String formattedDate = month + " " + day + ", " + year;
            click(By.xpath("//span[@aria-label='"+ formattedDate  +"']"));
        }
    }

    public void enterEntryYear(String entryYear) throws InterruptedException {
        inputText(registerObject.getInputEntryYear(), entryYear);
    }

    public void clickName() throws InterruptedException {
        click(registerObject.getNameOuter());
    }

    public void clickNisn() throws InterruptedException {
        click(registerObject.getNisnOuter());
    }

    public void clickClass() throws InterruptedException {
        click(registerObject.getDropdownClass());
    }

    public void clickDateOfBirth() throws InterruptedException {
        click(registerObject.getInputDateOfBirth());
    }

    public void clickEntryYear() throws InterruptedException {
        click(registerObject.getEntryYearOuter());
    }

    public void clearName() throws InterruptedException {
        clearText(registerObject.getInputName());
    }

    public void clearNisn() throws InterruptedException {
        clearText(registerObject.getInputNisn());
    }

    public void clearEntryYear() throws InterruptedException {
        clearText(registerObject.getInputEntryYear());
    }

    public void clickPrevBtn() throws InterruptedException {
        click(registerObject.getPrevBtn());
    }

    public void clickSubmitBtn() throws InterruptedException {
        click(registerObject.getSubmitBtn());
    }

    public void getTextInformasiPersonal() throws InterruptedException {
        verifyElementVisible(registerObject.getTextInformasiPersonal());
    }

    public void getTextSuccessRegistrationMessage() throws InterruptedException {
        verifyElementVisible(registerObject.getTextSuccessRegistrationMessage());
    }

    // MENDAPATKAN URL REGISTER
    public String getRegisterUrl() {
        return registerUrl;
    }
}
