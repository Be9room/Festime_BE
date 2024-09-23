package Be9room.festime.controller;

import Be9room.festime.dto.MessageDTO;
import Be9room.festime.enums.MessageType;
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
    /**
     * 채팅 입장
     * /pub/chat/enter 로 보내면 여기로 온다.
     * @param message
     */
    @MessageMapping(value = "/guestbook/enter")
    public void enter(MessageDTO message){
        log.info("eee");
        message.setMessageType(MessageType.ENTER.toString());
        message.setMessage(message.getMemberName() + "님이 방명록에 참여했어요!");

        /* 메세지 저장 부분 */

        template.convertAndSend("/sub/guestbook", message);
    }

    /**
     * 메세지 전송
     * @param message
     */
    @MessageMapping(value = "/guestbook/message")
    public void message(MessageDTO message){
        log.info("messsaggee");
        message.setMessageType(MessageType.MESSAGE.toString());

        /* 메세지 저장 부분 */

        template.convertAndSend("/sub/guestbook", message);
    }

    /**
     * 채팅방 나감
     * @param message
     */
    @MessageMapping(value = "/guestbook/leave")
    public void leave(MessageDTO message){
        message.setMessageType(MessageType.LEAVE.toString());
        message.setMessage(message.getMemberName() + "님이 방명록에서 나가셨어요!");

        /* 메세지 저장 부분 */

        template.convertAndSend("/sub/guestbook",  message);
    }


}
