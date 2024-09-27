package Be9room.festime.service;

import Be9room.festime.domain.LastSentTime;
import Be9room.festime.repository.LastSentTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimeLimitServiceImpl implements TimeLimitService {
    private final LastSentTimeRepository lastSentTimeRepository;


    @Override
    public Boolean isTimeElapsed(String memberId) {
        Optional<LastSentTime> lastSentTime = lastSentTimeRepository.findById(memberId);

        if(lastSentTime.isEmpty()){
            LastSentTime cur = LastSentTime.builder()
                    .memberId(memberId)
                    .lastSentTime(LocalDateTime.now())
                    .build();
            lastSentTimeRepository.save(cur);
            return true;
        } else{
            LastSentTime time = lastSentTime.get();
            Duration duration = Duration.between(time.getLastSentTime(), LocalDateTime.now());

            if(duration.getSeconds() >= 30){
                lastSentTimeRepository.delete(time);
                LastSentTime cur = LastSentTime.builder()
                        .memberId(memberId)
                        .lastSentTime(LocalDateTime.now())
                        .build();
                lastSentTimeRepository.save(cur);
                return true;
            }else{
                return false;
            }
        }
    }
}
