package utils;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import static utils.ConfigurationReader.getProperty;

public class EmailSender {

    private final String FROM_EMAIL;
    private final String PASSWORD;
    private final List<String> TO_EMAILS;
    private final String HOST;
    private final String TEAM_NAME;
    private final String SUBJECT;

    public EmailSender() {
        this.FROM_EMAIL = getProperty("fromEmail");
        this.PASSWORD = getProperty("password");
        this.HOST = getProperty("host");
        this.TEAM_NAME = getProperty("teamName");
        this.SUBJECT = getProperty("subject");
        String recipients = getProperty("recipients");
        this.TO_EMAILS = List.of(recipients.split(","));
    }
    public static void main(String[] args) {
        if (args.length > 0 && "performance".equals(args[0])) {
            sendEmail();
        }
    }

    public void sendEmailWithAttachment(String messageBody, File attachment) {
        try {
            Session session = createEmailSession();
            MimeMessage message = createMimeMessage(session, SUBJECT, messageBody, attachment);
            Transport.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    private Session createEmailSession() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        return Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
            }
        });
    }

    private MimeMessage createMimeMessage(Session session, String subject, String messageBody, File attachment) {
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(FROM_EMAIL, TEAM_NAME));
            for (String toEmail : TO_EMAILS) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            }
            Multipart multipart = new MimeMultipart();
            message.setSubject(subject);
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(messageBody, "text/html; charset=utf-8");
            multipart.addBodyPart(messageBodyPart);

            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachment);
            attachmentBodyPart.setDataHandler(new DataHandler(source));
            attachmentBodyPart.setFileName("Halk Katılım-Test-Raporu");
            multipart.addBodyPart(attachmentBodyPart);

            message.setContent(multipart);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException("Failed to create email message", e);
        }
        return message;
    }

    public static void sendEmail() {
        EmailSender emailSender = new EmailSender();
        String testType = System.getProperty("testType");
        try {
            File attachment = new File(Objects.requireNonNull(getReportPath(testType)));
            String message = "Testler koşulmuştur. Rapor ektedir.";
            emailSender.sendEmailWithAttachment(message, attachment);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    private static String getReportPath(String testType) {
        String currentDir = System.getProperty("user.dir");
        if ("performans".equals(testType)) {
            File gatlingFolder = new File(currentDir + File.separator + "target" + File.separator + "gatling");
            File[] subDirs = gatlingFolder.listFiles(File::isDirectory);
            return Objects.requireNonNull(subDirs)[0].getAbsolutePath() + File.separator + "index.html";
        }
        return currentDir + File.separator + "target" + File.separator + "karate-reports" + File.separator + "karate-summary.html";
    }
}
