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
import pages.DaftarAlatPage;
import pages.KeranjangPage;

public class KeranjangStepDef {
    WebDriver driver;
    KeranjangPage keranjangPage;
    DaftarAlatPage daftarAlatPage;
    ExtentReports extent;
    ExtentTest test;
    String firstItemName = "";

    public KeranjangStepDef() {
        // Mendapatkan ExtentReports, ExtentTest, dan WebDriver dari Hooks
        this.extent = Hooks.getExtent();
        this.test = Hooks.getTest();
        this.driver = Hooks.getDriver();
        // Inisialisasi halaman keranjang dan halaman daftar alat
        this.keranjangPage = new KeranjangPage(driver);
        this.daftarAlatPage = new DaftarAlatPage(driver);
    }

    @Given("user is on the Daftar Alat Page")
    public void user_on_daftar_alat_page() throws InterruptedException {
        // Mennunggu halaman selesai dimuat
        Thread.sleep(3000);
        String actualUrl = driver.getCurrentUrl();
        // Verifikasi URL
        Assertions.assertEquals(daftarAlatPage.getDaftarAlatUrl(), actualUrl);
        daftarAlatPage.getNavLink();

        Hooks.currentStep = "User is on the Daftar Alat Page";
    }

    @When("user adds one item to the cart")
    public void user_adds_item_to_cart() throws InterruptedException {
        // Mendapatkan nama item pertama
        firstItemName = daftarAlatPage.getFirstItemName();
        // Menambah Item ke keranjang
        daftarAlatPage.clickAddItemToCartBtn();

        Hooks.currentStep = "User adds one item to the cart: " + firstItemName;
    }

    @Then("the item is on the cart")
    public void item_is_on_the_cart() throws InterruptedException {
        // Membuka halaman keranjang
        daftarAlatPage.clickCartBtn();
        // Mendapatkan teks keterangan total item
        keranjangPage.getTextTotalOneItem();
        // Verifikasi item
        String cartItemName = keranjangPage.getItemName();
        Assertions.assertEquals(firstItemName, cartItemName);

        Hooks.currentStep = "The item is on the cart: " + cartItemName;
    }

    @When("user has one item in the cart")
    public void user_has_one_item_in_cart() throws InterruptedException {
        // Membuka halaman keranjang
        daftarAlatPage.clickCartBtn();
        // Verifikasi teks keterangan total item
        keranjangPage.getTextTotalOneItem();
        // Verifikasi item
        String cartItemName = keranjangPage.getItemName();
        Assertions.assertEquals("Multimeter", cartItemName);
        // Kembali ke halaman daftar alat
        keranjangPage.clickBackBtn();

        Hooks.currentStep = "User has one item in the cart: " + cartItemName;
    }

    @And("user cannot add the same item to the cart")
    public void user_adds_item_that_already_in_cart() throws InterruptedException {
        // Menambahkan alat ke keranjang
        daftarAlatPage.getDisabledAddItemToCartBtn();

        Hooks.currentStep = "User cannot add the same item to the cart";
    }

    @Given("user is on the Cart page")
    public void user_on_cart_page() throws InterruptedException {
        // Membuka halaman keranjang
        daftarAlatPage.clickCartBtn();
        // Menunggu halaman selesai dimuat
        Thread.sleep(3000);
        // Verifikasi URL
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(keranjangPage.getKeranjangUrl(), actualUrl);

        Hooks.currentStep = "User is on the Cart page";
    }

    @And("user deletes an item")
    public void user_deletes_an_item() throws InterruptedException {
        // Membuka halaman keranjang
        daftarAlatPage.clickCartBtn();
        // Verifikasi URL
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(keranjangPage.getKeranjangUrl(), actualUrl);
        // Menghapus item di keranjang
        keranjangPage.clickDeleteBtn();

        Hooks.currentStep = "User deletes an item";
    }

    @Then("the item should not be in the cart")
    public void item_not_in_cart() throws InterruptedException {
        // Verifikasi teks keterangan total item
        keranjangPage.getTextTotalZeroItem();

        Hooks.currentStep = "The item should not be in the cart";
    }

