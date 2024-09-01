package springstudy.daangnclone.user.controller.port;

import springstudy.daangnclone.user.domain.User;
import springstudy.daangnclone.user.domain.UserCreate;

public interface UserService {

    User join(UserCreate userCreate);
}
