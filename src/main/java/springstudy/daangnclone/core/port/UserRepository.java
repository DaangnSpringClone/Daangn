package springstudy.daangnclone.core.port;

import springstudy.daangnclone.core.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Integer id);
    List<User> findAll();
    void deleteById(Integer id);
    boolean existsById(Integer id);
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
}
