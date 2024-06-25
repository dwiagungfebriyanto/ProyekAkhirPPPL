package pages;

import object.DaftarAlatObject;
import org.openqa.selenium.WebDriver;

public class DaftarAlatPage extends BasePage {
    DaftarAlatObject daftarAlatObject;
    String daftarAlatUrl = "http://localhost:5173/app/daftar-alat";

    public DaftarAlatPage(WebDriver driver) {
        super(driver);
        daftarAlatObject = new DaftarAlatObject(driver);
    }

    public void getNavLink() throws InterruptedException {
        verifyElementVisible(daftarAlatObject.getNavLink());
    }

    public String  getActualUrl() {
        return driver.getCurrentUrl();
    }

    public String getDaftarAlatUrl() {
        return daftarAlatUrl;
    }
}
