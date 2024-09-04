package springstudy.daangnclone.user.service.port;

import springstudy.daangnclone.user.infrastructure.feign.OauthUserInfoResponse;

public interface UserOauthFeignClient {

    OauthUserInfoResponse oauthLogin(String code);

}
