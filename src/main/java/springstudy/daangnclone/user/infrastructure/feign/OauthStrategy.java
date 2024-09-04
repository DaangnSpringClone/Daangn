package springstudy.daangnclone.user.infrastructure.feign;

public interface OauthStrategy {

    OauthUserInfoResponse oauthLongin(String code);
}
