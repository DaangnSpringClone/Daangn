package springstudy.daangnclone.common.exception;

import lombok.Builder;

@Builder
public class ExceptionResponse {

    private final int code;
    private final String message;

    public static ExceptionResponse of(int code, String message) {
        return ExceptionResponse.builder()
                .code(code)
                .message(message)
                .build();
    }
}
