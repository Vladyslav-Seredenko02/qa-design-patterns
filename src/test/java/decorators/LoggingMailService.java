package decorators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.MailService;

public class LoggingMailService implements MailService {
    private static final Logger log = LogManager.getLogger(LoggingMailService.class);
    private final MailService mailService;

    public LoggingMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void createMessage() {
        log.info("Creating new mail");
        mailService.createMessage();
    }

    @Override
    public void fillEmailForm(String recipient, String subject, String body) {
        log.info("Filling mail form — to: {}, subject: {}", recipient, subject);
        mailService.fillEmailForm(recipient, subject, body);
    }

    @Override
    public void switchToDrafts() {
        log.info("Switching to Drafts");
        mailService.switchToDrafts();
    }

    @Override
    public void switchToSents() {
        log.info("Switching to Sent");
        mailService.switchToSents();
    }
}
