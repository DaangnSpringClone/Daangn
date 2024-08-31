package springstudy.daangnclone.adapter.inbound.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import springstudy.daangnclone.adapter.inbound.controller.dto.request.UserUpdateRequest;
import springstudy.daangnclone.core.service.UserService;
import springstudy.daangnclone.core.service.dto.UserDto;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
@ExtendWith(SpringExtension.class)
@WebMvcTest
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private UserService userService;

    @Test
    @DisplayName("User 1개 얻어오기 - 성공")
    void getOne() throws Exception {
        // given
        Integer id = 1;

        String name = "name1";
        String email = "test@email.com";
        String password = "password1";
        String phoneNumber = "01012341234";
        LocalDate birthDate = LocalDate.of(2024, 8, 31);
        String address = "경기도 과천시";

        UserDto userDto = UserDto.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .birthDate(birthDate)
                .address(address)
                .build();

        when(userService.getOneById(any(Integer.class))).thenReturn(userDto);

        // when & then
        mockMvc.perform(get("/user/" + id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.email").value(email))
                .andExpect(jsonPath("$.password").value(password))
                .andExpect(jsonPath("$.phoneNumber").value(phoneNumber))
                .andExpect(jsonPath("$.birthDate").value("2024-08-31"))
                .andExpect(jsonPath("$.address").value(address))
        ;
    }

    @Test
    @DisplayName("User 저장하기 - 성공")
    void save() throws Exception {
        // given
        Integer id = 1;
        String name = "name1";
        String email = "test@email.com";
        String password = "password1";
        String phoneNumber = "01012341234";
        LocalDate birthDate = LocalDate.of(2024, 8, 31);
        String address = "경기도 과천시";

        UserDto userDto = UserDto.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .birthDate(birthDate)
                .address(address)
                .build();

        when(userService.save(any(UserDto.class))).thenReturn(userDto);

        // when & then
        mockMvc.perform(
                post("/user")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", name)
                .param("email", email)
                .param("password", password)
                .param("phoneNumber", phoneNumber)
                .param("birthDate", "2024-08-31")
                .param("address", address)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id));
    }

    @Test
    @DisplayName("User 저장 - Invalid Parameter")
    public void save_InvalidParam() throws Exception {
        // given
        Integer id = 1;
        String name = "name1";
        String email = "test$email.com";
        String password = "password1";
        String phoneNumber = "010-1234-1234";
        LocalDate birthDate = LocalDate.of(2024, 8, 31);
        String address = "경기도 과천시";

        UserDto userDto = UserDto.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .birthDate(birthDate)
                .address(address)
                .build();

        when(userService.save(any(UserDto.class))).thenReturn(userDto);

        // when & then
        mockMvc.perform(
                        post("/user")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("name", name)
                                .param("email", email)
                                .param("password", password)
                                .param("phoneNumber", phoneNumber)
                                .param("birthDate", "2024-08-31")
                                .param("address", address)
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode").value("COMMON-ERR-400"))
                .andExpect(jsonPath("$.message").value("INVALID PARAMETER"));

        // given
        userDto.setEmail("test@email.com");
        userDto.setPassword("010^123412333");
        // when & then
        mockMvc.perform(
                        post("/user")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("name", name)
                                .param("email", email)
                                .param("password", password)
                                .param("phoneNumber", phoneNumber)
                                .param("birthDate", "2024-08-31")
                                .param("address", address)
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode").value("COMMON-ERR-400"))
                .andExpect(jsonPath("$.message").value("INVALID PARAMETER"));
    }
    
    @Test
    @DisplayName("User 업데이트 - 성공")
    public void update() throws Exception {
        // given
        Integer id = 1;
        String phoneNumber = "010-2345-9999";

        UserUpdateRequest userUpdateRequest = UserUpdateRequest.builder()
                .id(id)
                .phoneNumber(phoneNumber)
                .build();

        UserDto userDto = UserDto.builder()
                .id(id)
                .phoneNumber(phoneNumber)
                .build();

        when(userService.update(any(UserDto.class))).thenReturn(userDto);

        // when & then
        mockMvc.perform(put("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userUpdateRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.phoneNumber").value(phoneNumber));
    }
}