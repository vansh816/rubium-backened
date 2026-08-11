package rubiumwebsite.com.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rubiumwebsite.com.Entity.Client;
import rubiumwebsite.com.Repo.ClientRepository;

import java.util.List;

@Service
    @RequiredArgsConstructor
    public class ClientService {

        private final ClientRepository contactRepository;
        private final EmailService emailService;

//        public Client saveContact(Client client) {
//            // Thank You mail to Client
//            emailService.sendMailToClient(client);
//            return contactRepository.save(client);
//        }

    public Client saveContact(Client client) {
        Client savedClient = contactRepository.save(client);
        emailService.sendMailToClient(client);
        return savedClient;
}
    }
//
//    public List<Client> getAllContacts() {
//            return contactRepository.findAll();
//        }
//
//        public Client getContactById(String id) {
//            return contactRepository.findById(id)
//                    .orElseThrow(() -> new RuntimeException("Contact not found"));
//        }
//
//        public void deleteClient(String id) {
//            contactRepository.deleteById(id);
//        }
    //}
