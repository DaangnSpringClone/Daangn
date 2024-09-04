package springstudy.daangnclone.user.infrastructure.feign;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import springstudy.daangnclone.user.service.port.UserOauthFeignClient;

@Component
@AllArgsConstructor
public class UserOauthFeignClientImpl implements UserOauthFeignClient {

    private OauthStrategy oauthStrategy;

    @Override
    public OauthUserInfoResponse oauthLogin(String code) {
        return oauthStrategy.oauthLongin(code);
    }

    @Override
    public void setOauthStrategy(OauthStrategy oauthStrategy) {
        this.oauthStrategy = oauthStrategy;
    }
}
