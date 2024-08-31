package springstudy.daangnclone.adapter.inbound.controller.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springstudy.daangnclone.adapter.inbound.controller.exception.UserInvalidParamException;
import springstudy.daangnclone.common.DanngnException;
import springstudy.daangnclone.common.ErrorResponse;
import springstudy.daangnclone.core.service.exception.UserExistsEmailException;
import springstudy.daangnclone.core.service.exception.UserExistsPhoneNumberException;
import springstudy.daangnclone.core.service.exception.UserNotExistsException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({
            UserInvalidParamException.class,
            UserExistsEmailException.class,
            UserExistsPhoneNumberException.class,
            UserNotExistsException.class
    })
    public ResponseEntity<ErrorResponse> handleDanngnException(DanngnException exception) {
        log.error("Exception!", exception);

        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }
}
