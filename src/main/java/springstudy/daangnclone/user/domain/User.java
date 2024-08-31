package springstudy.daangnclone.user.domain;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDate birthDate;
    private String address;
    private UserStatus status;
    private LocalDateTime deletedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public User(String address, LocalDate birthDate, LocalDateTime createdAt, LocalDateTime deletedAt, String email, Long id, String name, String password, String phoneNumber, UserStatus status, LocalDateTime updatedAt) {
        this.address = address;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.updatedAt = updatedAt;
    }
}
