package Be9room.festime.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
public class WebSocketConfigurer implements WebSocketMessageBrokerConfigurer {
//    private final StompHandler stompHandler;
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stomp/guestbook")
                .setAllowedOrigins("*");
//                .withSockJS();
        //주소 : ws://localhost:8080/stomp/guestbook
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.setPathMatcher(new AntPathMatcher("."));
        registry.setApplicationDestinationPrefixes("/pub");
//        registry.enableStompBrokerRelay("/queue", "/topic", "/exchange", "/amq/queue");
        registry.enableSimpleBroker("/sub");
    }

//    @Override
//    public void configureClientInboundChannel(ChannelRegistration registration) {
//        registration.interceptors(stompHandler);
//    }
}
