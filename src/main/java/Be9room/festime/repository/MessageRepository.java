package Be9room.festime.repository;

import Be9room.festime.domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;

public interface MessageRepository extends MongoRepository<Message, String> {
    Page<Message> findMessagesByCreatedAtAfterOrderByCreatedAtDesc(LocalDateTime time, PageRequest pageRequest);
}
