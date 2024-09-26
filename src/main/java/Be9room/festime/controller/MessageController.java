package Be9room.festime.controller;

import Be9room.festime.apiPayLoad.ApiResponse;
import Be9room.festime.apiPayLoad.code.status.SuccessStatus;
import Be9room.festime.converter.MessageConverter;
import Be9room.festime.domain.Message;
import Be9room.festime.dto.MessageChatDto;
import Be9room.festime.dto.MessageWebDto;
import Be9room.festime.enums.MessageType;
import Be9room.festime.service.MessageService;
import Be9room.festime.validation.annotation.CheckPage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public void enter(MessageChatDto message){
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
    public void message(MessageChatDto message){
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
    public void leave(MessageChatDto message){
        message.setMessageType(MessageType.LEAVE.toString());
        message.setMessage(message.getMemberName() + "님이 방명록에서 나가셨어요!");

        messageService.save(message);

        template.convertAndSend("/topic/guestbook",  message);
    }

    @GetMapping(value = "/message")
    public ApiResponse<MessageWebDto.MessageResponseDtoList> getMessageList(@CheckPage @RequestParam(name = "page") Integer page){
        Page<Message> messagePage = messageService.getMessages(page);
        MessageWebDto.MessageResponseDtoList messageResponseDtoList = MessageConverter.toMessageResponseDtoList(messagePage);
        return ApiResponse.of(SuccessStatus.MESSAGE_RETURN, messageResponseDtoList);
    }

}