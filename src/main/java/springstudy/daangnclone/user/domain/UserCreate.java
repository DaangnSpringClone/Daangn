package springstudy.daangnclone.user.domain;

import lombok.Builder;

import java.time.LocalDate;

public record UserCreate(String email, String address, String name, String password, String phoneNumber,
                         LocalDate birthDate) {
    @Builder
    public UserCreate {
    }
}
