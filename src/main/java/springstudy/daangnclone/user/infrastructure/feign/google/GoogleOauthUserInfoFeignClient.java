package springstudy.daangnclone.user.infrastructure.feign.google;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import springstudy.daangnclone.user.infrastructure.feign.OauthUserInfoResponse;

@FeignClient(name = "google-user-info", url = "https://www.googleapis.com")
public interface GoogleOauthUserInfoFeignClient {

    @PostMapping("/userinfo/v2/me")
    OauthUserInfoResponse getUserInfo(String accessToken);
}
