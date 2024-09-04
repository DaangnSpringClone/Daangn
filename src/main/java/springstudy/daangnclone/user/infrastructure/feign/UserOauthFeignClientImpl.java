package springstudy.daangnclone.user.infrastructure.feign;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import springstudy.daangnclone.user.service.port.UserOauthFeignClient;

@Component
@Setter
public class UserOauthFeignClientImpl implements UserOauthFeignClient {

    private OauthStrategy oauthStrategy;

    public UserOauthFeignClientImpl(@Qualifier("googleOauthStrategy") OauthStrategy oauthStrategy) {
        this.oauthStrategy = oauthStrategy;
    }

    @Override
    public OauthUserInfoResponse oauthLogin(String code) {
        return oauthStrategy.oauthLongin(code);
    }
}
