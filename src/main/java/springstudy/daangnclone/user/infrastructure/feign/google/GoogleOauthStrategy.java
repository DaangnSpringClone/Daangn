package springstudy.daangnclone.user.infrastructure.feign.google;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import springstudy.daangnclone.user.infrastructure.feign.OauthStrategy;
import springstudy.daangnclone.user.infrastructure.feign.OauthUserInfoResponse;

@RequiredArgsConstructor
@Repository
public class GoogleOauthStrategy implements OauthStrategy {

    private final GoogleOauthFeignClient googleOauthFeignClient;

    @Override
    public OauthUserInfoResponse oauthLongin(String code) {
        GoogleOauthResponse oauthResponse = googleOauthFeignClient.getToken(code);
        return googleOauthFeignClient.getUserInfo(oauthResponse.accessToken());
    }

}
