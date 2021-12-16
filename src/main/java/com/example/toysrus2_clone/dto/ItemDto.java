package com.example.toysrus2_clone.dto;

import com.example.toysrus2_clone.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private String itemName;
    private String thumbnail;
    private String imgDetail;
    private Long price;
    private Category category;

}
