package springstudy.daangnclone.user.controller.response;

import lombok.Builder;
import springstudy.daangnclone.user.domain.User;

import java.time.LocalDate;

@Builder
public record UserResponse(
        String email,
        String name,
        String phoneNumber,
        LocalDate birthDate,
        String address
) {
    public static UserResponse from(User user) {
        return UserResponse.builder()
                .address(user.address())
                .email(user.email())
                .name(user.name())
                .phoneNumber(user.phoneNumber())
                .birthDate(user.birthDate())
                .build();
    }
}
