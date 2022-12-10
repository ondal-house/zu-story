package com.zustory.service;

import com.zustory.domain.beverage.Beverage;
import com.zustory.domain.beverage.BeverageRepository;
import com.zustory.domain.dto.BeverageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BeverageService {

    private final BeverageRepository beverageRepository;

    public BeverageResponseDto findBeverage(Long beverageId) {
        Beverage beverage = beverageRepository
                .findById(beverageId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 술입니다."));
        return new BeverageResponseDto(beverage);
    }

    public Page<BeverageResponseDto> findBeverages(Pageable pageable) {
        Page<Beverage> beverages = beverageRepository.findAll(pageable);
        return beverages.map(BeverageResponseDto::new);
    }
}
