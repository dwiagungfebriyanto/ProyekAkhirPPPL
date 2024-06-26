package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PermintaanPeminjamanObject {
    WebDriver driver;

    public PermintaanPeminjamanObject(WebDriver driver) {
        this.driver = driver;
    }

    public By getSearchInput() {
        return By.id("search");
    }

    public By getStatusDropdown() {
        return By.xpath("//div[@aria-haspopup='listbox']");
    }

    public By getId_1() {
        return By.id("id-1");
    }

    public By getViewRequestBtn() {
        return By.xpath("//a[normalize-space(@class)='v-btn v-btn--icon v-theme--light text-default v-btn--density-default v-btn--size-small v-btn--variant-text']");
    }

    public By getName(String name) {
        return By.xpath("//a[normalize-space(@class)='text-link text-base font-weight-medium mb-0' and contains(text(), '"+name+"')]");
    }

    public By getTextNoDataAvailable() {
        return By.xpath("//td[contains(text(), 'No data available')]");
    }

    public By getStatusPending() {
        return By.xpath("//div[@class='v-chip__content' and contains(text(), 'pending')]");
    }

    public By getStatusApproved() {
        return By.xpath("//div[@class='v-chip__content' and contains(text(), 'approved')]");
    }

    public By getStatusRejected() {
        return By.xpath("//div[@class='v-chip__content' and contains(text(), 'rejected')]");
    }

    public By getStatusRevised() {
        return By.xpath("//div[@class='v-chip__content' and contains(text(), 'revised')]");
    }
}
