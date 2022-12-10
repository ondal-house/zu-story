package com.zustory.domain.dto;

import com.zustory.domain.category.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategorySaveRequestDto {
    private String type;

    @Builder
    public CategorySaveRequestDto(String type) {
        this.type = type;
    }

    public Category toEntity() {
        return Category.builder().type(type).build();
    }
}
