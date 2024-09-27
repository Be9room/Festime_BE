package Be9room.festime.config;

import com.vane.badwordfiltering.BadWordFiltering;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BadWordFilteringConfig {
    @Bean
    public BadWordFiltering badwordFiltering(){
        return new BadWordFiltering();
    }
}
