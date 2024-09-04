package springstudy.daangnclone.user.infrastructure.feign.google;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "google-token", url = "https://oauth2.googleapis.com")
public interface GoogleOauthTokenFeignClient {

    @PostMapping("/token")
    GoogleOauthResponse getToken(GoogleOauthTokenRequest request);

}
