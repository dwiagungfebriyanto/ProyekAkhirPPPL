package pages;

import org.openqa.selenium.*;
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

    public boolean verifyElementNotPresent(By by) {
        try {
            driver.findElement(by);
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
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

    public void backspaceText(By by) throws InterruptedException {
        waitForElementVisible(by).sendKeys(Keys.BACK_SPACE);
    }

    public void scrollToBottom() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
