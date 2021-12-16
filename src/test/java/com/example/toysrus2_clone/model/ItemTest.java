package com.example.toysrus2_clone.model;


import com.example.toysrus2_clone.dto.ItemDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ItemTest {

    @Test
    @DisplayName("정상 케이스")
    void creatItem(){
         //GIVEN
         Long id = 100L;
         String itemName= "goodn911";
         String thumbnail = "http://item.ssgcdn.com/62/52/15/item/1000276155262_i1_1200.jpg";
         String imgDetail="http://www.ssg.com/item/nonSslIframePItemDtlDesc.ssg?itemId=1000018907916";
         Long price = 15900L;
         Long discount = 15L;
         String description = " 크리스마스";
         ShowAreaEnum showAreaEnum = ShowAreaEnum.CHRISTMAS;
         Category category = null;
         Long clickCount = 2L;

        ItemDto itemDto = new ItemDto(
         itemName,
         thumbnail,
         imgDetail,
         price,
         category
        );
        Item item = new Item(itemDto);

        assertNull(item.getId());
        assertEquals(itemName,item.getItemName());
        assertEquals(thumbnail,item.getThumbnail());
        assertEquals(imgDetail,item.getImgDetail());
        assertEquals(price,item.getPrice());
        assertEquals(category,item.getCategory());
    }
}




