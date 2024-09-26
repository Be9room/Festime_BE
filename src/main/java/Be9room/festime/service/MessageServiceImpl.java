package Be9room.festime.service;

import Be9room.festime.domain.Message;
import Be9room.festime.dto.MessageChatDto;
import Be9room.festime.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    @Override
    public Message save(MessageChatDto messageChatDto) {
        Message message = Message.builder()
                .memberId(messageChatDto.getMemberId())
                .memberName(messageChatDto.getMemberName())
                .message(messageChatDto.getMessage())
                .createdAt(LocalDateTime.now())
                .build();

        return messageRepository.save(message);
    }

    @Override
    public Page<Message> getMessages(Integer page) {
        return messageRepository.findMessagesByCreatedAtAfterOrderByCreatedAtDesc(LocalDateTime.now().minusHours(3),PageRequest.of(page, 30));
    }
}
