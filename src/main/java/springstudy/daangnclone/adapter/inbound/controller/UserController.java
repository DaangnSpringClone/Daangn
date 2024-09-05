package springstudy.daangnclone.adapter.inbound.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import springstudy.daangnclone.adapter.inbound.controller.dto.UserDtoMapper;
import springstudy.daangnclone.adapter.inbound.controller.dto.request.UserSaveRequest;
import springstudy.daangnclone.adapter.inbound.controller.dto.request.UserUpdateRequest;
import springstudy.daangnclone.adapter.inbound.controller.dto.response.UserGetResponse;
import springstudy.daangnclone.adapter.inbound.controller.dto.response.UserSaveResponse;
import springstudy.daangnclone.adapter.inbound.controller.dto.response.UserUpdateResponse;
import springstudy.daangnclone.adapter.inbound.controller.exception.UserInvalidParamException;
import springstudy.daangnclone.common.ErrorCode;
import springstudy.daangnclone.core.service.UserService;
import springstudy.daangnclone.core.service.dto.UserDto;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserGetResponse> getOne(@PathVariable("id") Integer id) {
        log.debug("Get User! id: {}", id);

        UserDto userDto = userService.getOneById(id);
        UserGetResponse userGetResponse = UserDtoMapper.toGetResponseDto(userDto);

        return ResponseEntity.ok(userGetResponse);
    }

    @PostMapping
    public ResponseEntity<UserSaveResponse> save(@ModelAttribute @Valid UserSaveRequest userSaveRequest, Errors errors) {
        log.debug("Save User! {}", userSaveRequest);

        if (errors.hasErrors()) {
            log.error("Invalid Param... {}", errors.toString());
            throw new UserInvalidParamException("invalid parameter", ErrorCode.INVALID_PARAM);
        }

        UserDto serviceDto = UserDtoMapper.toServiceDto(userSaveRequest);
        UserDto savedDto = userService.save(serviceDto);

        return ResponseEntity.ok(UserDtoMapper.toSaveResponseDto(savedDto));
    }

    @PutMapping
    public ResponseEntity<UserUpdateResponse> update(@RequestBody @Valid UserUpdateRequest userUpdateRequest, Errors errors) {
        log.debug("Update User! {}", userUpdateRequest);

        if (errors.hasErrors()) {
            log.error("Invalid Param... {}", userUpdateRequest);
            throw new UserInvalidParamException("invalid parameter", ErrorCode.INVALID_PARAM);
        }

        UserDto serviceDto = UserDtoMapper.toServiceDto(userUpdateRequest);
        UserDto updatedDto = userService.update(serviceDto);

        return ResponseEntity.ok(UserDtoMapper.toUpdateResponseDto(updatedDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        log.debug("Delete User! id: {}", id);

        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
