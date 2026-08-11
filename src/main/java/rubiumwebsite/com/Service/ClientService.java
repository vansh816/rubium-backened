package rubiumwebsite.com.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rubiumwebsite.com.Entity.Client;
import rubiumwebsite.com.Repo.ClientRepository;

import rubiumwebsite.com.Service.EmailService;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository contactRepository;
    private final EmailService emailService;

    public Client saveContact(Client client) {
        Client savedClient = contactRepository.save(client);
        emailService.sendMailToClient(client);
        return savedClient;
    }
}