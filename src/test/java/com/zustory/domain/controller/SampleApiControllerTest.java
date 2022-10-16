package com.zustory.domain.controller;

import com.zustory.domain.dto.SampleListResponseDto;
import com.zustory.domain.dto.SampleSaveRequestDto;
import com.zustory.domain.sample.Sample;
import com.zustory.domain.sample.SampleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SampleApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private SampleRepository sampleRepository;

    @AfterEach
    public void tearDown() {
        sampleRepository.deleteAll();
    }

    @Test
    void save() {
        //given
        String title = "sample 타이틀";
        String content = "sample content";

        SampleSaveRequestDto requestDto = SampleSaveRequestDto.builder().title(title).content(content).build();
        String url = "http://localhost:" + port + "/api/v1/sample";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isPositive();

        Sample sample = sampleRepository.findAll().get(0);
        assertThat(sample.getTitle()).isEqualTo(title);
        assertThat(sample.getContent()).isEqualTo(content);
    }

    @Test
    void findAllDesc() {
    }

    @Test
    void findById() {
    }
}