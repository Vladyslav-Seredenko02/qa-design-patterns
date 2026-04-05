package Tests;

import Drivers.DriverFactory;
import Pages.DraftPage;
import Pages.InboxPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected InboxPage inboxPage;
    protected DraftPage draftPage;

    @BeforeClass
    public void setUp() {
        DriverFactory.initializeDriver();
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        inboxPage = new InboxPage(driver);
        draftPage = new DraftPage(driver);
    }

    @AfterClass
    public void closeBrowser() {
        DriverFactory.tearDown();
    }
}