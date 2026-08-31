package rubiumwebsite.com.Controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import rubiumwebsite.com.Entity.Client;
import rubiumwebsite.com.Service.ClientService;
import org.springframework.web.bind.annotation.*;
import rubiumwebsite.com.Service.EmailService;


//@CrossOrigin(origins = "https://rubium-frontend-5d763xzt9-sharmavn258-6395s-projects.vercel.app")
@CrossOrigin(origins = "https://rubiumai.com")
@RestController
@RequestMapping
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;



@PostMapping("/submit")
public ResponseEntity<?> submit(@Valid @RequestBody Client client) {
    try {
        Client savedClient = clientService.saveContact(client);
        return ResponseEntity.ok(savedClient);
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(500).body(e.getMessage());
    }
}}
//
//    @GetMapping("/all")
//    public ResponseEntity<List<Client>> getAllClient() {
//        return ResponseEntity.ok(contactService.getAllContacts());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Client> getClient(@PathVariable String id) {
//        return ResponseEntity.ok(contactService.getContactById(id));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteClient(@PathVariable String id) {
//        contactService.deleteClient(id);
//        return ResponseEntity.ok("Contact deleted successfully");
//    }
