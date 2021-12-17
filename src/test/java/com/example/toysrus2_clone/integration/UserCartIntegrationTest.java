package com.example.toysrus2_clone.integration;

import com.example.toysrus2_clone.dto.CartDto;
import com.example.toysrus2_clone.dto.CartResponseDto;
import com.example.toysrus2_clone.dto.LoginRequestDto;
import com.example.toysrus2_clone.dto.SignupRequestDto;
import com.example.toysrus2_clone.model.User;
import com.example.toysrus2_clone.repository.CartRepository;
import com.example.toysrus2_clone.repository.UserRepository;
import com.example.toysrus2_clone.security.UserDetailsImpl;
import com.example.toysrus2_clone.service.CartService;
import com.example.toysrus2_clone.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserCartIntegrationTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartService cartService;
    @Autowired
    CartRepository cartRepository;

    User loginUser;
    UserDetailsImpl loginUserDetails;

    MockHttpServletResponse res = new MockHttpServletResponse();

    @Nested
    @DisplayName("통합테스트")
    class 통합테스트 {

        @BeforeEach
        void setup() {
            loginUserDetails = new UserDetailsImpl(userRepository.findByUsername("hanghae99@hanghae99.kr").get());
        }

        @Test
        @Order(1)
        @DisplayName("회원가입 실패 - 중복 이메일")
        void signup() {
            //given
            String name = "정창길";
            String username = "hanghae99";
            String domain = "hanghae99.kr";
            String password = "test1234!@";
            String passwordCheck = "test1234!@";
            String phone = "01012341234";
            String address = "스파르타 코딩클럽";

            SignupRequestDto signupRequest = new SignupRequestDto(
                    name, username, domain, password, passwordCheck, phone, address
            );

            //when
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                userService.userRegister(signupRequest);
            });
            //then
            assertEquals("중복된 이메일이 존재합니다.", exception.getMessage());
        }

        @Test
        @Order(2)
        @DisplayName("회원가입 성공")
        void signup2() {
            //given
            String name = "정창길";
            String username = "hanghae999";
            String domain = "hanghae99.kr";
            String password = "test1234!@";
            String passwordCheck = "test1234!@";
            String phone = "01012341234";
            String address = "스파르타 코딩클럽";

            SignupRequestDto signupRequest = new SignupRequestDto(
                    name, username, domain, password, passwordCheck, phone, address
            );

            //when
            String result = userService.userRegister(signupRequest);

            //then
            assertEquals("회원가입 성공", result);
        }


        @Test
        @Order(3)
        @DisplayName("로그인 실패 - 비번잘못")
        void loginFail() {
            //given
            String username = "hanghae99@hanghae99.kr";
            String password = "test1234!@";

            LoginRequestDto loginRequestDto = new LoginRequestDto(
                    username,
                    password
            );

            //when
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                userService.login(loginRequestDto, res);
            });
            //then
            assertEquals("비밀번호를 확인해주세요.", exception.getMessage());
        }

        @Test
        @Order(4)
        @DisplayName("로그인 성공")
        void loginSuccess() {
            //given
            String username = "hanghae99@hanghae99.kr";
            String password = "test1234";

            LoginRequestDto loginRequestDto = new LoginRequestDto(
                    username,
                    password
            );

            //when
            userService.login(loginRequestDto, res);

            //then
            assertNotNull(res.getHeader("Authorization"));


        }

        @Test
        @Order(5)
        @DisplayName("장바구니에 상품 담기")
        void saveToCart() {
            //given
            CartDto cartDto = new CartDto(1L, 5L);

            //when
            cartService.cartSave(loginUserDetails, cartDto);

            //then
            assertNotNull(cartRepository.findAllByUserId(loginUserDetails.getUser().getId()));
        }

        @Test
        @Order(6)
        @DisplayName("장바구니에서 상품 조회")
        void showCartItems() {
            //given

            //when
            CartResponseDto cartItems = cartService.getCart(loginUserDetails);

            //then
            assertEquals(loginUserDetails.getUser().getId(), cartItems.getUserInfo().getUserId());
        }
    }
}
