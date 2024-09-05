package springstudy.daangnclone.adapter.inbound.controller.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import springstudy.daangnclone.adapter.inbound.controller.validator.ValidPhoneNumber;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveRequest {
    @NotBlank
    @Length(max = 10)
    private String name;
    @Email
    @Length(max = 30)
    private String email;
    @NotBlank
    @Length(max = 20)
    private String password;
    @NotNull
    @ValidPhoneNumber
    private String phoneNumber;
    @NotNull
    private LocalDate birthDate;
    @NotNull
    @Length(max = 50)
    private String address;
}
