package springstudy.daangnclone.user.infrastructure;

import jakarta.persistence.*;
import lombok.Getter;
import springstudy.daangnclone.user.domain.User;
import springstudy.daangnclone.user.domain.UserStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false, name = "address")
    private String address;

    @Column(nullable = false, name = "birth_date")
    private LocalDate birthDate;

    @Column(nullable = false, name = "status")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Column(nullable = true, name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @Column(nullable = true, name = "updated_at")
    private LocalDateTime updatedAt;

    public static UserEntity from(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.id = user.id();
        userEntity.name = user.name();
        userEntity.email = user.email();
        userEntity.password = user.password();
        userEntity.phoneNumber = user.phoneNumber();
        userEntity.address = user.address();
        userEntity.birthDate = user.birthDate();
        userEntity.userStatus = user.status();
        userEntity.deletedAt = user.deletedAt();
        userEntity.createdAt = user.createdAt();
        userEntity.updatedAt = user.updatedAt();
        return userEntity;
    }

    public User toDomain() {
        return User.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .birthDate(birthDate)
                .address(address)
                .build();
    }
}
