package Be9room.festime.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageDTO {
    private String memberName;
    private String memberId;
    private String messageType;
    private String message;
}