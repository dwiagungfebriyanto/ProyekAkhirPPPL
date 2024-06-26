package pages;

import object.DaftarAlatObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DaftarAlatPage extends BasePage {
    DaftarAlatObject daftarAlatObject;
    String daftarAlatUrl = "http://localhost:5173/app/daftar-alat";

    public DaftarAlatPage(WebDriver driver) {
        super(driver);
        daftarAlatObject = new DaftarAlatObject(driver);
    }

    public void clickAddItemToCartBtn() throws InterruptedException {
        click(daftarAlatObject.getAddToCartBtn());
    }

    public void clickCartBtn() throws InterruptedException {
        click(daftarAlatObject.getCartBtn());
    }

    public void getDisabledAddItemToCartBtn() throws InterruptedException {
        verifyElementVisible(daftarAlatObject.getAddedToCartBtn());
    }

    public String getFirstItemName() throws InterruptedException {
        WebElement itemName = driver.findElement(daftarAlatObject.getFirstItemName());
        return itemName.getText();
    }

    public void getNavLink() throws InterruptedException {
        verifyElementVisible(daftarAlatObject.getNavLink());
    }

    public String getDaftarAlatUrl() {
        return daftarAlatUrl;
    }
}
