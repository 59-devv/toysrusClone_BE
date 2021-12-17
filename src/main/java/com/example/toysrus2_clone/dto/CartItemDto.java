package com.example.toysrus2_clone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {

    private Long itemId;
    private String itemName;
    private String thumbnail;
    private Long price;
    private Long count;
}
