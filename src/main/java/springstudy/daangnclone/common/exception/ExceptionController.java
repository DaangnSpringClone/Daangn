package springstudy.daangnclone.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponse> handleBusinessException(BusinessException e) {
        return ResponseEntity
                .status(e.getResponseCode())
                .body(ExceptionResponse.of(e.getStatus(), e.getMessage()));
    }
}
