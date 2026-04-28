package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import services.MailService;


public class InboxPage extends BasePage implements MailService {
    private static final Logger log = LogManager.getLogger(InboxPage.class);

    public InboxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /*
    this variable is left in this format for possible future use
     */
    private final String pageURL = "https://mail.ukr.net/desktop/u0/msglist/inbox";


    @FindBy(xpath = "//button[@type='button' and contains(text(), 'Написати листа')]")
    private WebElement createMessageBtn;

    @FindBy(id = "compose-to")
    private WebElement addresseeField;

    @FindBy(id = "compose-subject")
    private WebElement topicField;

    @FindBy(css = "iframe[id$='_ifr']")
    private WebElement emailBodyInputField;

    @FindBy(xpath = "//span[contains(text(), 'Чернетки')]")
    private WebElement draftsTab;

    @FindBy(xpath = "//span[contains(text(), 'Надіслані')]")
    private WebElement sentsTab;


    public String getInboxPageUrl() {
        return pageURL;
    }


    public void createMessage() {
        log.info("User clicks 'Compose' button");
        createMessageBtn.click();
    }

    public void fillEmailForm(String recipient, String subject, String body) {
        log.info("User fills email form — to: {}, subject: {}", recipient, subject);
        enterText(addresseeField, recipient);
        addresseeField.sendKeys(Keys.ENTER);
        enterText(topicField, subject);

        wait.until(ExpectedConditions.visibilityOf(emailBodyInputField)).click();
        emailBodyInputField.sendKeys(body);
        log.info("User successfully filled the email form");
    }

    public void switchToDrafts() {
        log.info("User navigates to Drafts");
        draftsTab.click();
    }

    public void switchToSents() {
        log.info("User navigates to Sent");
        sentsTab.click();
    }
}