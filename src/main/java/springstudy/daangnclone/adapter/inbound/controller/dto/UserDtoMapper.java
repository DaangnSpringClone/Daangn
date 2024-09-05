package springstudy.daangnclone.adapter.inbound.controller.dto;

import springstudy.daangnclone.adapter.inbound.controller.dto.request.UserSaveRequest;
import springstudy.daangnclone.adapter.inbound.controller.dto.request.UserUpdateRequest;
import springstudy.daangnclone.adapter.inbound.controller.dto.response.UserGetResponse;
import springstudy.daangnclone.adapter.inbound.controller.dto.response.UserSaveResponse;
import springstudy.daangnclone.adapter.inbound.controller.dto.response.UserUpdateResponse;
import springstudy.daangnclone.core.domain.User;
import springstudy.daangnclone.core.service.dto.UserDto;

public class UserDtoMapper {
    public static UserDto toServiceDto(UserSaveRequest userSaveRequest) {
        return UserDto.builder()
                .name(userSaveRequest.getName())
                .email(userSaveRequest.getEmail())
                .password(userSaveRequest.getPassword())
                .phoneNumber(userSaveRequest.getPhoneNumber())
                .birthDate(userSaveRequest.getBirthDate())
                .address(userSaveRequest.getAddress())
                .build();
    }

    public static UserDto toServiceDto(UserUpdateRequest userUpdateRequest) {
        return UserDto.builder()
                .id(userUpdateRequest.getId())
                .password(userUpdateRequest.getPassword())
                .phoneNumber(userUpdateRequest.getPhoneNumber())
                .address(userUpdateRequest.getAddress())
                .build();
    }

    public static UserSaveResponse toSaveResponseDto(UserDto userDto) {
        return UserSaveResponse.builder().id(userDto.getId()).build();
    }

    public static UserGetResponse toGetResponseDto(UserDto userDto) {
        return UserGetResponse.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .phoneNumber(userDto.getPhoneNumber())
                .birthDate(userDto.getBirthDate())
                .address(userDto.getAddress())
                .build();
    }

    public static UserUpdateResponse toUpdateResponseDto(UserDto userDto) {
        return UserUpdateResponse.builder()
                .id(userDto.getId())
                .password(userDto.getPassword())
                .phoneNumber(userDto.getPhoneNumber())
                .address(userDto.getAddress())
                .build();
    }
}
