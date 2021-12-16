package com.example.toysrus2_clone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartUserInfoDto {

    private Long userId;
    private String name;
    private String address;
}
