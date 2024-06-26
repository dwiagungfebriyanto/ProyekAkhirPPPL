package pages;

import object.KeranjangObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class KeranjangPage extends BasePage {
    KeranjangObject keranjangObject;
    String keranjangUrl = "http://localhost:5173/app/keranjang";

    public KeranjangPage(WebDriver driver) {
        super(driver);
        this.keranjangObject = new KeranjangObject(driver);
    }

    public void getTextTotalOneItem() throws InterruptedException {
        verifyElementVisible(keranjangObject.getTextTotalOneItem());
    }

    public void getTextTotalZeroItem() throws InterruptedException {
        verifyElementVisible(keranjangObject.getTextTotalZeroItem());
    }

    public Boolean isTextTotalZeroInvisible() {
        return verifyElementNotPresent(keranjangObject.getTextTotalZeroItem());
    }

    public String getItemName() {
        WebElement itemName = driver.findElement(keranjangObject.getItemName());
        return itemName.getText();
    }

    public void clearNumberOfTools() throws InterruptedException {
        backspaceText(keranjangObject.getNumberOfTools());
    }

    public void clickNumberOfTools() throws InterruptedException {
        click(keranjangObject.getNumberOfTools());
    }

    public void enterNumberOfTools(String numberOfTools) throws InterruptedException {
        inputText(keranjangObject.getNumberOfTools(), numberOfTools);
    }

    public void clickDeleteBtn() throws InterruptedException {
        click(keranjangObject.getDeleteBtn());
    }

    public void clickBorrowingDate(Boolean isCartNotEmpty) throws InterruptedException {
        click(keranjangObject.getBorrowingDate(isCartNotEmpty));
    }

    public void clickReturnDate(Boolean isCartNotEmpty) throws InterruptedException {
        click(keranjangObject.getReturnDate(isCartNotEmpty));
    }

    public void clickSubject(Boolean isCartNotEmpty) throws InterruptedException {
        click(keranjangObject.getSubject(isCartNotEmpty));
    }

    public void clickNotes(Boolean isCartNotEmpty) throws InterruptedException {
        click(keranjangObject.getNotesOuter(isCartNotEmpty));
    }

    public void enterBorrowingDate(String date) throws InterruptedException {
        if (!date.isEmpty()) {
            String[] dateParts = date.split("/");
            String day = dateParts[0];
            String month = dateParts[1];
            String year = dateParts[2];

            Select classDropdown = new Select(keranjangObject.getBorrowingMonthDropdown());
            classDropdown.selectByVisibleText(month);

            clearText(keranjangObject.getBorrowingInputYear());
            inputText(keranjangObject.getBorrowingInputYear(), year);

            String formattedDate = month + " " + day + ", " + year;
            click(By.xpath("(//span[@aria-label='"+ formattedDate  +"'])[1]"));
        }
    }

    public void enterReturnDate(String date) throws InterruptedException {
        if (!date.isEmpty()) {
            String[] dateParts = date.split("/");
            String day = dateParts[0];
            String month = dateParts[1];
            String year = dateParts[2];

            Select classDropdown = new Select(keranjangObject.getReturnMonthDropdown());
            classDropdown.selectByVisibleText(month);

            clearText(keranjangObject.getReturnInputYear());
            inputText(keranjangObject.getReturnInputYear(), year);

            String formattedDate = month + " " + day + ", " + year;
            click(By.xpath("(//span[@aria-label='"+ formattedDate  +"'])[2]"));
        }
    }

    public void enterSubject(String subject) throws InterruptedException {
        if (!subject.isEmpty()) {
            click(By.xpath("//div[contains(@class, 'v-list-item-title') and contains(text(), '" + subject + "')]"));
        }
    }

    public void enterNotes(String notes) throws InterruptedException {
        inputText(keranjangObject.getNotes(), notes);
    }

    public void clickSubmitBtn() throws InterruptedException {
        click(keranjangObject.getSubmitBtn());
    }

    public void clickBackBtn() throws InterruptedException {
        click(keranjangObject.getBackBtn());
    }

    public void getSuccessAlert() throws InterruptedException {
        verifyElementVisible(keranjangObject.getSuccessAlert());
    }

    public void noSuccessAlert() {
        Assertions.assertTrue(verifyElementNotPresent(keranjangObject.getSuccessAlert()));
    }

    public String getKeranjangUrl() {
        return keranjangUrl;
    }
}
