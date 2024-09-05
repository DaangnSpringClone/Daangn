package springstudy.daangnclone.core.service;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import springstudy.daangnclone.core.domain.User;
import springstudy.daangnclone.core.port.UserRepository;
import springstudy.daangnclone.core.service.dto.UserDto;
import springstudy.daangnclone.core.service.exception.UserExistsEmailException;
import springstudy.daangnclone.core.service.exception.UserExistsPhoneNumberException;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserServiceTest {

    private final UserRepository userRepository = Mockito.mock(UserRepository.class);
    private final UserService userService = new UserService(userRepository);

    @Test
    @DisplayName("User 1개 획득")
    public void getOneById() {
        // given
        Integer id = 1;
        User user = User.builder().id(id).build();

        when(userRepository.findById(any(Integer.class))).thenReturn(Optional.of(user));

        // when
        UserDto userDto = userService.getOneById(id);

        // then
        Assertions.assertThat(userDto.getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("User 1개 저장 - 성공")
    public void save() {
        // given
        Integer id = 1;
        String name = "name1";
        String email = "test@email.com";
        String password = "password1";
        String phoneNumber = "010-1234-1234";
        LocalDate birthDate = LocalDate.of(2024, 8, 31);
        String address = "경기도 과천시";

        UserDto userDto = UserDto.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .birthDate(birthDate)
                .address(address)
                .build();

        User user = User.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .birthDate(birthDate)
                .address(address)
                .build();

        when(userRepository.save(any(User.class))).thenReturn(user);

        // when
        UserDto savedDto = userService.save(userDto);
        // then
        Assertions.assertThat(savedDto.getId()).isEqualTo(id);
        Assertions.assertThat(savedDto.getName()).isEqualTo(name);
        Assertions.assertThat(savedDto.getEmail()).isEqualTo(email);
        Assertions.assertThat(savedDto.getPassword()).isEqualTo(password);
        Assertions.assertThat(savedDto.getPhoneNumber()).isEqualTo(phoneNumber);
        Assertions.assertThat(savedDto.getBirthDate()).isEqualTo(birthDate);
        Assertions.assertThat(savedDto.getAddress()).isEqualTo(address);
    }

    @Test
    @DisplayName("User 1개 저장 - 이미 존재하는 경우(실패)")
    public void checkAlreadyExists() {
        Integer id = 1;
        String name = "name1";
        String email = "test@email.com";
        String password = "password1";
        String phoneNumber = "010-1234-1234";
        LocalDate birthDate = LocalDate.of(2024, 8, 31);
        String address = "경기도 과천시";

        UserDto userDto = UserDto.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .birthDate(birthDate)
                .address(address)
                .build();

        when(userRepository.existsByEmail(email)).thenReturn(true);

        // when & then
        org.junit.jupiter.api.Assertions.assertThrows(UserExistsEmailException.class, () -> {
            userService.save(userDto);
        });

        // given
        userDto.setEmail("test2@email.com");
        when(userRepository.existsByPhoneNumber(any(String.class))).thenReturn(true);
        // when & then
        org.junit.jupiter.api.Assertions.assertThrows(UserExistsPhoneNumberException.class, () -> {
            userService.save(userDto);
        });
    }

}