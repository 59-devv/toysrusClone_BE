package com.example.toysrus2_clone.controller;

import com.example.toysrus2_clone.crawling.CrawlingJsoup;
import com.example.toysrus2_clone.dto.CrawlingDto;
import com.example.toysrus2_clone.dto.ItemDetailDto;
import com.example.toysrus2_clone.dto.MainResponseDto;
import com.example.toysrus2_clone.dto.RakingDto;
import com.example.toysrus2_clone.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final CrawlingJsoup crawlingJsoup;

    @PostMapping("/api/crawling")
    public void makeItems(@RequestBody CrawlingDto crawlingDto) throws IOException, InterruptedException {

        crawlingJsoup.crawlingAdd(crawlingDto.getCategoryUrl(),crawlingDto.getCategoryName());

    }

    @GetMapping("/api/item/{itemId}")
    public ItemDetailDto getDetail(@PathVariable Long itemId){
        return itemService.getDetail(itemId);
    }

    @GetMapping("/api/item")
    public MainResponseDto getMainItems(@RequestParam int page, @RequestParam int size){
        return itemService.getMainItems(page,size);
    }

    @GetMapping("/api/item/ranking")
    public List<RakingDto> getRanking(){
        return itemService.getRanking();
    }
}
