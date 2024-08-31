package springstudy.daangnclone.common.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final int responseCode;
    private final int status;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.status = errorCode.getStatus();
        this.responseCode = errorCode.getResponseCode();
    }

}
