package Be9room.festime.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Document(collection = "messages")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    private String id;
    private String memberName;
    private String memberId;
    private String message;
    private LocalDateTime createdAt;
}
