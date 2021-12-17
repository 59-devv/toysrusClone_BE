package com.example.toysrus2_clone.model;

import com.example.toysrus2_clone.dto.ItemDto;
import com.example.toysrus2_clone.dto.SignupRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    private User user1;
    private Item item1;
    private Category category1;
    private Long id;
    private Long cartCount;

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
        category1 = new Category("크리스마스");

        ItemDto itemDto = new ItemDto(
                "goodn911",
                "http://item.ssgcdn.com/62/52/15/item/1000276155262_i1_1200.jpg",
                "http://www.ssg.com/item/nonSslIframePItemDtlDesc.ssg?itemId=1000018907916",
                15900L,
                category1
                );
        item1 = new Item(itemDto);


        id = 1L;
        cartCount = 1L;
    }

    @Nested
    @DisplayName("장바구니 정상케이스")
    class 정상케이스 {

        @Test
        void 정상케이스() {

            //given

            //when
            Cart cart = new Cart(user1, cartCount, item1);

            //then
            assertNull(cart.getId());
            assertEquals(user1, cart.getUser());
            assertEquals(item1, cart.getItem());
            assertEquals(cartCount, cart.getCartCount());
        }
    }

    @Nested
    @DisplayName("장바구니 실패케이스")
    class 실패케이스 {
        @Nested
        @DisplayName("유저")
        class 유저 {

            @Test
            @DisplayName("유저 확인 안됨")
            void 실패케이스1() {
                //given
                user1 = null;

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                    new Cart(user1, cartCount, item1);
                });

                //then
                assertEquals("유저가 확인되지 않습니다.", exception.getMessage());
            }
        }

        @Nested
        @DisplayName("상품")
        class 상품 {

            @Test
            @DisplayName("상품 확인 안됨")
            void 실패케이스2() {
                //given
                item1 = null;

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                    new Cart(user1, cartCount, item1);
                });

                //then
                assertEquals("상품을 선택해주세요.", exception.getMessage());
            }

            @Test
            @DisplayName("상품 0개 이하로 담김")
            void 실패케이스3() {
                //given
                cartCount = -10L;

                //when
                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                    new Cart(user1, cartCount, item1);
                });

                //then
                assertEquals("상품을 1개 이상 담아주세요.", exception.getMessage());
            }

        }
    }
}
