package com.example.toysrus2_clone.service;

import com.example.toysrus2_clone.dto.LoginRequestDto;
import com.example.toysrus2_clone.dto.SignupRequestDto;
import com.example.toysrus2_clone.model.User;
import com.example.toysrus2_clone.repository.UserRepository;
import com.example.toysrus2_clone.security.UserDetailsImpl;
import com.example.toysrus2_clone.validator.UserValidator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    UserValidator userValidator;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    HttpServletResponse response;


    private String name;
    private String username;
    private String domain;
    private String password;
    private String passwordCheck;
    private String phone;
    private String address;


    @BeforeEach
    void setup() {
        name = "정창길";
        username = "hanghae99";
        domain = "hanghae99.kr";
        password = "test1234!@";
        passwordCheck = "test1234!@";
        phone = "01012341234";
        address = "안드로메다";
    }

    @Nested
    @DisplayName("회원가입")
    @Order(1)
    class 회원가입 {

        @Test
        @DisplayName("회원가입 성공")
        void userRegister() {
            //given
            SignupRequestDto signupRequestDto = new SignupRequestDto(
                    name, username, domain, password, passwordCheck, phone, address
            );

            User user = new User(signupRequestDto);

            userRepository.save(user);


            UserService userService = new UserService(userRepository, passwordEncoder, userValidator);

            //when
            String result = userService.userRegister(signupRequestDto);

            //then
            assertEquals("회원가입 성공", result);
        }
    }

    @Nested
    @DisplayName("로그인")
    @Order(2)
    class 로그인 {

        @Test
        @DisplayName("로그인 성공")
        void login() {
            //given
            SignupRequestDto signupRequestDto = new SignupRequestDto(
                    name, username, domain, password, passwordCheck, phone, address
            );

            User user = new User(signupRequestDto);
            UserService userService = new UserService(userRepository, passwordEncoder, userValidator);

            LoginRequestDto loginRequestDto = new LoginRequestDto(
                    "hanghae99@hanghae99.kr",
                    "test1234!@"
            );

            when(userRepository.findByUsername(user.getUsername()))
                    .thenReturn(Optional.of(user));

            when(passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword()))
                    .thenReturn(true);

            //when
            userService.login(loginRequestDto, response);

            //then
            assertTrue(true);
        }
    }
}