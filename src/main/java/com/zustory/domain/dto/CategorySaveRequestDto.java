package com.zustory.domain.dto;

import java.util.List;

import com.zustory.domain.beverage.Beverage;
import com.zustory.domain.category.Category;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategorySaveRequestDto {
    private String type;
    private List<Beverage> beverages;

    @Builder
    public CategorySaveRequestDto(String type, List<Beverage> beverages) {
        this.type = type;
        this.beverages = beverages;
    }

    public Category toEntity() {
        return Category.builder().type(type).beverages(beverages).build();
    }
}
