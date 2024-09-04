package springstudy.daangnclone.user.infrastructure.feign.kakao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springstudy.daangnclone.user.infrastructure.feign.OauthUserInfoResponse;
import springstudy.daangnclone.user.infrastructure.feign.google.GoogleOauthResponse;

@FeignClient(name = "kakao")
public interface KakaoOauthFeignClient {

    //FIXME : fix everything
    @PostMapping("https://oauth2.googleapis.com/token")
    GoogleOauthResponse getToken(String code);

    //FIXME : fix everything
    @GetMapping("https://www.googleapis.com/userinfo/v2/me")
    OauthUserInfoResponse getUserInfo(String accessToken);
}
