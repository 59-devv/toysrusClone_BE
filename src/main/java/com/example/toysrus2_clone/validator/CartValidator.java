package com.example.toysrus2_clone.validator;

import com.example.toysrus2_clone.model.Item;
import com.example.toysrus2_clone.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class CartValidator {

    // Validator
    // user가 없을때 에러
    // cartCount가 없을때 에러, 0이거나 마이너스일때 에러
    // 아이템이 없을때 에러
    public static void checkCart(User user, Long cartCount, Item item) {
        if (user == null) {
            throw new IllegalArgumentException("유저가 확인되지 않습니다.");
        }

        if (cartCount <= 0) {
            throw new IllegalArgumentException("상품을 1개 이상 담아주세요.");
        }

        if (item == null) {
            throw new IllegalArgumentException("상품을 선택해주세요.");
        }
    }
}
