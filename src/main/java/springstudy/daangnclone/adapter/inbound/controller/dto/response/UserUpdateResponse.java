package springstudy.daangnclone.adapter.inbound.controller.dto.response;

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
public class UserUpdateResponse {
    private Integer id;
    private String password;
    private String phoneNumber;
    private String address;
}
