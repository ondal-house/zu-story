package com.zustory.domain.controller;

import com.zustory.domain.dto.BeverageResponseDto;
import com.zustory.service.BeverageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beverages")
public class BeverageApiController {

    private final BeverageService beverageService;

    @GetMapping("/{beverageId}")
    public BeverageResponseDto findBeverage(@PathVariable Long beverageId) {
        return beverageService.findBeverage(beverageId);
    }

    @GetMapping
    public Page<BeverageResponseDto> findBeverages(@PageableDefault(size = 10, sort = "id") Pageable pageable) {
        return beverageService.findBeverages(pageable);
    }
}
