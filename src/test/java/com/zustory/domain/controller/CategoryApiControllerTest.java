package com.zustory.domain.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.zustory.domain.category.Category;
import com.zustory.domain.category.CategoryRepository;
import com.zustory.domain.dto.CategorySaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoryApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void cleanUp() {
        categoryRepository.deleteAll();
    }

    @AfterEach
    public void tearDown() {
        categoryRepository.deleteAll();
    }

    @Test
    void save() {
        // given
        String type = "category 타입";
        CategorySaveRequestDto requestDto =
                CategorySaveRequestDto.builder().type(type).build();
        String url = "http://localhost:" + port + "/api/v1/categories";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isPositive();

        Category category = categoryRepository.findAll().get(0);
        assertThat(category.getType()).isEqualTo(type);
    }
}
