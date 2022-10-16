package com.zustory.domain.dto;

import com.zustory.domain.sample.Sample;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class SampleResponseDto {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public SampleResponseDto(Sample entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createdDate = entity.getCreatedDate();
    }
}
