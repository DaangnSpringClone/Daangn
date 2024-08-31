package springstudy.daangnclone.core.service.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import springstudy.daangnclone.common.DanngnException;
import springstudy.daangnclone.common.ErrorCode;

@Getter
@NoArgsConstructor
public class UserNotExistsException extends DanngnException {
    public UserNotExistsException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
