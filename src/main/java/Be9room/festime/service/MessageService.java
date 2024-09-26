package Be9room.festime.service;

import Be9room.festime.domain.Message;
import Be9room.festime.dto.MessageDto;

import java.util.List;

public interface MessageService {
    Message save(MessageDto messageDto);
    List<Message> getMessages();
}