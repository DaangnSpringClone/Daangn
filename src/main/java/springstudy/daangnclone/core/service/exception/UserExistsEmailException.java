package springstudy.daangnclone.core.service.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springstudy.daangnclone.common.DanngnException;
import springstudy.daangnclone.common.ErrorCode;

@Getter
public class UserExistsEmailException extends DanngnException {
    public UserExistsEmailException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
