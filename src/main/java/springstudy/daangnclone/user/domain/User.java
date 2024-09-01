package springstudy.daangnclone.user.domain;


import lombok.Builder;
import springstudy.daangnclone.common.service.DateHolder;
import springstudy.daangnclone.common.service.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record User(String address, LocalDate birthDate, LocalDateTime createdAt, LocalDateTime deletedAt, String email,
                   Long id, String name, String password, String phoneNumber, UserStatus status,
                   LocalDateTime updatedAt) {

    @Builder
    public User {
    }

    public static User from(UserCreate userCreate, DateHolder dateHolder, PasswordEncoder passwordEncoder) {
        return User.builder()
                .name(userCreate.name())
                .email(userCreate.email())
                .password(passwordEncoder.encode(userCreate.password()))
                .phoneNumber(userCreate.phoneNumber())
                .birthDate(userCreate.birthDate())
                .address(userCreate.address())
                .createdAt(dateHolder.now())
                .build();
    }
}
