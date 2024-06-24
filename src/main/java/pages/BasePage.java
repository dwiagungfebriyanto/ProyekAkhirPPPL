package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForElementVisible(By by) throws InterruptedException {
        Thread.sleep(1000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void verifyElementVisible(By by) throws InterruptedException {
        waitForElementVisible(by).isDisplayed();
    }

    public void click(By by) throws InterruptedException {
        waitForElementVisible(by).click();
    }

    public void inputText(By by, String text) throws InterruptedException {
        waitForElementVisible(by).sendKeys(text);
    }

    public void clearText(By by) throws InterruptedException {
        waitForElementVisible(by).clear();
    }
}
