package com.example.toysrus2_clone.model;

import com.example.toysrus2_clone.dto.SignupRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserTest {

    private Long userId;
    private String name;
    private String username;
    private String domain;
    private String password;
    private String passwordCheck;
    private String phone;
    private String address;

    @BeforeEach
    void setup() {
        userId = 1L;
        name = "정창길";
        username = "hanghae99";
        domain = "hanghae99.kr";
        password = "test1234!@";
        passwordCheck = "test1234!@";
        phone = "01012341234";
        address = "스파르타 코딩클럽";

        SignupRequestDto signupRequest = new SignupRequestDto (
                name, username, domain, password, passwordCheck, phone, address
        );
    }

    @Nested
    @DisplayName("유저 정상케이스")
    class 정상케이스 {

        @Test
        void 정상() {
            //given
            SignupRequestDto signupRequest = new SignupRequestDto (
                    name, username, domain, password, passwordCheck, phone, address
            );

            //when
            User user = new User(signupRequest);

            //then
            assertNull(user.getId());
            assertEquals(name, user.getName());
            assertEquals(username + "@" + domain, user.getUsername());
            assertEquals(password, user.getPassword());
            assertEquals(phone, user.getPhone());
            assertEquals(address, user.getAddress());
        }
    }


    @Nested
    @DisplayName("유저 실패케이스")
    class 실패케이스 {
        @Nested
        @DisplayName("이름")
        class 이름 {
            @Test
            @DisplayName("이름 빈문자열")
            void 실패케이스1() {
                //given
                name = "";

                SignupRequestDto signupRequest = new SignupRequestDto (
                        name, username, domain, password, passwordCheck, phone, address
                );

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
                    new User(signupRequest);
                });

                //then
                assertEquals("이름은 필수 입력 값 입니다.", exception.getMessage());
            }
        }

        @Nested
        @DisplayName("이메일")
        class 이메일 {
            @Test
            @DisplayName("이메일 아이디 빈문자열")
            void 실패케이스2() {
                //given
                username = "";

                SignupRequestDto signupRequest = new SignupRequestDto (
                        name, username, domain, password, passwordCheck, phone, address
                );

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
                    new User(signupRequest);
                });

                //then
                assertEquals("아이디는 필수 입력 값 입니다.", exception.getMessage());
            }

            @Test
            @DisplayName("이메일 아이디 3자 미만")
            void 실패케이스3() {
                //given
                username = "ha";

                SignupRequestDto signupRequest = new SignupRequestDto (
                        name, username, domain, password, passwordCheck, phone, address
                );

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
                    new User(signupRequest);
                });

                //then
                assertEquals("아이디는 소문자,숫자로 이루어진 3~12자여야 합니다.", exception.getMessage());
            }

            @Test
            @DisplayName("이메일 도메인 빈문자열")
            void 실패케이스4() {
                //given
                domain = "";

                SignupRequestDto signupRequest = new SignupRequestDto (
                        name, username, domain, password, passwordCheck, phone, address
                );

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
                    new User(signupRequest);
                });

                //then
                assertEquals("이메일은 필수 입력 값 입니다.", exception.getMessage());
            }
        }

        @Nested
        @DisplayName("비밀번호")
        class 비밀번호 {
            @Test
            @DisplayName("비밀번호 빈문자열")
            void 실패케이스5() {
                //given
                password = "";

                SignupRequestDto signupRequest = new SignupRequestDto (
                        name, username, domain, password, passwordCheck, phone, address
                );

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
                    new User(signupRequest);
                });

                //then
                assertEquals("비밀번호는 필수 입력 값 입니다.", exception.getMessage());
            }

            @Test
            @DisplayName("비밀번호 8자 미만")
            void 실패케이스6() {
                //given
                password = "test!@";
                passwordCheck = "test!@";

                SignupRequestDto signupRequest = new SignupRequestDto (
                        name, username, domain, password, passwordCheck, phone, address
                );

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
                    new User(signupRequest);
                });

                //then
                assertEquals("비밀번호는 8자~15자로 영문, 숫자, 특수문자를 포함해야 합니다.", exception.getMessage());
            }

            @Test
            @DisplayName("비밀번호 15자 이상")
            void 실패케이스7() {
                //given
                password = "test1234567890!@";
                passwordCheck = "test1234567890!@";

                SignupRequestDto signupRequest = new SignupRequestDto (
                        name, username, domain, password, passwordCheck, phone, address
                );

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
                    new User(signupRequest);
                });

                //then
                assertEquals("비밀번호는 8자~15자로 영문, 숫자, 특수문자를 포함해야 합니다.", exception.getMessage());
            }

            @Test
            @DisplayName("비밀번호 특수문자없음")
            void 실패케이스8() {
                //given
                password = "test1234";
                passwordCheck = "test1234";

                SignupRequestDto signupRequest = new SignupRequestDto (
                        name, username, domain, password, passwordCheck, phone, address
                );

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
                    new User(signupRequest);
                });

                //then
                assertEquals("비밀번호는 8자~15자로 영문, 숫자, 특수문자를 포함해야 합니다.", exception.getMessage());
            }

            @Test
            @DisplayName("비밀번호 공백")
            void 실패케이스12() {
                //given
                password = "test1234 ";
                passwordCheck = "test1234 ";

                SignupRequestDto signupRequest = new SignupRequestDto (
                        name, username, domain, password, passwordCheck, phone, address
                );

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
                    new User(signupRequest);
                });

                //then
                assertEquals("비밀번호는 공백을 포함할 수 없습니다.", exception.getMessage());
            }
        }

        @Nested
        @DisplayName("휴대폰번호")
        class 휴대폰번호 {
            @Test
            @DisplayName("휴대폰번호 빈문자열")
            void 실패케이스9() {
                //given
                phone = "";

                SignupRequestDto signupRequest = new SignupRequestDto (
                        name, username, domain, password, passwordCheck, phone, address
                );

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
                    new User(signupRequest);
                });

                //then
                assertEquals("핸드폰번호는 필수 입력 값 입니다.", exception.getMessage());
            }

            @Test
            @DisplayName("휴대폰번호 숫자만 입력하지 않음")
            void 실패케이스10() {
                //given
                phone = "010-1234-1234";

                SignupRequestDto signupRequest = new SignupRequestDto (
                        name, username, domain, password, passwordCheck, phone, address
                );

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
                    new User(signupRequest);
                });

                //then
                assertEquals("핸드폰번호는 숫자만 입력 가능합니다.", exception.getMessage());
            }
        }

        @Nested
        @DisplayName("주소")
        class 주소 {
            @Test
            @DisplayName("주소 빈문자열")
            void 실패케이스11() {
                //given
                address = "           ";

                SignupRequestDto signupRequest = new SignupRequestDto (
                        name, username, domain, password, passwordCheck, phone, address
                );

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
                    new User(signupRequest);
                });

                //then
                assertEquals("주소는 필수 입력 값 입니다.", exception.getMessage());
            }
        }
    }
}