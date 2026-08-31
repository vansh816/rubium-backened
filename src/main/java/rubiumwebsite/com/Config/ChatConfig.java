package rubiumwebsite.com.Config;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//@Configuration
//public class ChatConfig {
//
//    @Bean
//    public ChatClient chatClient(ChatClient.Builder builder) throws IOException {
//
//        ClassPathResource resource = new ClassPathResource("prompts/rubium-chatbot.txt");
//
//        String systemPrompt = new String(
//                resource.getInputStream().readAllBytes(),
//                StandardCharsets.UTF_8
//        );
//        return builder
//                .defaultSystem(systemPrompt)
//                .build();
//    }
//}
@Configuration
public class ChatConfig {

    @Bean
    public ChatMemory chatMemory() {
        return MessageWindowChatMemory.builder()
                .maxMessages(20)
                .build();
    }

    @Bean
    public ChatClient chatClient(
            ChatClient.Builder builder,
            ChatMemory chatMemory
    ) throws IOException {

        ClassPathResource resource =
                new ClassPathResource("prompts/rubium-chatbot.txt");

        String systemPrompt = new String(
                resource.getInputStream().readAllBytes(),
                StandardCharsets.UTF_8
        );

        return builder
                .defaultSystem(systemPrompt)
                .defaultAdvisors(
                        MessageChatMemoryAdvisor.builder(chatMemory).build()
                )
                .build();
    }
}