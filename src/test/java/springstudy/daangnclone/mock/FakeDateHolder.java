package springstudy.daangnclone.mock;

import springstudy.daangnclone.common.service.DateHolder;

import java.time.LocalDateTime;

public class FakeDateHolder implements DateHolder {

    private final LocalDateTime now;

    @Override
    public LocalDateTime now() {
        return this.now;
    }

    public FakeDateHolder(LocalDateTime now) {
        this.now = now;
    }
}
