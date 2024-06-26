package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.PermintaanPeminjamanPage;
import pages.DetailPermintaanPeminjamanPage;

public class KonfirmasiStepDef {
    WebDriver driver;
    PermintaanPeminjamanPage permintaanPeminjamanPage;
    DetailPermintaanPeminjamanPage detailPermintaanPeminjamanPage;
    LoginPage loginPage;
    ExtentReports extent;
    ExtentTest test;

    public KonfirmasiStepDef() {
        // Mendapatkan ExtentReports, ExtentTest, dan WebDriver dari Hooks
        this.extent = Hooks.getExtent();
        this.test = Hooks.getTest();
        this.driver = Hooks.getDriver();
        // Inisialisasi halaman permintaan peminjaman dan halaman detail permintaan peminjaman
        this.permintaanPeminjamanPage = new PermintaanPeminjamanPage(driver);
        this.detailPermintaanPeminjamanPage = new DetailPermintaanPeminjamanPage(driver);
        this.loginPage = new LoginPage(driver);
    }

    @And("user submits valid laboran credentials")
    public void user_submits_valid_laboran_credentials() throws InterruptedException {
        // Melakukan input email
        loginPage.clickEmail();
        loginPage.enterEmail("laboran@mail.com");

        // Melakukan input password
        loginPage.clickPassword();
        loginPage.enterPassword("password");

        // Klik tombol masuk
        loginPage.clickSubmitBtn();

        test.log(Status.INFO, "VALID CREDENTIALS: email: laboran@mail.com, password: password");
        Hooks.currentStep = "User submits valid laboran credentials";
    }

    @Given("user is on the Permintaan Peminjaman page")
    public void user_on_permintaan_peminjaman_page() throws InterruptedException {
        // Mennunggu halaman selesai dimuat
        Thread.sleep(3000);
        String actualUrl = driver.getCurrentUrl();
        // Verifikasi URL
        Assertions.assertEquals(permintaanPeminjamanPage.getPermintaanPeminjamanUrl(), actualUrl);

        Hooks.currentStep = "User is on the Permintaan Peminjaman page";
    }

    @When("user searches for a {string}")
    public void search_tool_loan_request(String keyword) throws InterruptedException {
        // Mencari berdasarkan keyword
        permintaanPeminjamanPage.enterSearchKeyword(keyword);

        Hooks.currentStep = "User searches for a "+ keyword;
    }

    @Then("tool loan requests that match the {string} will appear")
    public void search_result(String keyword) throws InterruptedException {
        // Menunggu proses pencarian
        Thread.sleep(3000);
        // Mengecek keyword yang dimasukkan
        if (keyword.equals("1")) {
            // Verifikasi apakah data dengan id=1 muncul pada bagian paling atas
            permintaanPeminjamanPage.getRequestId_1();
        } else {
            // Verifikasi apakah data dengan nama=keyword muncul pada bagian paling atas
            permintaanPeminjamanPage.getFirstNameOnList(keyword);
        }

        Hooks.currentStep = "Tool loan requests that match the "+ keyword +" will appear";
    }

    @Then("no data displayed that matches the {string}")
    public void no_search_result(String keyword) throws InterruptedException {
        // Menunggu proses pencarian
        Thread.sleep(3000);
        // Verifikasi hasil pencarian kosong
        permintaanPeminjamanPage.getTextNoDataAvailable();

        Hooks.currentStep = "No data displayed that matches the "+ keyword;
    }

    @And("user views loan requests that are still on pending status")
    public void filter_by_pending() throws InterruptedException {
        // Membuka dropdown filter status
        permintaanPeminjamanPage.clickStatusDropdown();
        // Memilih status pending
        permintaanPeminjamanPage.filterPendingStatus();
        // Menunggu filter berhasil diterapkan
        Thread.sleep(3000);
        // Verifikasi status lain tidak muncul
        permintaanPeminjamanPage.verifyStatusRevisedNotPresent();
        permintaanPeminjamanPage.verifyStatusRejectedNotPresent();
        permintaanPeminjamanPage.verifyStatusApprovedNotPresent();

        Hooks.currentStep = "User views loan requests that are still on pending status";
    }

    @And("user approves the tool loan request")
    public void user_approves_tool_loan_request() throws InterruptedException {
        // Membuka salah satu permintaan peminjaman dengan status pending
        permintaanPeminjamanPage.clickViewRequestBtn();
        // Verifikasi tombol ajukan revisi telah muncul
        detailPermintaanPeminjamanPage.getReviseBtn();
        // Klik tombol setujui untuk menyetujui permintaan peminjaman
        detailPermintaanPeminjamanPage.clickApproveBtn();

        Hooks.currentStep = "User approves the tool loan request";
    }

    @Then("the approved message will appear")
    public void approved_message_appear() throws InterruptedException {
        // Menunggu proses
        Thread.sleep(3000);
        // Verifikas pesan disetujui telah muncul
        detailPermintaanPeminjamanPage.getApprovedAlert();

        Hooks.currentStep = "The approved message will appear";
    }

    @When("user rejects the tool loan request")
    public void user_rejects_tool_loan_request() throws InterruptedException {
        // Membuka salah satu permintaan peminjaman dengan status pending
        permintaanPeminjamanPage.clickViewRequestBtn();
        // Verifikasi tombol ajukan revisi telah muncul
        detailPermintaanPeminjamanPage.getReviseBtn();
        // Klik tombol setujui untuk menyetujui permintaan peminjaman
        detailPermintaanPeminjamanPage.clickRejectBtn();

        Hooks.currentStep = "User rejects the tool loan request";
    }

    @Then("the rejected message will appear")
    public void rejected_message_appear() throws InterruptedException {
        // Menunggu proses
        Thread.sleep(3000);
        // Verifikas pesan disetujui telah muncul
        detailPermintaanPeminjamanPage.getRejectedAlert();

        Hooks.currentStep = "The rejected message will appear";
    }
}
