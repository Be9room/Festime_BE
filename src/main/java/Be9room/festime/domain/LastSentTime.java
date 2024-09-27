package Be9room.festime.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@RedisHash("last_sent_time")
@AllArgsConstructor
@Builder
@Getter
public class LastSentTime {
    @Id
    private String memberId;
    private LocalDateTime lastSentTime;

    public void setLastSentTime(LocalDateTime lastSentTime) {
        this.lastSentTime = lastSentTime;
    }
}
