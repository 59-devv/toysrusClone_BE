package com.example.toysrus2_clone.service;

import com.example.toysrus2_clone.dto.ItemDetailDto;
import com.example.toysrus2_clone.dto.MainResponseDto;
import com.example.toysrus2_clone.model.Category;
import com.example.toysrus2_clone.model.Item;
import com.example.toysrus2_clone.model.ShowAreaEnum;
import com.example.toysrus2_clone.repository.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    ItemRepository itemRepository;

    @Mock
    Pageable pageable;

    Item item1 = new Item(
            1L,
            "피카츄",
            "http://naver.com/pikachu.jpg",
            "http://naver.com/pikachuDetail.jpg",
            11L,
            10L,
            "피카츄인형!",
            ShowAreaEnum.RECOMMEND,
            new Category("추천"),
            1L
    );

    Item item2 = new Item(
            2L,
            "피카츄2",
            "http://naver.com/pikachu2.jpg",
            "http://naver.com/pikachuDetail2.jpg",
            12L,
            10L,
            "피카츄인형!",
            ShowAreaEnum.RECOMMEND,
            new Category("추천"),
            1L
    );

    Item item3 = new Item(
            3L,
            "피카츄3",
            "http://naver.com/pikachu3.jpg",
            "http://naver.com/pikachuDetail3.jpg",
            13L,
            10L,
            "피카츄인형!",
            ShowAreaEnum.CHRISTMAS,
            new Category("크리스마스"),
            1L
    );

    Item item4 = new Item(
            4L,
            "피카츄4",
            "http://naver.com/pikachu4.jpg",
            "http://naver.com/pikachuDetail4.jpg",
            14L,
            10L,
            "피카츄인형!",
            ShowAreaEnum.CHRISTMAS,
            new Category("크리스마스"),
            1L
    );

    Item item5 = new Item(
            5L,
            "피카츄5",
            "http://naver.com/pikachu5.jpg",
            "http://naver.com/pikachuDetail5.jpg",
            15L,
            10L,
            "피카츄인형!",
            ShowAreaEnum.TIMEDEAL,
            new Category("타임딜"),
            1L
    );

    Item item6 = new Item(
            6L,
            "피카츄6",
            "http://naver.com/pikachu6.jpg",
            "http://naver.com/pikachuDetail6.jpg",
            16L,
            10L,
            "피카츄인형!",
            ShowAreaEnum.TIMEDEAL,
            new Category("타임딜"),
            1L
    );

    Item item7 = new Item(
            7L,
            "피카츄7",
            "http://naver.com/pikachu7.jpg",
            "http://naver.com/pikachuDetail7.jpg",
            17L,
            10L,
            "피카츄인형!",
            ShowAreaEnum.HOTDEAL,
            new Category("핫딜"),
            1L
    );

    Item item8 = new Item(
            8L,
            "피카츄8",
            "http://naver.com/pikachu8.jpg",
            "http://naver.com/pikachuDetail8.jpg",
            18L,
            10L,
            "피카츄인형!",
            ShowAreaEnum.HOTDEAL,
            new Category("핫딜"),
            1L
    );


    @Nested
    @DisplayName("상품상세정보")
    @Order(1)
    class 상품상세정보 {

        @Test
        @DisplayName("상품상세정보 불러오기")
        void getDetail() {
            //given
            ItemService itemService = new ItemService(itemRepository);

            when(itemRepository.findById(item1.getId()))
                    .thenReturn(Optional.of(item1));

            //when
            ItemDetailDto itemDetail = itemService.getDetail(item1.getId());

            //then
            assertEquals(itemDetail.getItemId(), item1.getId());
            assertEquals(itemDetail.getItemName(), item1.getItemName());
            assertEquals(itemDetail.getPrice(), item1.getPrice());
            assertEquals(itemDetail.getDiscount(), item1.getDiscount());
            assertEquals(itemDetail.getThumbnail(), item1.getThumbnail());
            assertEquals(itemDetail.getImgDetail(), item1.getImgDetail());
        }
    }

    @Nested
    @DisplayName("전체상품_메인")
    @Order(2)
    class 전체상품_메인 {

        @Test
        @DisplayName("전체상품정보 불러오기")
        void getMainItems() {
            //given
            ItemService itemService = new ItemService(itemRepository);

            List<Item> christmasList = new ArrayList<>();
            List<Item> hotdealList = new ArrayList<>();
            List<Item> timedealList = new ArrayList<>();
            List<Item> recommendList = new ArrayList<>();

            recommendList.add(item1);
            recommendList.add(item2);
            recommendList.add(item3);
            recommendList.add(item4);
            recommendList.add(item5);
            recommendList.add(item6);
            recommendList.add(item7);
            recommendList.add(item8);
            christmasList.add(item3);
            christmasList.add(item4);
            timedealList.add(item5);
            timedealList.add(item6);
            hotdealList.add(item7);
            hotdealList.add(item8);

            when(itemRepository.findAllByShowAreaEnum(ShowAreaEnum.CHRISTMAS))
                    .thenReturn(christmasList);
            when(itemRepository.findAllByShowAreaEnum(ShowAreaEnum.HOTDEAL))
                    .thenReturn(hotdealList);
            when(itemRepository.findAllByShowAreaEnum(ShowAreaEnum.TIMEDEAL))
                    .thenReturn(timedealList);

            Page<Item> findPage = new PageImpl<>(recommendList);
            when(itemRepository.findAll(PageRequest.of(0, 3))).thenReturn(
                    findPage);

            //when
            MainResponseDto mainItems = itemService.getMainItems(1, 3);

            //then
            assertEquals(item3.getId(), mainItems.getChristmasProducts().get(0).getItemId());
            assertEquals(item4.getId(), mainItems.getChristmasProducts().get(1).getItemId());
        }
    }



}