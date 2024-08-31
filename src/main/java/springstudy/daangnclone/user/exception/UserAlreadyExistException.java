package springstudy.daangnclone.user.exception;

import springstudy.daangnclone.common.exception.BusinessException;
import springstudy.daangnclone.common.exception.ErrorCode;

public class UserAlreadyExistException extends BusinessException {

    public UserAlreadyExistException(ErrorCode errorCode) {
        super(errorCode.getStatus(), errorCode.getMessage());
    }
}
