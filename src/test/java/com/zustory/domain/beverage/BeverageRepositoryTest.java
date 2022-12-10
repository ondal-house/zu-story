package com.zustory.domain.beverage;

import static org.junit.jupiter.api.Assertions.*;

import com.zustory.domain.category.Category;
import com.zustory.domain.category.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BeverageRepositoryTest {

    @Autowired
    BeverageRepository beverageRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void 주류가_정상적으로_추가된다() {
        Category category = categoryRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("test"));
        Beverage beverage = Beverage.builder()
                .beverageName("테스트입니다.")
                .abv("19.0")
                .category(category)
                .company("test")
                .contents("test")
                .imageUrl("test")
                .build();
        beverageRepository.save(beverage);
    }
}
