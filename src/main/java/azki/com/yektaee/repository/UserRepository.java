package azki.com.yektaee.repository;

import azki.com.yektaee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    Set<User> findByIdIn(List<Long> idList);
}
