package springstudy.daangnclone.user.infrastructure.feign.google;

public record GoogleOauthResponse(
        String accessToken,
        long expiresIn,
        String scope,
        String tokenType,
        String idToken
) {
}
