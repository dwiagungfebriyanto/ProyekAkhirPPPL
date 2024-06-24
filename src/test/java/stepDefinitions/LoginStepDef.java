package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DaftarAlatPage;
import pages.LoginPage;

public class LoginStepDef {
    WebDriver driver;
    LoginPage loginPage;
    DaftarAlatPage daftarAlatPage;
    String loginUrl = "http://localhost:5173/login";
    String daftarAlatUrl = "http://localhost:5173/app/daftar-alat";

    @Before
    public void setUp() {
        // Inisialisasi WebDriver sebelum setiap scenario dijalankan
        this.driver = new ChromeDriver();
        // Inisialisasi halaman login dan halaman daftar alat
        this.loginPage = new LoginPage(driver);
        this.daftarAlatPage = new DaftarAlatPage(driver);
    }

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        // Membuka URL halaman login
        driver.get(loginUrl);
        driver.manage().window().maximize();
    }

    @When("user submits valid credentials")
    public void user_submits_valid_credentials() throws InterruptedException {
        // Melakukan input email
        loginPage.clickEmail();
        loginPage.clearEmail();
        loginPage.enterEmail("student@mail.com");

        // Melakukan input password
        loginPage.clickPassword();
        loginPage.clearPassword();
        loginPage.enterPassword("password");

        // Klik tombol submit
        loginPage.clickSubmitBtn();
    }

    @Then("user should be redirected to the Daftar Alat page")
    public void user_on_daftar_alat() throws InterruptedException {
        // Menunggu elemen halaman daftar alat tampil
        daftarAlatPage.getNavLink();
        // Mendapatkan URL saat ini dan memverifikasinya
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(daftarAlatUrl, actualUrl);
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

        // Klik tombol submit
        loginPage.clickSubmitBtn();
    }

    @Then("user still on the login page")
    public void user_on_login_page() throws InterruptedException {
        // Menunggu selama 3 detik sebelum melakukan assertions
        Thread.sleep(3000);

        // Mendapatkan URL saat ini dan memverifikasinya
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(loginUrl, actualUrl);
    }

    @After
    public void tearDown() {
        // Menutup browser setelah setiap scenario dijalankan
        driver.quit();
    }
}
