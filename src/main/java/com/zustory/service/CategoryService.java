package com.zustory.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zustory.domain.category.Category;
import com.zustory.domain.category.CategoryRepository;
import com.zustory.domain.dto.CategorySaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public Long save(CategorySaveRequestDto requestDto) {
        return categoryRepository.save(requestDto.toEntity()).getId();
    }

    public List<Category> getAllCategories() {
        List<Category> allCategories = categoryRepository.findAll();

        return allCategories;
    }
}
