package rubiumwebsite.com.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import rubiumwebsite.com.Entity.Client;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    // Thank You Mail to Client
    public void sendMailToClient(Client client) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("rubiumai@gmail.com");
        message.setTo(client.getEmail());
        message.setSubject("Thank You for Contacting Rubium AI");
                message.setText(
                        "Hi " + client.getFullName() + ",\n\n" +
                                "Thank you for contacting Rubium AI.\n\n" +
                                "Your consultation call has been successfully booked with our team.\n\n" +
                                "We have received your request regarding \"" + client.getService() + "\" and will review your requirements. " +
                                "One of our experts will reach out to you shortly using the contact details you provided.\n\n" +
                                "If you have any additional information to share, simply reply to this email.\n\n" +
                                "We look forward to speaking with you!\n\n" +
                                "Best Regards,\n" +
                                "Rubium AI Team"
                );
        mailSender.send(message);
    }}