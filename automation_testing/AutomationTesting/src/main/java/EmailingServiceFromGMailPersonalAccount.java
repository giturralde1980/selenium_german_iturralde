
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailingServiceFromGMailPersonalAccount {

    public static void main(String args[])
    {
        final String username = "german.iturralde@gmail.com";
        final String password = "Montevideo1980";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("kundenservice_one@8-1s5zzn3r9egkabsph0yuhc6fbnovbyurw049hkdz8vwujzadd4.3n-38lzuaa.cs128.apex.sandbox.salesforce.com\n")
            );
            message.setSubject("Test Email from German personal email with api calls");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Email enviado correctamente");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
