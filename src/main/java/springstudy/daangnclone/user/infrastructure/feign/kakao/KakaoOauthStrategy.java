package springstudy.daangnclone.user.infrastructure.feign.kakao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import springstudy.daangnclone.user.infrastructure.feign.OauthStrategy;
import springstudy.daangnclone.user.infrastructure.feign.OauthUserInfoResponse;
import springstudy.daangnclone.user.infrastructure.feign.google.GoogleOauthResponse;

@RequiredArgsConstructor
@Repository
public class KakaoOauthStrategy implements OauthStrategy {

    private final KakaoOauthFeignClient kakaoOauthFeignClient;

    //FIXME : fix everything
    @Override
    public OauthUserInfoResponse oauthLongin(String code) {
        GoogleOauthResponse oauthResponse = kakaoOauthFeignClient.getToken(code);
        return kakaoOauthFeignClient.getUserInfo(oauthResponse.accessToken());
    }

}
