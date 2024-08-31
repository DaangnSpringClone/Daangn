package springstudy.daangnclone.adapter.outbound.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import springstudy.daangnclone.core.domain.User;

public interface JpaUserRepository extends JpaRepository<User, Integer> {
    boolean existsById(Integer id);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);
}
