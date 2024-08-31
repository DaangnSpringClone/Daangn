package springstudy.daangnclone.user.infrastructure;

import org.springframework.stereotype.Repository;
import springstudy.daangnclone.user.domain.User;
import springstudy.daangnclone.user.service.port.UserRepository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return null;
    }
}
