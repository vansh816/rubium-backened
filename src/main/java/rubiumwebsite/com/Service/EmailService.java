//package rubiumwebsite.com.Service;
//import lombok.RequiredArgsConstructor;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//import rubiumwebsite.com.Entity.Client;
//
//@Service
//@RequiredArgsConstructor
//public class EmailService {
//
//    private final JavaMailSender mailSender;
//
//    // Thank You Mail to Client
//    public void sendMailToClient(Client client) {
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setFrom("hello.rubiumai@gmail.com");
//        message.setTo(client.getEmail());
//        message.setSubject("Thank You for Contacting Rubium AI");
//                message.setText(
//                        "Hi " + client.getFullName() + ",\n\n" +
//                                "Thank you for contacting Rubium AI.\n\n" +
//                                "Your consultation call has been successfully booked with our team.\n\n" +
//                                "We have received your request regarding \"" + client.getService() + "\" and will review your requirements. " +
//                                "One of our experts will reach out to you shortly using the contact details you provided.\n\n" +
//                                "If you have any additional information to share, simply reply to this email.\n\n" +
//                                "We look forward to speaking with you!\n\n" +
//                                "Best Regards,\n" +
//                                "Rubium AI Team"
//                );
//        mailSender.send(message);
//    }}
package rubiumwebsite.com.Service;

import com.resend.Resend;
import com.resend.services.emails.model.SendEmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import rubiumwebsite.com.Entity.Client;


@Service
@RequiredArgsConstructor
public class EmailService {

    @Value("${spring.resend.api-key}")
    private String resendApiKey;

    public void sendMailToClient(Client client) {

        Resend resend = new Resend(resendApiKey);

        String html =
                "<p>Hi " + client.getFullName() + ",</p>" +

                        "<p>Thank you for contacting Rubium AI.</p>" +

                        "<p>Your consultation call has been successfully booked with our team.</p>" +

                        "<p>We have received your request regarding <b>\"" +
                        client.getService() +
                        "\"</b> and will review your requirements. " +
                        "One of our experts will reach out to you shortly using the contact details you provided.</p>" +


                        "<p>You can contact us directly at " +
                        "<a href=\"mailto:hello.rubiumai@gmail.com\">" +
                        "hello.rubiumai@gmail.com" +
                        "</a>.</p>" +
                        "<p>If you have any additional information to share, simply reply to the above email.</p>" +
                        "<p>We look forward to speaking with you!</p>" +

                        "<p>Best Regards,<br>" +
                        "Rubium AI Team</p>";

        SendEmailRequest request = SendEmailRequest.builder()
                .from("Rubium AI <onboarding@resend.dev>")
                .to(client.getEmail())
                .subject("Thank You for Contacting Rubium AI")
                .html(html)
                .build();

        resend.emails().send(request);
    }
}
