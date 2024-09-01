package springstudy.daangnclone.user.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springstudy.daangnclone.mock.FakeDateHolder;
import springstudy.daangnclone.mock.FakeUserRepository;
import springstudy.daangnclone.user.domain.User;
import springstudy.daangnclone.user.domain.UserCreate;
import springstudy.daangnclone.user.domain.UserStatus;
import springstudy.daangnclone.user.exception.UserAlreadyExistException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserServiceImplTest {

    @DisplayName("회원가입을 요청하면 회원가입이 된다.")
    @Test
    void register1() {
        //given
        FakeUserRepository userRepository = new FakeUserRepository();
        FakeDateHolder dateHolder = new FakeDateHolder(LocalDateTime.now());
        UserServiceImpl userService = new UserServiceImpl(userRepository, dateHolder);
        UserCreate joinUser = UserCreate.builder()
                .name("hyun")
                .email("test@naver.com")
                .password("1234")
                .phoneNumber("01011114444")
                .birthDate(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .address("seoul")
                .build();
        User user = userService.join(joinUser);
        assertThat(user).isNotNull();
        assertThat(user.id()).isEqualTo(1L);
        assertThat(user.name()).isEqualTo("hyun");
        assertThat(user.email()).isEqualTo("test@naver.com");
        assertThat(user.password()).isEqualTo("1234");
        assertThat(user.phoneNumber()).isEqualTo("01011114444");
        assertThat(user.birthDate()).isEqualTo(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        assertThat(user.address()).isEqualTo("seoul");
        assertThat(user.status()).isEqualTo(UserStatus.ACTIVE);
        assertThat(user.createdAt()).isEqualTo(dateHolder.now());
    }

    @DisplayName("이미 존재하는 이메일으로 회원가입을 진행하면 UserAlreadyExistException이 발생한다.")
    @Test
    void register2() {
        //given
        FakeUserRepository userRepository = new FakeUserRepository();
        FakeDateHolder fakeDateHolder = new FakeDateHolder(LocalDateTime.now());
        UserServiceImpl userService = new UserServiceImpl(userRepository, fakeDateHolder);
        userRepository.save(User.builder()
                .id(1L)
                .name("hyun")
                .email("test@naver.com")
                .password("1234")
                .phoneNumber("01011114444")
                .birthDate(new Date().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate())
                .address("seoul")
                .status(UserStatus.ACTIVE)
                .build());
        //when
        assertThatThrownBy(() -> {
            userService.join(UserCreate.builder()
                    .name("hyun")
                    .email("test@naver.com")
                    .password("1234")
                    .phoneNumber("01011114444")
                    .birthDate(new Date().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate())
                    .address("seoul")
                    .build());
        }).isInstanceOf(UserAlreadyExistException.class);
    }

}