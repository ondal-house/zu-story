package com.zustory.domain.dto;

import com.zustory.domain.sample.Sample;
import lombok.Builder;

public class SampleSaveRequestDto {

    private String title;

    private String content;

    @Builder
    public SampleSaveRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Sample toEntity() {
        return Sample.builder().title(title).content(content).build();
    }
}
