package com.zustory.domain.sample;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SampleTest {

    @Autowired
    SampleRepository sampleRepository;

    @AfterEach
    void cleanUp() {
        sampleRepository.deleteAll();
    }

    @Test
    void 샘플_저장_조회() {
        // given
        String title = "sample 제목";
        String content = "sample 내용";

        sampleRepository.save(Sample.builder().title(title).content(content).build());

        // when
        List<Sample> sampleList = sampleRepository.findAll();

        // then
        Sample sample = sampleList.get(0);
        assertThat(sample.getTitle()).isEqualTo(title);
        assertThat(sample.getContent()).isEqualTo(content);
    }

    @Test
    void 샘플_저장_단건조회() {
        String title = "sample 제목";
        String content = "sample 내용";

        Sample save = sampleRepository.save(
                Sample.builder().title(title).content(content).build());

        // when
        Sample sample =
                sampleRepository.findById(save.getId()).orElseThrow(() -> new IllegalArgumentException("해당 ID가 없습니다."));

        // then
        assertThat(sample.getTitle()).isEqualTo(title);
        assertThat(sample.getContent()).isEqualTo(content);
    }
}
