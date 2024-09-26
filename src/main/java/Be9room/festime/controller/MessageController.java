package Be9room.festime.controller;

import Be9room.festime.dto.MessageDto;
import Be9room.festime.enums.MessageType;
import Be9room.festime.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MessageController {
    private final SimpMessagingTemplate template;
    private final MessageService messageService;
    /**
     * 채팅 입장
     * /pub/chat/enter 로 보내면 여기로 온다.
     * @param message
     */
    @MessageMapping(value = "/guestbook/enter")
    @Deprecated
    public void enter(MessageDto message){
        message.setMessageType(MessageType.ENTER.toString());
        message.setMessage(message.getMemberName() + "님이 방명록에 참여했어요!");

        messageService.save(message);

        template.convertAndSend("/topic/guestbook", message);
    }

    /**
     * 메세지 전송
     * @param message
     */
    @MessageMapping(value = "/guestbook/message")
    public void message(MessageDto message){
        message.setMessageType(MessageType.MESSAGE.toString());

        messageService.save(message);

        template.convertAndSend("/topic/guestbook", message);
    }

    /**
     * 채팅방 나감
     * @param message
     */
    @MessageMapping(value = "/guestbook/leave")
    @Deprecated
    public void leave(MessageDto message){
        message.setMessageType(MessageType.LEAVE.toString());
        message.setMessage(message.getMemberName() + "님이 방명록에서 나가셨어요!");

        messageService.save(message);

        template.convertAndSend("/topic/guestbook",  message);
    }


}
