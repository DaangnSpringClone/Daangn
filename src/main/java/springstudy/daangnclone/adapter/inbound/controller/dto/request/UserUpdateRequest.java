package springstudy.daangnclone.adapter.inbound.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import springstudy.daangnclone.adapter.inbound.controller.validator.ValidPhoneNumber;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
    @NotNull
    private Integer id;
    @Length(max = 20)
    private String password;
    @ValidPhoneNumber
    private String phoneNumber;
    @Length(max = 50)
    private String address;
}
