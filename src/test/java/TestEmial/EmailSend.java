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

public class EmailSend {
    @Test
    public void mailsend() {

        // Recipient's email ID needs to be mentioned.
        urls url = new urls();
        String message = "this is url 1 "+url.url1+"and this is url 2 "+url.url2;

        String sub = "Testing";
        String to = "shiva.mahajan@antiersolutions.com";
        String from = "cryptout431@gmail.com";
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
                return new PasswordAuthentication("cryptout431@gmail.com", "slinrgxfzpjurbjy");
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
            messageBodyPart.setText(message);
            BodyPart messageBodyPart8 = new MimeBodyPart();
            messageBodyPart8.setText("this is second message part@!!!");

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            BodyPart messageBodyPart1 = new MimeBodyPart();
            BodyPart messageBodyPart2 = new MimeBodyPart();
            String filename = "C:\\Users\\user\\IdeaProjects\\TestingAgain\\test-output\\emailable-report.html";
            String filename1 = "C:\\Users\\user\\IdeaProjects\\TestingAgain\\src\\test\\java\\folder\\Paint.jpg";
            String filename2 = "C:\\Users\\user\\IdeaProjects\\TestingAgain\\src\\test\\java\\folder\\a.jpg";
            String[] FileArray = {filename, filename1, filename2};
            for (int i = 0; i < FileArray.length; i++) {
                DataSource source = new FileDataSource(FileArray[i]);
                if (i==0) {
                    messageBodyPart.setDataHandler(new DataHandler(source));
                    messageBodyPart.setFileName(FileArray[i]);
                    multipart.addBodyPart(messageBodyPart, i);
                }
                if (i==1) {
                    messageBodyPart1.setDataHandler(new DataHandler(source));
                    messageBodyPart1.setFileName(FileArray[i]);
                    multipart.addBodyPart(messageBodyPart1, i);
                }if (i==2) {
                    messageBodyPart2.setDataHandler(new DataHandler(source));
                    messageBodyPart2.setFileName(FileArray[i]);
                    multipart.addBodyPart(messageBodyPart2, i);
                }
            }
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
