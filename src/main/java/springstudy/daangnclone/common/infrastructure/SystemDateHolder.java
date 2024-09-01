package springstudy.daangnclone.common.infrastructure;

import org.springframework.stereotype.Component;
import springstudy.daangnclone.common.service.DateHolder;

import java.time.LocalDateTime;

@Component
public class SystemDateHolder implements DateHolder {

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }

}
