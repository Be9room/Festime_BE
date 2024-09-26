package Be9room.festime.service;

import Be9room.festime.domain.Message;
import Be9room.festime.dto.MessageDto;
import Be9room.festime.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    @Override
    public Message save(MessageDto messageDto) {
        Message message = Message.builder()
                .memberId(messageDto.getMemberId())
                .memberName(messageDto.getMemberName())
                .message(messageDto.getMessage())
                .createdAt(LocalDateTime.now())
                .build();

        return messageRepository.save(message);
    }

    @Override
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }
}
