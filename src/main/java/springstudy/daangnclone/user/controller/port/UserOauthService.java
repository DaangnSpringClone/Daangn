package springstudy.daangnclone.user.controller.port;

import springstudy.daangnclone.user.infrastructure.feign.OauthUserInfoResponse;

public interface UserOauthService {

    OauthUserInfoResponse snsLogin(String code);
}
