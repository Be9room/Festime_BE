package Be9room.festime.service;

import Be9room.festime.domain.Message;
import Be9room.festime.dto.MessageChatDto;
import org.springframework.data.domain.Page;

public interface MessageService {
    Message save(MessageChatDto messageChatDto);
    Page<Message> getMessages(Integer page);
}