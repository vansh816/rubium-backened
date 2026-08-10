package rubiumwebsite.com.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Document(collection = "Clients")
    public class Client {

        @Id
        private String id;

        @NotBlank
        private String fullName;

        @NotBlank
        @Email
        private String email;

        @NotBlank
        private String company;

        @NotBlank
        private String service;

        @NotBlank
        @Pattern(regexp = "^[0-9]{10}$")
        private String phone;

        @NotBlank
        private String projectOverview;
    }

