package springstudy.daangnclone.adapter.outbound.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import springstudy.daangnclone.core.domain.User;
import springstudy.daangnclone.core.port.UserRepository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaUserRepository;

    @Override
    public User save(User user) {
        return jpaUserRepository.save(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return jpaUserRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpaUserRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return jpaUserRepository.existsById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaUserRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByPhoneNumber(String phoneNumber) {
        return jpaUserRepository.existsByPhoneNumber(phoneNumber);
    }
}
