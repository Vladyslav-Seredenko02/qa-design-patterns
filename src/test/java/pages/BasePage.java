package pages;

import decorators.LoggingWebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestConfig;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected final String URL = TestConfig.URL;
    protected final String USERNAME = TestConfig.USERNAME;
    protected final String PASSWORD = TestConfig.PASSWORD;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new LoggingWebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void enterText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void waitTillPageLoaded(String expectedUrl) {
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
}