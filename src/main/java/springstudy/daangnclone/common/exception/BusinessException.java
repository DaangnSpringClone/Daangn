package springstudy.daangnclone.common.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final int responseCode;
    private final int status;

    public BusinessException(int status, String message) {
        super(message);
        this.status = status;
        this.responseCode = calculateResponseCode();
    }

    private int calculateResponseCode() {
        return this.status / 1000;
    }

}
