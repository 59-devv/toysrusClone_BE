package com.example.toysrus2_clone.integration;

import com.example.toysrus2_clone.dto.ItemDetailDto;
import com.example.toysrus2_clone.dto.ItemDto;
import com.example.toysrus2_clone.dto.MainResponseDto;
import com.example.toysrus2_clone.model.Category;
import com.example.toysrus2_clone.model.Item;
import com.example.toysrus2_clone.model.ShowAreaEnum;
import com.example.toysrus2_clone.repository.CategoryRepository;
import com.example.toysrus2_clone.repository.ItemRepository;
import com.example.toysrus2_clone.service.ItemService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemIntegrationTest {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemService itemService;
    @Autowired
    CategoryRepository categoryRepository;


    @Nested
    @DisplayName("상품 통합테스트")
    class 상품_통합테스트 {

        @Test
        @Order(1)
        @DisplayName("상품 생성")
        void addItem() {
            //given
            List<ItemDto> itemDtoList = new ArrayList<>();
            ItemDto itemDto = new ItemDto(
                    "뽀로로",
                    "https://ppororo.co.kr/ppororo.jpg",
                    "https://ppororo.co.kr/ppororo.jpg",
                    1051035151L,
                    new Category("만화영화")
            );
            ItemDto itemDto2 = new ItemDto(
                    "뽀로로2",
                    "https://ppororo.co.kr/ppororo2.jpg",
                    "https://ppororo.co.kr/ppororo2.jpg",
                    1051035151L,
                    new Category("만화영화")
            );
            itemDtoList.add(itemDto);
            itemDtoList.add(itemDto2);

            //when - then
            itemService.addItem(itemDtoList);
        }

        @Test
        @Order(2)
        @DisplayName("상품 상세 조회")
        void showDetail() {
            //given
            List<Item> itemList = itemRepository.findAllByShowAreaEnum(ShowAreaEnum.CHRISTMAS);
            Long itemId = itemList.get(0).getId();

            //when
            ItemDetailDto detail = itemService.getDetail(itemId);

            //then
            assertEquals(detail.getItemName(), itemList.get(0).getItemName());
        }

        @Test
        @Order(3)
        @DisplayName("상품 전체 조회")
        void showAllItems() {
            //given
            int page = 1;
            int size = 10;

            //when
            MainResponseDto mainItems = itemService.getMainItems(page, size);

            //then
            assertNotNull(mainItems);
        }
    }
}