package drivers;

import drivers.browser.BrowserDriver;
import drivers.browser.ChromeBrowserDriver;
import drivers.browser.EdgeBrowserDriver;
import drivers.browser.FirefoxBrowserDriver;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static WebDriver driver;

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void initializeDriver(String browser) {
        if (driver == null) {
            BrowserDriver browserDriver = switch (browser.toLowerCase()) {
                case "chrome" -> new ChromeBrowserDriver();
                case "edge" -> new EdgeBrowserDriver();
                case "firefox" -> new FirefoxBrowserDriver();
                default -> throw new IllegalArgumentException("This browser don`t supported: " + browser);
            };
            driver = browserDriver.createDriver();
            driver.manage().window().maximize();
        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}