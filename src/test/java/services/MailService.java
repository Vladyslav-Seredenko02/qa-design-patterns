package services;

public interface MailService {
    void createMessage();
    void fillEmailForm(String recipient, String subject, String body);
    void switchToDrafts();
    void switchToSents();
}