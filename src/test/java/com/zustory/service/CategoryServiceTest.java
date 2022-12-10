package com.zustory.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

import com.zustory.domain.category.Category;
import com.zustory.domain.category.CategoryRepository;
import com.zustory.domain.dto.CategorySaveRequestDto;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    void 카테고리_생성() {
        // given
        CategorySaveRequestDto requestDto =
                CategorySaveRequestDto.builder().type("category1").build();
        Category category = Category.builder().type(requestDto.getType()).build();

        Long fakeCategoryId = 1L;
        ReflectionTestUtils.setField(category, "id", fakeCategoryId);

        // mocking
        given(categoryRepository.save(any())).willReturn(category);

        given(categoryRepository.findById(fakeCategoryId)).willReturn(Optional.ofNullable(category));
        given(categoryRepository.findById(fakeCategoryId)).willReturn(Optional.ofNullable(category));

        // when
        Long newCategoryId = categoryService.save(requestDto);

        // then
        Category findCategory = categoryRepository.findById(newCategoryId).get();

        assertEquals(category.getId(), findCategory.getId());
        assertEquals(category.getType(), findCategory.getType());
    }
}
