package com.zustory.domain.dto;

import com.zustory.domain.sample.Sample;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Getter
public class SampleListResponseDto {
    private Long id;
    private String title;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public SampleListResponseDto(Sample entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.createdDate = entity.getCreatedDate();
    }
}
