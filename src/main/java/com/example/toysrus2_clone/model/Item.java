package com.example.toysrus2_clone.model;

import com.example.toysrus2_clone.dto.ItemDto;
import com.example.toysrus2_clone.validator.ItemValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Item {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private String thumbnail;

    @Column(nullable = false)
    private String imgDetail;

    @Column(nullable = false)
    private Long price;

    @Column
    private Long discount;

    @Column
    private String description;

    @Column
    @Enumerated(value = EnumType.STRING)
    private ShowAreaEnum showAreaEnum;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="categoryId")
    private Category category;

    @Column
    private Long clickCount;

    public Item(Long id, String itemName, String thumbnail, String imgDetail, Long price, Long discount, String description, ShowAreaEnum showAreaEnum, Category category, Long clickCount) {

        ItemValidator.isValidItems(id,itemName, thumbnail, imgDetail,price,discount,  description, showAreaEnum, category,clickCount);
        this.id = id;
        this.itemName = itemName;
        this.thumbnail = thumbnail;
        this.imgDetail = imgDetail;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.showAreaEnum = showAreaEnum;
        this.category = category;
        this.clickCount = clickCount;
    }

    public Item(ItemDto itemDto) {
        ItemValidator.isValidItem(itemDto);

        this.itemName=itemDto.getItemName();
        this.thumbnail=itemDto.getThumbnail();
        this.imgDetail=itemDto.getImgDetail();
        this.price=itemDto.getPrice();
        this.category= itemDto.getCategory();
        this.discount=0L;
        this.clickCount=0L;
        this.showAreaEnum = ShowAreaEnum.RECOMMEND;

    }

}
