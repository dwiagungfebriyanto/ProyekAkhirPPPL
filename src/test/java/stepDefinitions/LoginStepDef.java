package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.DaftarAlatPage;
import pages.LoginPage;

public class LoginStepDef {
    WebDriver driver;
    LoginPage loginPage;
    DaftarAlatPage daftarAlatPage;
    ExtentReports extent;
    ExtentTest test;

    public LoginStepDef() {
        // Mendapatkan ExtentReports, ExtentTest, dan WebDriver dari Hooks
        this.extent = Hooks.getExtent();
        this.test = Hooks.getTest();
        this.driver = Hooks.getDriver();
        // Inisialisasi halaman login dan halaman daftar alat
        this.loginPage = new LoginPage(driver);
        this.daftarAlatPage = new DaftarAlatPage(driver);
    }

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        // Membuka URL halaman login
        driver.get(loginPage.getLoginUrl());
        driver.manage().window().maximize();

        Hooks.currentStep = "User is on the login page";
    }

    @When("user submits valid credentials")
    public void user_submits_valid_credentials() throws InterruptedException {
        // Melakukan input email
        loginPage.clickEmail();
        loginPage.enterEmail("student@mail.com");

        // Melakukan input password
        loginPage.clickPassword();
        loginPage.enterPassword("password");

        // Klik tombol masuk
        loginPage.clickSubmitBtn();

        test.log(Status.INFO, "VALID CREDENTIALS: email: student@mail.com, password: password");
        Hooks.currentStep = "User submits valid credentials";
    }

    @Then("user should be redirected to the Daftar Alat page")
    public void user_on_daftar_alat() throws InterruptedException {
        // Menunggu elemen halaman daftar alat tampil
        daftarAlatPage.getNavLink();
        // Mendapatkan URL saat ini dan memverifikasinya
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(daftarAlatPage.getDaftarAlatUrl(), actualUrl);

        Hooks.currentStep = "User should be redirected to the Daftar Alat page";
    }

    @When("user submits {string} and {string}")
    public void user_submits_invalid_credentials(String email, String password) throws InterruptedException {
        // Melakukan input email dengan parameter yang diberikan
        loginPage.clickEmail();
        loginPage.clearEmail();
        loginPage.enterEmail(email);

        // Melakukan input password dengan parameter yang diberikan
        loginPage.clickPassword();
        loginPage.clearPassword();
        loginPage.enterPassword(password);

        // Klik tombol masuk
        loginPage.clickSubmitBtn();

        Hooks.currentStep = "user submits email: " + email + " and password: " + password;
    }

    @Then("user still on the login page")
    public void user_on_login_page() throws InterruptedException {
        // Menunggu selama 3 detik sebelum melakukan assertions
        Thread.sleep(3000);

        // Mendapatkan URL saat ini dan memverifikasinya
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(loginPage.getLoginUrl(), actualUrl);

        Hooks.currentStep = "User still on the login page";
    }
}
