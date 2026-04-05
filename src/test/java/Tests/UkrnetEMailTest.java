package Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UkrnetEMailTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(UkrnetEMailTest.class);

    @Test(priority = 1)
    public void loginTest() {
        log.info("=== Test started: loginTest ===");
        loginPage.openPage();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginBtn();
        Assert.assertTrue(inboxPage.IsOnInboxPage(), "Login wasn`t successful");
        log.info("=== loginTest passed successfully ===");
    }

    @Test(priority = 2)
    public void saveDraftTest() {
        log.info("=== Test started: saveDraftTest ===");
        inboxPage.createMessage();
        inboxPage.fillEmailForm();
        inboxPage.switchToDrafts();
        Assert.assertTrue(draftPage.mailIsDisplayed(), "Mail isn`t displayed on the draft page");
        draftPage.openTheMail();
        Assert.assertEquals(draftPage.getAddresseeText(), TestData.RECIPIENT
                , "Addressee doesn`t match the expected recipient");

        Assert.assertEquals(draftPage.getEmailTopicText(), TestData.SUBJECT
                , "Topic doesn`t match the expected subject");

        Assert.assertEquals(draftPage.getMailBodyInputText(), TestData.BODY
                , "MailBodyInput doesn`t match the expected body");
        log.info("=== saveDraftTest passed successfully ===");
    }

    @Test(priority = 3)
    public void sendMailTest() {
        log.info("=== Test started: sendMailTest ===");
        draftPage.sendTheMail();
        inboxPage.switchToDrafts();
        Assert.assertTrue(draftPage.isDraftPageClear(), "Draft page still contains the mail");
        inboxPage.switchToSents();
        Assert.assertTrue(draftPage.mailIsDisplayed(), "Mail isn`t displayed on the sent page");
        log.info("=== sendMailTest passed successfully ===");
    }
}