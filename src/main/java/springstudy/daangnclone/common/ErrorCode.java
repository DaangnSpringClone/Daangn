package springstudy.daangnclone.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_PARAM(400, "COMMON-ERR-400", "INVALID PARAMETER"),
    NOT_EXIST_USER(400, "USER-ERR-400", "NOT EXIST USER"),
    ALREADY_EXISTS_EMAIL(400, "USER-ERR-401", "ALREADY EXISTS EMAIL"),
    ALREADY_EXISTS_PHONE_NUMBER(400, "USER-ERR-402", "ALREADY EXISTS PHONENUMBER");

    private int status;
    private String errorCode;
    private String message;
}