    @And("user submits valid required data")
    public void user_submits_valid_data() throws InterruptedException {
        // Membuka halaman keranjang
        daftarAlatPage.clickCartBtn();
        // Menunggu halaman dimuat
        Thread.sleep(3000);
        // Verifikasi URL
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(keranjangPage.getKeranjangUrl(), actualUrl);

        // Memeriksa apakah keranjang tidak kosong
        Boolean isCartNotEmpty = keranjangPage.isTextTotalZeroInvisible();

        // Mengisi data
        keranjangPage.clickBorrowingDate(isCartNotEmpty);
        keranjangPage.enterBorrowingDate("1/July/2024");

        keranjangPage.clickReturnDate(isCartNotEmpty);
        keranjangPage.enterReturnDate("2/July/2024");

        keranjangPage.clickSubject(isCartNotEmpty);
        keranjangPage.enterSubject("Algoritma dan Struktur Data");

        keranjangPage.clickNotes(isCartNotEmpty);
        keranjangPage.enterNotes("Testing");

        // Mengajukan permintaan peminjaman
        keranjangPage.clickSubmitBtn();

        // Menunggu permintaan dikirim
        Thread.sleep(2000);
        keranjangPage.scrollToBottom();

        test.log(Status.INFO, "VALID DATA: borrowing date: 1/July/2024, return date: 2/July/2024, subject: Algoritma dan Struktur Data, and notes: Testing");
        Hooks.currentStep = "User submits valid required data";
    }

    @Then("a tool loan request should be sent")
    public void tool_loan_request_sent() throws InterruptedException {
        // Verifikasi success alert telah terlihat
        keranjangPage.getSuccessAlert();

        Hooks.currentStep = "A tool loan request should be sent";
    }

    @And("user submits: {string}, {string}, {string}, {string}, and {string}")
    public void user_submits_invalid_data(String numberOfTools, String borrowingDate, String returnDate, String subject, String notes) throws InterruptedException {
        // Membuka halaman keranjang
        daftarAlatPage.clickCartBtn();
        // Menunggu halaman dimuat
        Thread.sleep(3000);
        // Verifikasi URL
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(keranjangPage.getKeranjangUrl(), actualUrl);

        // Memeriksa apakah keranjang tidak kosong
        Boolean isCartNotEmpty = keranjangPage.isTextTotalZeroInvisible();

        // Mengisi data
        keranjangPage.clickNumberOfTools();
        keranjangPage.clearNumberOfTools();
        keranjangPage.enterNumberOfTools(numberOfTools);

        keranjangPage.clickBorrowingDate(isCartNotEmpty);
        keranjangPage.enterBorrowingDate(borrowingDate);

        keranjangPage.clickReturnDate(isCartNotEmpty);
        keranjangPage.enterReturnDate(returnDate);

        keranjangPage.clickSubject(isCartNotEmpty);
        keranjangPage.enterSubject(subject);

        keranjangPage.clickNotes(isCartNotEmpty);
        keranjangPage.enterNotes(notes);

        // Mengajukan permintaan peminjaman
        keranjangPage.clickSubmitBtn();

        // Menunggu permintaan dikirim
        Thread.sleep(2000);
        keranjangPage.scrollToBottom();

        test.log(Status.INFO, "INVALID DATA: number of tools:"+ numberOfTools +", borrowing date: "+ borrowingDate +", return date: "+ returnDate +", subject: "+ subject +", notes: "+ notes);
        Hooks.currentStep = "User submits valid required data";
    }

    @Then("a tool loan request should not be sent")
    public void tool_loan_request_not_sent() throws InterruptedException {
        // Menunggu apakah permintaan dikirim atau tidak
        Thread.sleep(3000);
        // Verifikasi permintaan tidak dikirim
        keranjangPage.noSuccessAlert();

        Hooks.currentStep = "A tool loan request should not be sent";
    }

    @When("user submits valid required data without subject")
    public void user_submits_without_subject() throws InterruptedException {
        // Membuka halaman keranjang
        daftarAlatPage.clickCartBtn();
        // Menunggu halaman dimuat
        Thread.sleep(3000);
        // Verifikasi URL
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(keranjangPage.getKeranjangUrl(), actualUrl);

        // Memeriksa apakah keranjang tidak kosong
        Boolean isCartNotEmpty = keranjangPage.isTextTotalZeroInvisible();

        // Mengisi data
        keranjangPage.clickBorrowingDate(isCartNotEmpty);
        keranjangPage.enterBorrowingDate("1/July/2024");

        keranjangPage.clickReturnDate(isCartNotEmpty);
        keranjangPage.enterReturnDate("2/July/2024");

        keranjangPage.clickNotes(isCartNotEmpty);
        keranjangPage.enterNotes("Testing");

        // Mengajukan permintaan peminjaman
        keranjangPage.clickSubmitBtn();

        // Menunggu permintaan dikirim
        Thread.sleep(2000);
        keranjangPage.scrollToBottom();

        test.log(Status.INFO, "VALID DATA: borrowing date: 1/July/2024, return date: 2/July/2024, and notes: Testing");
        Hooks.currentStep = "User submits valid required data without subject";
    }

    @And("the cart is empty")
    public void cart_is_empty() throws InterruptedException {
        // Verifikasi total item dii keranjang
        keranjangPage.getTextTotalZeroItem();
        // Kembali ke halaman daftar alat
        keranjangPage.clickBackBtn();

        Hooks.currentStep = "The cart is empty";
    }
}
