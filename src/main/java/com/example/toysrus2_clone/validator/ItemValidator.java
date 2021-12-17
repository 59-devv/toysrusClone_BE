package com.example.toysrus2_clone.validator;

import com.example.toysrus2_clone.dto.ItemDto;
import com.example.toysrus2_clone.model.Category;
import com.example.toysrus2_clone.model.Item;
import com.example.toysrus2_clone.model.ShowAreaEnum;
import org.springframework.stereotype.Component;


@Component
public class ItemValidator {

        public static void isValidItem(ItemDto itemDto) {
// 입력값 Validation


            if (itemDto.getItemName() == null || itemDto.getItemName().trim().isEmpty()) {
                throw new IllegalArgumentException("저장할 수 있는 상품명이 없습니다.");
            }

            if (!UrlValidator.isValidUrl(itemDto.getThumbnail())) {
                throw new IllegalArgumentException("상품 이미지 URL 포맷이 맞지 않습니다.");
            }

            if (!UrlValidator.isValidUrl(itemDto.getImgDetail())) {
                throw new IllegalArgumentException("상세페이지 이미지 URL 포맷이 맞지 않습니다.");
            }

            if (itemDto.getPrice() <= 0) {
                throw new IllegalArgumentException("상품 가격이 0 이하입니다.");
            }
            if (itemDto.getCategory() == null || itemDto.getCategory().getName().contains(" ") ) {
                throw new IllegalArgumentException("저장할 수 있는 카테고리명이 없습니다.");
            }


        }

    public static void isValidItems(Long id, String itemName, String thumbnail, String imgDetail, Long price, Long discount, String description, ShowAreaEnum showAreaEnum, Category category, Long clickCount) {


        if (clickCount < 0) {
            throw new IllegalArgumentException("조회수가 0 미만입니다.");
        }
        if (discount< 0) {
            throw new IllegalArgumentException("할인율이 0 미만입니다.");
        }

        }
}

