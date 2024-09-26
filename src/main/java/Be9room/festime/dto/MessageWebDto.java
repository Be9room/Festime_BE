package Be9room.festime.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class MessageWebDto {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class MessageResponseDtoList{
        List<MessageResponseDto> messageDtoList;
        Boolean isFirst;
        Boolean isLast;
        Long totalElements;
        Integer listSize;
        Integer totalPage;
    }
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class MessageResponseDto{
        private String memberName;
        private String memberId;
        private String message;
        private LocalDateTime createdAt;
    }
}