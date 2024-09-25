package Be9room.festime.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberDto {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class MemberResponseDto {
        String memberName;
        String memberId;
    }
}
