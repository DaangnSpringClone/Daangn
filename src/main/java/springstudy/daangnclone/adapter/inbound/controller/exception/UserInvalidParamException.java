package springstudy.daangnclone.adapter.inbound.controller.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import springstudy.daangnclone.common.DanngnException;
import springstudy.daangnclone.common.ErrorCode;

@Getter
@NoArgsConstructor
public class UserInvalidParamException extends DanngnException {
    public UserInvalidParamException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
