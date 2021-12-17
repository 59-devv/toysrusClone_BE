package com.example.toysrus2_clone.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class CartValidator {

    // Validator
    // user가 없을때 에러
    // cartCount가 없을때 에러, 0이거나 마이너스일때 에러
    // 아이템이 없을때 에러
}
