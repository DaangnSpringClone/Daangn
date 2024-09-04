package springstudy.daangnclone.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springstudy.daangnclone.user.controller.port.UserOauthService;
import springstudy.daangnclone.user.infrastructure.feign.OauthUserInfoResponse;
import springstudy.daangnclone.user.service.port.UserOauthFeignClient;

@Service
@RequiredArgsConstructor
public class UserOauthServiceImpl implements UserOauthService {

    private final UserOauthFeignClient userOauthFeignClient;

    @Override
    public OauthUserInfoResponse snsLogin(String code) {
        // FIXME : Response 바꿔야 함. 임시로 처리(순환참조 발생 가능)
        //받은 code로 oauth 조회
        return userOauthFeignClient.oauthLogin(code);
    }

}
