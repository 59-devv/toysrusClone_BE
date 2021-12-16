package com.example.toysrus2_clone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MainResponseDto {

    private List<ChristmasItemDto> christmasProducts;
    private List<TimedealDto> timeLimitProducts;
    private List<HotItemDto> hotProducts;
    private Page<RecommendItemDto> recommendProducts;
}
