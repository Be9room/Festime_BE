package Be9room.festime.repository;

import Be9room.festime.domain.LastSentTime;
import org.springframework.data.repository.CrudRepository;

public interface LastSentTimeRepository extends CrudRepository<LastSentTime, String> {
}
