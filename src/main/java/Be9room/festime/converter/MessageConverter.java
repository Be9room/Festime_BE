package Be9room.festime.converter;

import Be9room.festime.domain.Message;
import Be9room.festime.dto.MessageChatDto;
import Be9room.festime.dto.MessageWebDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class MessageConverter {
    public static MessageWebDto.MessageResponseDto toMessageResponseDto(Message message){
        return MessageWebDto.MessageResponseDto.builder()
                .memberName(message.getMemberName())
                .memberId(message.getMemberId())
                .message(message.getMessage())
                .createdAt(message.getCreatedAt())
                .build();
    }
    public static MessageWebDto.MessageResponseDtoList toMessageResponseDtoList(Page<Message> messagePage){
        List<MessageWebDto.MessageResponseDto> messageList = messagePage.stream()
                .map(MessageConverter::toMessageResponseDto)
                .toList();

        return MessageWebDto.MessageResponseDtoList.builder()
                .messageDtoList(messageList)
                .isLast(messagePage.isLast())
                .isFirst(messagePage.isFirst())
                .totalPage(messagePage.getTotalPages())
                .totalElements(messagePage.getTotalElements())
                .listSize(messageList.size())
                .build();
    }
}
