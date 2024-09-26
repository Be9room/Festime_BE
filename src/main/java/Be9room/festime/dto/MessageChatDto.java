package Be9room.festime.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageChatDto {
    private String memberName;
    private String memberId;
    private String messageType;
    private String message;
}