package springstudy.daangnclone.adapter.inbound.controller.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    private String regexp;

    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
        this.regexp = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // null 체크는 @NotNull 을 사용하는 것으로 한다.
        if (value == null) {
            return true;
        }

        if (value.isEmpty()) {
            return false;
        }

        if (value.length() > 13) {
            return false;
        }

        return Pattern.matches(regexp, value);
    }
}
