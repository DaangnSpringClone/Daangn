package springstudy.daangnclone.user.domain;


import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record User(String address, LocalDate birthDate, LocalDateTime createdAt, LocalDateTime deletedAt, String email,
                   Long id, String name, String password, String phoneNumber, UserStatus status,
                   LocalDateTime updatedAt) {

    @Builder
    public User {
    }
}
