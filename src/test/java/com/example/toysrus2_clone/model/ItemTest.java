package com.example.toysrus2_clone.model;


import com.example.toysrus2_clone.dto.ItemDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;



class ItemTest {

    @Nested
    @DisplayName("객체생성")
    class creatItem {

        Long id;
        String itemName;
        String thumbnail;
        String imgDetail;
        Long price;
        Long discount;
        String description;
        ShowAreaEnum showAreaEnum;
        Category category;
        Long clickCount;

        @BeforeEach
        void setup() {
            Category category_given = new Category("로봇");

            //GIVEN
            id = 100L;
            itemName = "goodn911";
            thumbnail = "http://item.ssgcdn.com/62/52/15/item/1000276155262_i1_1200.jpg";
            imgDetail = "http://www.ssg.com/item/nonSslIframePItemDtlDesc.ssg?itemId=1000018907916";
            price = 15900L;
            discount = 15L;
            description = " 크리스마스";
            showAreaEnum = ShowAreaEnum.CHRISTMAS;
            category = category_given;
            clickCount = 2L;
        }

        @Test
        @DisplayName("정상 케이스")
        void createItem_Normal() {

            ItemDto itemDto = new ItemDto(
                    itemName,
                    thumbnail,
                    imgDetail,
                    price,
                    category
            );
            Item item = new Item(itemDto);

            assertNull(item.getId());
            assertEquals(itemName, item.getItemName());
            assertEquals(thumbnail, item.getThumbnail());
            assertEquals(imgDetail, item.getImgDetail());
            assertEquals(price, item.getPrice());
            assertEquals(category, item.getCategory());
        }

        @Nested
        @DisplayName("실패 케이스")
        class FailCases {
            @Nested
            @DisplayName("상품명")
            class itemId {
                @Test
                @DisplayName("null")
                void fail1() {
                    // given
                    itemName = null;

                    ItemDto itemDto = new ItemDto(
                            itemName,
                            thumbnail,
                            imgDetail,
                            price,
                            category
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Item(itemDto);
                    });

                    // then
                    assertEquals("저장할 수 있는 상품명이 없습니다.", exception.getMessage());
                }

                @Test
                @DisplayName("빈문자열")
                void fail2() {
                    // given
                    itemName = "";

                    ItemDto itemDto = new ItemDto(
                            itemName,
                            thumbnail,
                            imgDetail,
                            price,
                            category
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Item(itemDto);
                    });

                    // then
                    assertEquals("저장할 수 있는 상품명이 없습니다.", exception.getMessage());
                }

                @Test
                @DisplayName("공백")
                void fail3() {
                    // given
                    itemName = " ";

                    ItemDto itemDto = new ItemDto(
                            itemName,
                            thumbnail,
                            imgDetail,
                            price,
                            category
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Item(itemDto);
                    });

                    // then
                    assertEquals("저장할 수 있는 상품명이 없습니다.", exception.getMessage());
                }

            }

            @Nested
            @DisplayName("상품url")
            class 썸네일 {
                @Test
                @DisplayName("null")
                void fail1() {
                    // given
                    thumbnail = null;

                    ItemDto itemDto = new ItemDto(
                            itemName,
                            thumbnail,
                            imgDetail,
                            price,
                            category
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Item(itemDto);
                    });

                    // then
                    assertEquals("상품 이미지 URL 포맷이 맞지 않습니다.", exception.getMessage());
                }

                @Test
                @DisplayName("url 포맷 형태 맞지 않음")
                void fail2() {
                    // given
                    thumbnail = "shopping-phinf.pstatic.net/main_2416122/24161228524.20200915151118.jpg";

                    ItemDto itemDto = new ItemDto(
                            itemName,
                            thumbnail,
                            imgDetail,
                            price,
                            category
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Item(itemDto);
                    });

                    // then
                    assertEquals("상품 이미지 URL 포맷이 맞지 않습니다.", exception.getMessage());
                }


                }
            @Nested
            @DisplayName("상세페이지 url")
            class 상세페이지이미지 {
                @Test
                @DisplayName("null")
                void fail1() {
                    // given
                    imgDetail = null;

                    ItemDto itemDto = new ItemDto(
                            itemName,
                            thumbnail,
                            imgDetail,
                            price,
                            category
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Item(itemDto);
                    });

                    // then
                    assertEquals("상세페이지 이미지 URL 포맷이 맞지 않습니다.", exception.getMessage());
                }

                @Test
                @DisplayName("url 포맷 형태 맞지 않음")
                void fail2() {
                    // given
                    imgDetail = "shopping-phinf.pstatic.net/main_2416122/24161228524.20200915151118.jpg";

                    ItemDto itemDto = new ItemDto(
                            itemName,
                            thumbnail,
                            imgDetail,
                            price,
                            category
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Item(itemDto);
                    });

                    // then
                    assertEquals("상세페이지 이미지 URL 포맷이 맞지 않습니다.", exception.getMessage());
                }
            }

            @Nested
            @DisplayName("가격")
            class 가격 {
                @Test
                @DisplayName("0")
                void fail1() {
                    // given
                    price = 0L;

                    ItemDto itemDto = new ItemDto(
                            itemName,
                            thumbnail,
                            imgDetail,
                            price,
                            category
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Item(itemDto);
                    });

                    // then
                    assertEquals("상품 가격이 0 이하입니다.", exception.getMessage());
                }

                @Test
                @DisplayName("음수")
                void fail2() {
                    // given
                    price = -14L;

                    ItemDto itemDto = new ItemDto(
                            itemName,
                            thumbnail,
                            imgDetail,
                            price,
                            category
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Item(itemDto);
                    });

                    // then
                    assertEquals("상품 가격이 0 이하입니다.", exception.getMessage());
                }
            }
            @Nested
            @DisplayName("카테고리")
            class 카테고리 {
                @Test
                @DisplayName("null")
                void fail1() {
                    // given
                    category = null;

                    ItemDto itemDto = new ItemDto(
                            itemName,
                            thumbnail,
                            imgDetail,
                            price,
                            category
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Item(itemDto);
                    });

                    // then
                    assertEquals("저장할 수 있는 카테고리명이 없습니다.", exception.getMessage());
                }

                @Test
                @DisplayName("공백")
                void fail2() {
                    // given
                    Category category_given = new Category(" ");
                    category = category_given;

                    ItemDto itemDto = new ItemDto(
                            itemName,
                            thumbnail,
                            imgDetail,
                            price,
                            category
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Item(itemDto);
                    });

                    // then
                    assertEquals("저장할 수 있는 카테고리명이 없습니다.", exception.getMessage());
                }
            }
            @Nested
            @DisplayName("조회수")
            class description {
                @Test
                @DisplayName("음수")
                void fail1() {
                    // given
                    clickCount = -1L;


                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Item(
                                id,
                                itemName,
                                thumbnail,
                                imgDetail,
                                price,
                                discount,
                                description,
                                showAreaEnum,
                                category,
                                clickCount
                        );
                    });

                    // then
                    assertEquals("조회수가 0 미만입니다.", exception.getMessage());
                }

            }
            @Nested
            @DisplayName("할인")
            class 할인 {
                @Test
                @DisplayName("음수")
                void fail1() {
                    // given
                    discount = -1L;


                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Item(
                                id,
                                itemName,
                                thumbnail,
                                imgDetail,
                                price,
                                discount,
                                description,
                                showAreaEnum,
                                category,
                                clickCount
                        );
                    });

                    // then
                    assertEquals("할인율이 0 미만입니다.", exception.getMessage());
                }

            }

        }


    }

}




