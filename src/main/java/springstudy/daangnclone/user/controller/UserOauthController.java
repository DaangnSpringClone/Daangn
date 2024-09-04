package springstudy.daangnclone.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springstudy.daangnclone.user.controller.port.UserOauthService;
import springstudy.daangnclone.user.infrastructure.feign.OauthUserInfoResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/oauth")
public class UserOauthController {

    private final UserOauthService userOauthService;

    @GetMapping("/login")
    public OauthUserInfoResponse oauthLogin(@RequestParam String code) {
        return userOauthService.snsLogin(code);
    }

}
