package rubiumwebsite.com.Controller;

import rubiumwebsite.com.Service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = {"https://rubiumai.com" ,
"http://localhost:5173" ,
        "http:localhost:5174"
})
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<?> chat(
            @RequestBody Map<String, String> request
    ) {

        String message = request.get("message");
        String conversationId = request.get("conversationId");

        if (message == null || message.isBlank()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Message cannot be empty"));
        }

        if (conversationId == null || conversationId.isBlank()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Conversation ID cannot be empty"));
        }

        String reply = chatService.chatResponse(
                message,
                conversationId
        );

        return ResponseEntity.ok(
                Map.of("reply", reply)
        );
    }
}