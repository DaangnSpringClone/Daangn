package springstudy.daangnclone.common.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import springstudy.daangnclone.common.service.PasswordEncoder;

@Component
@RequiredArgsConstructor
public class PasswordEncoderImpl implements PasswordEncoder {

    //TODO : Spring Security 사용시 삭제하거나 여기에 BcryptPasswordEncoder를 주입 혹은 아예 변경
    private final TemporaryPasswordEncoder encoder;

    @Override
    public String encode(String password) {
        return encoder.encode(password);
    }

    @Override
    public boolean matches(String password, String encodedPassword) {
        return encoder.matches(password, encodedPassword);
    }
}
