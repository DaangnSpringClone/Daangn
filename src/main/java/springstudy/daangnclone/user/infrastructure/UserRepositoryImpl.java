package springstudy.daangnclone.user.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import springstudy.daangnclone.user.domain.User;
import springstudy.daangnclone.user.service.port.UserRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return userJpaRepository.findByEmail(email).map(UserEntity::toDomain);
    }

    @Override
    public User save(User user) {
        return userJpaRepository.save(UserEntity.from(user)).toDomain();
    }
}
