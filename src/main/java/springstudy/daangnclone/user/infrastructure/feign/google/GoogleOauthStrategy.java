package springstudy.daangnclone.user.infrastructure.feign.google;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springstudy.daangnclone.user.infrastructure.feign.OauthStrategy;
import springstudy.daangnclone.user.infrastructure.feign.OauthUserInfoResponse;

@RequiredArgsConstructor
@Component
@Primary
public class GoogleOauthStrategy implements OauthStrategy {

    private final GoogleOauthTokenFeignClient googleOauthTokenFeignClient;
    private final GoogleOauthUserInfoFeignClient googleOauthUserInfoFeignClient;
//    private final GoogleOauthTokenRequest googleOauthTokenRequest;

    @Override
    public OauthUserInfoResponse oauthLongin(String code) {
//        GoogleOauthTokenRequest request = GoogleOauthTokenRequest.builder()
//                .code(code)
//                .clientId(googleOauthTokenRequest.clientId())
//                .clientSecret(googleOauthTokenRequest.clientSecret())
//                .redirectUri(googleOauthTokenRequest.redirectUri())
//                .grantType(googleOauthTokenRequest.grantType())
//                .build();
//        System.out.println("request = " + request.toString());
        GoogleOauthResponse oauthResponse = googleOauthTokenFeignClient.getToken(null);
        return googleOauthUserInfoFeignClient.getUserInfo(oauthResponse.accessToken());
    }

}
