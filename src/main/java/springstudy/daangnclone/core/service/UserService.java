package springstudy.daangnclone.core.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import springstudy.daangnclone.common.ErrorCode;
import springstudy.daangnclone.core.domain.User;
import springstudy.daangnclone.core.port.UserRepository;
import springstudy.daangnclone.core.service.dto.UserDto;
import springstudy.daangnclone.core.service.dto.UserServiceDtoMapper;
import springstudy.daangnclone.core.service.exception.UserExistsEmailException;
import springstudy.daangnclone.core.service.exception.UserExistsPhoneNumberException;
import springstudy.daangnclone.core.service.exception.UserNotExistsException;

import java.util.Optional;

@Slf4j
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDto save(UserDto userDto) throws RuntimeException {
        checkAlreadyExists(userDto);

        User user = UserServiceDtoMapper.toEntity(userDto);
        User savedUser = userRepository.save(user);

        return UserServiceDtoMapper.toDto(savedUser);
    }

    public UserDto getOneById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotExistsException("not exist user", ErrorCode.NOT_EXIST_USER)
        );
        return UserServiceDtoMapper.toDto(user);
    }

    @Transactional
    public UserDto update(UserDto userDto) {
        Integer id = userDto.getId();

        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotExistsException("not exist user", ErrorCode.NOT_EXIST_USER)
        );

        if (userRepository.existsByPhoneNumber(userDto.getPhoneNumber())) {
            throw new UserExistsPhoneNumberException("already exists phone number", ErrorCode.ALREADY_EXISTS_PHONE_NUMBER);
        }

        if (null != userDto.getPassword()) {
            user.updatePassword(userDto.getPassword());
        }

        if (null != userDto.getPhoneNumber()) {
            user.updatePhoneNumber(userDto.getPhoneNumber());
        }

        if (null != userDto.getAddress()) {
            user.updateAddress(user.getAddress());
        }

        return UserServiceDtoMapper.toDto(user);
    }

    public void delete(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotExistsException("not exist user", ErrorCode.NOT_EXIST_USER);
        }

        userRepository.deleteById(id);
    }

    private void checkAlreadyExists(UserDto userDto) throws RuntimeException {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new UserExistsEmailException("already exists email", ErrorCode.ALREADY_EXISTS_EMAIL);
        }

        if (userRepository.existsByPhoneNumber(userDto.getPhoneNumber())) {
            throw new UserExistsPhoneNumberException("already exists phone number", ErrorCode.ALREADY_EXISTS_PHONE_NUMBER);
        }
    }
}
