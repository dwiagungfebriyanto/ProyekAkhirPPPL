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

    public By getFirstItemName() {
        return By.id("name-1");
    }

    public By getFirstItemWarehouse() {
        return By.id("material-1");
    }

    public By getFirstItemStock() {
        return By.id("stock-1");
    }

    public By getAddToCartBtn() {
        return By.id("btn-add-to-cart");
    }

    public By getAddedToCartBtn() {
        return By.xpath("//*[contains(text(), ' SUDAH ADA DI KERANJANG ')]");
    }

    public By getCartBtn() {
        return By.id("cart-btn");
    }
}
