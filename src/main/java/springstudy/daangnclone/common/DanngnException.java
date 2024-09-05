package springstudy.daangnclone.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DanngnException extends RuntimeException {
    protected ErrorCode errorCode;

    public DanngnException(String message) {
        super(message);
    }
}
