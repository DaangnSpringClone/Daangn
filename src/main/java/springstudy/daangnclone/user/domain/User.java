package springstudy.daangnclone.user.domain;


import lombok.Builder;
import springstudy.daangnclone.common.service.DateHolder;
import springstudy.daangnclone.common.service.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record User(
        Long id,
        String name,
        String email,
        String password,
        String phoneNumber,
        String address,
        LocalDate birthDate,
        UserStatus status,
        LocalDateTime deletedAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

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
                .status(UserStatus.ACTIVE)
                .createdAt(dateHolder.now())
                .build();
    }
}
