package springstudy.daangnclone.user.infrastructure.feign;

public record OauthUserInfoResponse(
        String id,
        String email,
        boolean verifiedEmail,
        String name,
        String givenName,
        String familyName,
        String picture
) {
}
