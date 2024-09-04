package springstudy.daangnclone.user.infrastructure.feign.google;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springstudy.daangnclone.user.infrastructure.feign.OauthUserInfoResponse;

@FeignClient(name = "google")
public interface GoogleOauthFeignClient {

    @PostMapping("https://oauth2.googleapis.com/token")
    GoogleOauthResponse getToken(String code);

    @GetMapping("https://www.googleapis.com/userinfo/v2/me")
    OauthUserInfoResponse getUserInfo(String accessToken);
}
