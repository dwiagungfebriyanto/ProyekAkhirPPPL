package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DaftarAlatObject {
    WebDriver driver;

    public DaftarAlatObject(WebDriver driver) {
        this.driver = driver;
    }

    public By getNavLink() {
        return By.className("nav-link");
    }
}
