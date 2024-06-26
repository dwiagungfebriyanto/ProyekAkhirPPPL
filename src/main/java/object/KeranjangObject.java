package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeranjangObject {
    WebDriver driver;

    public KeranjangObject(WebDriver driver) {
        this.driver = driver;
    }

    public By getTextTotalOneItem() {
        return By.xpath("//*[contains(text(), ' Keranjang Alat (1 Item) ')]");
    }

    public By getTextTotalZeroItem() {
        return By.xpath("//*[contains(text(), ' Keranjang Alat (0 Item) ')]");
    }

    public By getItemName() {
        return By.xpath("//h6[contains(text(), 'Multimeter')]");
    }

    public By getNumberOfTools() {
        return By.xpath("//input[@label='Jumlah']");
    }

    public By getDeleteBtn() {
        return By.xpath("//button[normalize-space(@class)='v-btn v-btn--icon v-theme--light text-disabled v-btn--density-default v-btn--size-default v-btn--variant-text checkout-item-remove-btn']");
    }

    public By getBackBtn() {
        return By.xpath("//a[contains(text(), 'Kembali')]");
    }

    public By getBorrowingDate(Boolean isCartNotEmpty) {
        if (isCartNotEmpty) {
            return By.xpath("(//div[@class='v-field__field'])[2]");
        }
        return By.xpath("(//div[@class='v-field__field'])[1]");
    }

    public By getReturnDate(Boolean isCartNotEmpty) {
        if (isCartNotEmpty) {
            return By.xpath("(//div[@class='v-field__field'])[3]");
        }
        return By.xpath("(//div[@class='v-field__field'])[2]");
    }

    public WebElement getBorrowingMonthDropdown() {
        return driver.findElement(By.xpath("(//select[contains(@class, 'flatpickr-monthDropdown-months')])[1]"));
    }

    public WebElement getReturnMonthDropdown() {
        return driver.findElement(By.xpath("(//select[contains(@class, 'flatpickr-monthDropdown-months')])[2]"));
    }

    public By getBorrowingInputYear() {
        return By.xpath("(//input[contains(@class, 'numInput') and contains(@class, 'cur-year')])[1]");
    }

    public By getReturnInputYear() {
        return By.xpath("(//input[contains(@class, 'numInput') and contains(@class, 'cur-year')])[2]");
    }

    public By getSubject(Boolean isCartNotEmpty) {
        if (isCartNotEmpty) {
            return By.xpath("(//div[@class='v-field__field'])[4]");
        }
        return By.xpath("(//div[@class='v-field__field'])[3]");
    }

    public By getNotes() {
        return By.id("keterangan");
    }

    public By getNotesOuter(Boolean isCartNotEmpty) {
        if (isCartNotEmpty) {
            return By.xpath("(//div[@class='v-field__field'])[5]");
        }
        return By.xpath("(//div[@class='v-field__field'])[4]");
    }

    public By getSubmitBtn() {
        return By.id("btn-submit");
    }

    public By getSuccessAlert() {
        return By.id("alert-success");
    }
}
