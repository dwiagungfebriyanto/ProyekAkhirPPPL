package pages;

import object.DaftarAlatObject;
import org.openqa.selenium.WebDriver;

public class DaftarAlatPage extends BasePage {
    DaftarAlatObject daftarAlatObject;

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
}
