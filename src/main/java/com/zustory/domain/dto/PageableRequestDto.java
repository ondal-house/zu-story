package com.zustory.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Data;

@Data
public class PageableRequestDto {
    @Schema(description = "페이지 번호(0..N)", example = "1")
    private Integer page;

    @Schema(description = "페이지 크기", example = "10", allowableValues = "range[0, 100]")
    private Integer size;

    @Schema(description = "정렬(사용법: 컬럼명,ASC|DESC)")
    private List<String> sort;
}
