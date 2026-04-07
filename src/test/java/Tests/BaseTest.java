package Tests;

import Drivers.DriverFactory;
import Pages.BasePage;
import Pages.DraftPage;
import Pages.InboxPage;
import Pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    private static final Logger log = LogManager.getLogger(BaseTest.class);

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected InboxPage inboxPage;
    protected DraftPage draftPage;
    protected BasePage basePage;

    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        log.info("=== Starting tests on browser: {} ===", browser);
        DriverFactory.initializeDriver(browser);
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        inboxPage = new InboxPage(driver);
        draftPage = new DraftPage(driver);
    }

    @AfterClass
    public void closeBrowser() {
        log.info("=== Closing browser ===");
        DriverFactory.tearDown();
    }
}