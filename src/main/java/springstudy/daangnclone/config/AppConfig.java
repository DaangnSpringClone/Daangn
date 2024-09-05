package springstudy.daangnclone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springstudy.daangnclone.adapter.outbound.persistence.UserRepositoryImpl;
import springstudy.daangnclone.core.port.UserRepository;
import springstudy.daangnclone.core.service.UserService;

@Configuration
public class AppConfig {
    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public UserRepository userRepository(UserRepositoryImpl userRepositoryImpl) {
        return userRepositoryImpl;
    }
}
