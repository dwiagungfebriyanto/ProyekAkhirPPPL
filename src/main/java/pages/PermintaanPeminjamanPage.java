package pages;

import object.PermintaanPeminjamanObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PermintaanPeminjamanPage extends BasePage {
    PermintaanPeminjamanObject permintaanPeminjamanObject;
    String permintaanPeminjamanUrl = "http://localhost:5173/app/permintaan-peminjaman/list";

    public PermintaanPeminjamanPage(WebDriver driver) {
        super(driver);
        this.permintaanPeminjamanObject = new PermintaanPeminjamanObject(driver);
    }

    public void enterSearchKeyword(String keyword) throws InterruptedException {
        inputText(permintaanPeminjamanObject.getSearchInput(), keyword);
    }

    public void clickStatusDropdown() throws InterruptedException {
        click(permintaanPeminjamanObject.getStatusDropdown());
    }

    public void filterPendingStatus() throws InterruptedException {
        click(By.xpath("//div[contains(@class, 'v-list-item-title') and contains(text(), 'pending')]"));
    }

    public void clickViewRequestBtn() throws InterruptedException {
        click(permintaanPeminjamanObject.getViewRequestBtn());
    }

    public void getRequestId_1() throws InterruptedException {
        verifyElementVisible(permintaanPeminjamanObject.getId_1());
    }

    public void getFirstNameOnList(String name) throws InterruptedException {
        verifyElementVisible(permintaanPeminjamanObject.getName(name));
    }

    public void getTextNoDataAvailable() throws InterruptedException {
        verifyElementVisible(permintaanPeminjamanObject.getTextNoDataAvailable());
    }

    public void verifyStatusPendingNotPresent() {
        verifyElementNotPresent(permintaanPeminjamanObject.getStatusPending());
    }

    public void verifyStatusApprovedNotPresent() {
        verifyElementNotPresent(permintaanPeminjamanObject.getStatusApproved());
    }

    public void verifyStatusRejectedNotPresent() {
        verifyElementNotPresent(permintaanPeminjamanObject.getStatusRejected());
    }

    public void verifyStatusRevisedNotPresent() {
        verifyElementNotPresent(permintaanPeminjamanObject.getStatusRevised());
    }

    public String getPermintaanPeminjamanUrl() {
        return permintaanPeminjamanUrl;
    }
}
