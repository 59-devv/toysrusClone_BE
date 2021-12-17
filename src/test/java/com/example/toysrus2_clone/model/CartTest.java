package com.example.toysrus2_clone.model;

import com.example.toysrus2_clone.dto.ItemDto;
import com.example.toysrus2_clone.dto.SignupRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Nested
    @DisplayName("장바구니 정상케이스")
    class 정상케이스 {

        private User user1;
        private Item item1;

        @BeforeEach
        void setup() {
            SignupRequestDto signupRequest = new SignupRequestDto(
                    "정창길",
                    "hanghae99",
                    "hanghae99.kr",
                    "test1234!@",
                    "test1234!@",
                    "01012341234",
                    "스파르타 코딩클럽"
            );

            user1 = new User(signupRequest);


            ItemDto itemDto = new ItemDto(
                    "goodn911",
                    "http://item.ssgcdn.com/62/52/15/item/1000276155262_i1_1200.jpg",
                    "http://www.ssg.com/item/nonSslIframePItemDtlDesc.ssg?itemId=1000018907916",
                    15900L,
                    null
            );
            item1 = new Item(itemDto);


            Long id = 1L;
            User user = user1;
            Item item = item1;
            Long cartCount = 1L;
        }

        @Test
        void 정상케이스() {

            //given
            Long id = 1L;
            User user = user1;
            Item item = item1;
            Long cartCount = 1L;

            //when
            Cart cart = new Cart(user, cartCount, item);

            //then
            assertNull(cart.getId());
            assertEquals(user, cart.getUser());
            assertEquals(item, cart.getItem());
            assertEquals(cartCount, cart.getCartCount());
        }
    }

    @Nested
    @DisplayName("장바구니 실패케이스")
    class 실패케이스 {
        @Nested
        @DisplayName("유저")
        class 유저 {

            private User user1;
            private Item item1;

            @BeforeEach
            void setup() {
                SignupRequestDto signupRequest = new SignupRequestDto(
                        "정창길",
                        "hanghae99",
                        "hanghae99.kr",
                        "test1234!@",
                        "test1234!@",
                        "01012341234",
                        "스파르타 코딩클럽"
                );

                user1 = new User(signupRequest);


                ItemDto itemDto = new ItemDto(
                        "goodn911",
                        "http://item.ssgcdn.com/62/52/15/item/1000276155262_i1_1200.jpg",
                        "http://www.ssg.com/item/nonSslIframePItemDtlDesc.ssg?itemId=1000018907916",
                        15900L,
                        null
                );
                item1 = new Item(itemDto);


                Long id = 1L;
                User user = user1;
                Item item = item1;
                Long cartCount = 1L;
            }

            @Test
            @DisplayName("유저 확인 안됨")
            void 실패케이스1() {
                //given
                Long id = 1L;
                User user = null;
                Item item = item1;
                Long cartCount = 1L;

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                    new Cart(user, cartCount, item);
                });

                //then
                assertEquals("유저가 확인되지 않습니다.", exception.getMessage());
            }
        }

        @Nested
        @DisplayName("상품")
        class 상품 {

            private User user1;
            private Item item1;

            @BeforeEach
            void setup() {
                SignupRequestDto signupRequest = new SignupRequestDto(
                        "정창길",
                        "hanghae99",
                        "hanghae99.kr",
                        "test1234!@",
                        "test1234!@",
                        "01012341234",
                        "스파르타 코딩클럽"
                );

                user1 = new User(signupRequest);


                ItemDto itemDto = new ItemDto(
                        "goodn911",
                        "http://item.ssgcdn.com/62/52/15/item/1000276155262_i1_1200.jpg",
                        "http://www.ssg.com/item/nonSslIframePItemDtlDesc.ssg?itemId=1000018907916",
                        15900L,
                        null
                );
                item1 = new Item(itemDto);


                Long id = 1L;
                User user = user1;
                Item item = item1;
                Long cartCount = 1L;
            }

            @Test
            @DisplayName("상품 확인 안됨")
            void 실패케이스2() {
                //given
                Long id = 1L;
                User user = user1;
                Item item = null;
                Long cartCount = 1L;

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                    new Cart(user, cartCount, item);
                });

                //then
                assertEquals("상품을 선택해주세요.", exception.getMessage());
            }

            @Test
            @DisplayName("상품 0개 담김")
            void 실패케이스3() {
                //given
                Long id = 1L;
                User user = user1;
                Item item = item1;
                Long cartCount = 0L;

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                    new Cart(user, cartCount, item);
                });

                //then
                assertEquals("상품을 1개 이상 담아주세요.", exception.getMessage());
            }

        }
    }
}
