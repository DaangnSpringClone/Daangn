package springstudy.daangnclone.core.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 10)
    private String name;
    @Column(length = 30)
    private String email;
    @Column(length = 20)
    private String password;
    @Column(length = 11)
    private String phoneNumber;
    private LocalDate birthDate;
    @Column(length = 50)
    private String address;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    // naver
    private String provider;
    // 네이버 로그인 한 유저의 고유 ID 가 들어감
    private String providerId;
    public void updatePassword(String password) {
        this.password = password;
    }

    public void updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void updateAddress(String address) {
        this.address = address;
    }
}
