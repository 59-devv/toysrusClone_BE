package com.example.toysrus2_clone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDto {
    private CartUserInfoDto userInfo;
    private List<CartItemDto> items;
}
