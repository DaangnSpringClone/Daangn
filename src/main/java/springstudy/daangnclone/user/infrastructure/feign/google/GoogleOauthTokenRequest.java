package springstudy.daangnclone.user.infrastructure.feign.google;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Builder
public record GoogleOauthTokenRequest(
        String code,
        @Value("${spring.oauth2.google.client-id}")
        String clientId,
        @Value("${spring.oauth2.google.client-secret}")
        String clientSecret,
        @Value("${spring.oauth2.google.redirect-uri}")
        String redirectUri,
        @Value("${spring.oauth2.google.grant-type}")
        String grantType
) {
}
