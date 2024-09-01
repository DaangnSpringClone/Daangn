package springstudy.daangnclone.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import springstudy.daangnclone.user.controller.port.UserService;
import springstudy.daangnclone.user.controller.response.UserResponse;
import springstudy.daangnclone.user.domain.UserCreate;

@Controller
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> join(@RequestBody UserCreate userCreate) {
        return ResponseEntity
                .status(HttpStatusCode.valueOf(201))
                .body(UserResponse.from(userService.join(userCreate)));
    }
}
