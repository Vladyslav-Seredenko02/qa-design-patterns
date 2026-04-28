package tests;

import decorators.LoggingMailService;
import drivers.DriverFactory;
import pages.DraftPage;
import pages.InboxPage;
import pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import services.MailService;

public class BaseTest {
    private static final Logger log = LogManager.getLogger(BaseTest.class);

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected InboxPage inboxPage;
    protected DraftPage draftPage;
    protected MailService mailService;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        log.info("=== Starting tests on browser: {} ===", browser);
        DriverFactory.initializeDriver(browser);
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        inboxPage = new InboxPage(driver);
        draftPage = new DraftPage(driver);
        mailService = new LoggingMailService(inboxPage);

        loginPage.openPage();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginBtn();
        inboxPage.waitTillPageLoaded(inboxPage.getInboxPageUrl());
    }

    @AfterMethod
    public void closeBrowser() {
        log.info("=== Closing browser ===");
        DriverFactory.tearDown();
    }
}