package com.zustory.domain.dto;

import com.zustory.domain.category.Category;
import lombok.Getter;

@Getter
public class CategoryResponseDto {

    private Long id;
    private String type;

    public CategoryResponseDto(Category category) {
        this.id = category.getId();
        this.type = category.getType();
    }
}
