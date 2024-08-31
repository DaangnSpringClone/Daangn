package springstudy.daangnclone.common.exception;

import lombok.Getter;

/**
 * <h2>Error Code</h2>
 * <P>error status는 responseCode + index number</P>
 * dass
 */
@Getter
public enum ErrorCode {

    //404 Not Found
    USER_NOT_FOUND(404001, "User not found"),

    //409 Conflict
    USER_ALREADY_EXISTS(409001, "User already exists")
    ;

    private final int status;
    private final String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

}
