package com.zustory.domain.dto;

import com.zustory.domain.beverage.Beverage;
import lombok.Getter;

@Getter
public class BeverageResponseDto {

    private Long id;

    private String beverageName;

    private String company;

    private String abv;

    private String contents;

    private String imageUrl;

    private CategoryResponseDto category;

    public BeverageResponseDto(Beverage beverage) {
        this.id = beverage.getId();
        this.beverageName = beverage.getBeverageName();
        this.company = beverage.getCompany();
        this.abv = beverage.getAbv();
        this.contents = beverage.getContents();
        this.imageUrl = beverage.getImageUrl();
        this.category = new CategoryResponseDto(beverage.getCategory());
    }
}
