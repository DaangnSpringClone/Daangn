package springstudy.daangnclone.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    //404 Not Found
    USER_NOT_FOUND(404001, "User not found"),

    //409 Conflict
    DUPLICATE_USER(409001, "User already exists")
    ;

    private final int status;
    private final String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getResponseCode() {
        return status / 1000;
    }

}
