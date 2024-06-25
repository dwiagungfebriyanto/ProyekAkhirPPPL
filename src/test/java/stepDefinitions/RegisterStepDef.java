package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegisterPage;

public class RegisterStepDef {
    WebDriver driver;
    RegisterPage registerPage;

    @Before
    public void setUp() {
        // Inisialisasi WebDriver sebelum setiap scenario dijalankan
        this.driver = new ChromeDriver();
        // Inisialisasi halaman register
        this.registerPage = new RegisterPage(driver);
    }

    @Given("user is on the register page")
    public void user_is_on_the_register_page() {
        // Membuka URL halaman register
        driver.get(registerPage.getRegisterUrl());
        driver.manage().window().maximize();
    }

    @When("user submits valid credentials on account details")
    public void user_submits_valid_credentials_on_account_details() throws InterruptedException {
        // Melakukan input email
        registerPage.clickEmail();
        registerPage.enterEmail("siswa@mail.com");

        // Melakukan input nomor telepon
        registerPage.clickPhone();
        registerPage.enterPhone("081234563456");

        // Melakukan input password
        registerPage.clickPassword();
        registerPage.enterPassword("password");

        // Melakukan input konfirmasi password
        registerPage.clickConfirmPassword();
        registerPage.enterConfirmPassword("password");

        // Klik tombol selanjutnya
        registerPage.clickNextBtn();
    }

    @And("user submits valid credentials on personal information")
    public void user_submits_valid_credentials_on_personal_informastion() throws InterruptedException {
        // Melakukan input nama
        registerPage.clickName();
        registerPage.enterName("student");

        // Melakukan input NISN
        registerPage.clickNisn();
        registerPage.enterNisn("12345");

        // Melakukan pemilihan kelas
        registerPage.clickClass();
        registerPage.enterClass("X RPL 1");

//        String dropdown = registerPage.dropdown();
//        System.out.println("Isi: " + dropdown);

        // Melakukan input tanggal lahir
        registerPage.clickDateOfBirth();
        registerPage.enterDateOfBirth("12/March/2004");

        // Melakukan input tahun masuk
        registerPage.clickEntryYear();
        registerPage.enterEntryYear("2022");

        // Klik tombol daftar
        registerPage.clickSubmitBtn();
    }

    @Then("user should see a confirmation message")
    public void successful_register() throws InterruptedException {
        Thread.sleep(1000);
        registerPage.getTextSuccessRegistrationMessage();
    }

    @Given("user submits {string}, {string}, {string}, and {string}")
    public void user_submits_invalid_credentials_on_account_details(String email, String phone, String password, String confirmPassword) throws InterruptedException {
        // Melakukan input email dengan parameter yang diberikan
        registerPage.clickEmail();
        registerPage.enterEmail(email);

        // Melakukan input nomor telepon dengan parameter yang diberikan
        registerPage.clickPhone();
        registerPage.enterPhone(phone);

        // Melakukan input password dengan parameter yang diberikan
        registerPage.clickPassword();
        registerPage.enterPassword(password);

        // Melakukan input konfirmasi password dengan parameter yang diberikan
        registerPage.clickConfirmPassword();
        registerPage.enterConfirmPassword(confirmPassword);

        // Klik tombol selanjutnya
        registerPage.clickNextBtn();
    }

    @Then("user cannot proceed to the personal information section")
    public void user_cannot_proceed_to_personal_information() throws InterruptedException {
        // Menunggu selama 3 detik sebelum melakukan verifikasi elemen
        Thread.sleep(3000);

        // Verifikasi teks Informasi Akun
        registerPage.getTextInformasiAkun();
    }

    @And("user submits {string}, {string}, {string}, {string}, and {string}")
    public void user_submits_invalid_credentials_on_personal_information(String name, String nisn, String className, String dateOfBirth, String entryYear) throws InterruptedException {
        // Melakukan input nama
        registerPage.clickName();
        registerPage.enterName(name);

        // Melakukan input NISN
        registerPage.clickNisn();
        registerPage.enterNisn(nisn);

        // Melakukan pemilihan kelas
        registerPage.clickClass();
        registerPage.enterClass(className);

        // Melakukan input tanggal lahir
        registerPage.clickDateOfBirth();
        registerPage.enterDateOfBirth(dateOfBirth);

        // Melakukan input tahun masuk
        registerPage.clickEntryYear();
        registerPage.enterEntryYear(entryYear);

        // Klik tombol daftar
        registerPage.clickSubmitBtn();
    }

    @Then("user cannot register an account")
    public void user_cannot_register() throws InterruptedException {
        Thread.sleep(3000);
        registerPage.getTextInformasiPersonal();
    }

    @After
    public void tearDown() {
        // Menutup browser setelah setiap scenario dijalankan
        driver.quit();
    }
}
