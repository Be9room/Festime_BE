package Be9room.festime.common;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class RandomNameGenerator {
    List<String> adjective = Arrays.asList(
        "노래하는", "졸린", "배고픈", "목마른", "피곤한", "행복한", "신나는", "화려한", "유쾌한" ,
            "기대하는", "반짝이는", "특별한", "감동하는", "멋진", "춤추는", "대단한"
    );

    List<String> objective = Arrays.asList(
            "인덕이", "안뇽이", "비룡이"
    );
    public String generate(){
        Collections.shuffle(adjective);
        Collections.shuffle(objective);
        return adjective.get(0) + " " + objective.get(0);
    }
}
