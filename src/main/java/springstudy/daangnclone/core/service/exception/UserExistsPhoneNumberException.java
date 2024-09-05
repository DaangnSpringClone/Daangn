package springstudy.daangnclone.core.service.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springstudy.daangnclone.common.DanngnException;
import springstudy.daangnclone.common.ErrorCode;

@Getter
@NoArgsConstructor
public class UserExistsPhoneNumberException extends DanngnException {
    public UserExistsPhoneNumberException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
