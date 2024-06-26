package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailPermintaanPeminjamanObject {
    WebDriver driver;

    public DetailPermintaanPeminjamanObject(WebDriver driver) {
        this.driver = driver;
    }

    public By getName(String name) {
        return By.xpath("//div[contains(text(), '"+ name +"')]");
    }

    public By getApproveBtn() {
        return By.id("btn-approve");
    }

    public By getRejectBtn() {
        return By.id("btn-reject");
    }

    public By getReviseBtn() {
        return By.id("btn-revise");
    }

    public By getPendingAlert() {
        return By.xpath("//div[contains(text(), 'DIAJUKAN')]");
    }

    public By getApprovedAlert() {
        return By.xpath("//div[contains(text(), 'DISETUJUI')]");
    }

    public By getRejectedAlert() {
        return By.xpath("//div[contains(text(), 'DITOLAK')]");
    }
}
