package com.zustory.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import com.zustory.domain.beverage.Beverage;
import com.zustory.domain.beverage.BeverageRepository;
import com.zustory.domain.dto.BeverageResponseDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
class BeverageServiceTest {

    @Mock
    BeverageRepository beverageRepository;

    @InjectMocks
    BeverageService beverageService;

    @Test
    void id가_1인_주류가_정상조회된다() {
        // given
        Long beverageId = 1L;
        String beverageName = "beverage";
        String company = "company";
        String abv = "16.0";
        String contents = "contents";
        Beverage beverageMock = Beverage.builder()
                .beverageName(beverageName)
                .company(company)
                .abv(abv)
                .contents(contents)
                .build();

        given(beverageRepository.findById(beverageId)).willReturn(Optional.ofNullable(beverageMock));

        // when
        BeverageResponseDto beverage = beverageService.findBeverage(beverageId);

        // then
        assertAll(
                () -> assertEquals(beverageName, beverage.getBeverageName()),
                () -> assertEquals(company, beverage.getCompany()),
                () -> assertEquals(abv, beverage.getAbv()),
                () -> assertEquals(contents, beverage.getContents()));
    }

    @Test
    void 주류_다건이_정상_조회된다() {
        // given
        Long beverageId = 1L;
        String beverageName = "beverage";
        String company = "company";
        String abv = "16.0";
        String contents = "contents";
        Beverage beverageMock = Beverage.builder()
                .beverageName(beverageName)
                .company(company)
                .abv(abv)
                .contents(contents)
                .build();

        Pageable pageable = PageRequest.of(0, 5);
        List<Beverage> beverageList = new ArrayList<>();
        beverageList.add(beverageMock);

        Page<Beverage> beveragePageMock = new PageImpl<>(beverageList);

        given(beverageRepository.findAll(pageable)).willReturn(beveragePageMock);

        // when
        Page<BeverageResponseDto> beverages = beverageService.findBeverages(pageable);

        // then
        assertFalse(beverages.isEmpty());
        BeverageResponseDto beverage = beverages.getContent().get(0);
        assertAll(
                () -> assertEquals(beverageName, beverage.getBeverageName()),
                () -> assertEquals(company, beverage.getCompany()),
                () -> assertEquals(abv, beverage.getAbv()),
                () -> assertEquals(contents, beverage.getContents()));
    }
}
