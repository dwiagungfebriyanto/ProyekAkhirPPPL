package pages;

import object.DetailPermintaanPeminjamanObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailPermintaanPeminjamanPage extends BasePage {
    DetailPermintaanPeminjamanObject detailPermintaanPeminjamanObject;

    public DetailPermintaanPeminjamanPage(WebDriver driver) {
        super(driver);
        this.detailPermintaanPeminjamanObject = new DetailPermintaanPeminjamanObject(driver);
    }

    public void getName(String name) throws InterruptedException {
        verifyElementVisible(detailPermintaanPeminjamanObject.getName(name));
    }

    public void clickApproveBtn() throws InterruptedException {
        click(detailPermintaanPeminjamanObject.getApproveBtn());
    }

    public void clickReviseBtn() throws InterruptedException {
        click(detailPermintaanPeminjamanObject.getReviseBtn());
    }

    public void clickRejectBtn() throws InterruptedException {
        click(detailPermintaanPeminjamanObject.getRejectBtn());
    }

    public void getReviseBtn() throws InterruptedException {
        verifyElementVisible(detailPermintaanPeminjamanObject.getReviseBtn());
    }

    public void getApprovedAlert() throws InterruptedException {
        verifyElementVisible(detailPermintaanPeminjamanObject.getApprovedAlert());
    }

    public void getPendingAlert() throws InterruptedException {
        verifyElementVisible(detailPermintaanPeminjamanObject.getPendingAlert());
    }

    public void getRejectedAlert() throws InterruptedException {
        verifyElementVisible(detailPermintaanPeminjamanObject.getRejectedAlert());
    }
}
