package com.zustory.service;

import com.zustory.domain.category.CategoryRepository;
import com.zustory.domain.dto.CategoryResponseDto;
import com.zustory.domain.dto.CategorySaveRequestDto;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public Long save(CategorySaveRequestDto requestDto) {
        return categoryRepository.save(requestDto.toEntity()).getId();
    }

    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryResponseDto::new)
                .collect(Collectors.toList());
    }
}
