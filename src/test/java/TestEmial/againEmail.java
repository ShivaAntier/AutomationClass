package TestEmial;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.testng.annotations.Test;

import java.util.Properties;

public class againEmail {
    @Test
    public void emailSend() {

        // Recipient's email ID needs to be mentioned.

        String message = "Hi There,\n This is mail to verify that it is working fine.\n Thanks & Regards\n Shiva Mahajan";
        String sub = "This is Mail from Shiva!";
        String to = "lakshay.kaushal@antiersolutions.com";
        String from = "shiva.mahajan@antiersolutions.com";

        //sendEmail(message, sub, to, from);

        // Assuming you are sending email through relay.jangosmtp.net

        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //return super.getPasswordAuthentication();
//                return new passwordauthentication("cryptout431@gmail.com", "slinrgxfzpjurbjy");
                return new PasswordAuthentication("shiva.mahajan@antiersolutions.com","kmyeblhrbutkrmzn");
            }
        });
        Message m = new MimeMessage(session);  // Create a default MimeMessage object.
        try {



            // Set From: header field of the header.
            m.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            m.setSubject(sub);

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Now set the actual message
//            messageBodyPart.setText("Hi There,\n This is mail to verify that it is working fine.\n Thanks & Regards\n Shiva Mahajan");
            messageBodyPart.setText(message);

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = "C:\\Users\\user\\IdeaProjects\\TestingAgain\\test-output\\emailable-report.html";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            BodyPart messageBodyPart1 = new MimeBodyPart();
            String filename1 = "C:\\Users\\user\\IdeaProjects\\TestingAgain\\src\\test\\java\\folder\\a.jpg";
            source = new FileDataSource(filename1);
            messageBodyPart1.setDataHandler(new DataHandler(source));
            messageBodyPart1.setFileName(filename);
            multipart.addBodyPart(messageBodyPart1);

            // Send the complete message parts
            m.setContent(multipart);

            // Send message
            Transport.send(m);

            System.out.println("Sent message successfully....");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
