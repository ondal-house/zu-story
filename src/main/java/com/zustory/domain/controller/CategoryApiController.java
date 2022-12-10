package com.zustory.domain.controller;

import com.zustory.domain.dto.CategoryResponseDto;
import com.zustory.domain.dto.CategorySaveRequestDto;
import com.zustory.service.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/v1/categories")
public class CategoryApiController {

    private final CategoryService categoryService;

    @PostMapping
    public Long save(@RequestBody CategorySaveRequestDto requestDto) {
        return categoryService.save(requestDto);
    }

    @GetMapping
    public List<CategoryResponseDto> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
