package springstudy.daangnclone.user.service.port;

import springstudy.daangnclone.user.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByEmail(String email);

    User save(User user);
}
