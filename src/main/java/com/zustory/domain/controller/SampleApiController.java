package com.zustory.domain.controller;

import com.zustory.domain.dto.SampleListResponseDto;
import com.zustory.domain.dto.SampleResponseDto;
import com.zustory.domain.dto.SampleSaveRequestDto;
import com.zustory.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SampleApiController {

    private final SampleService sampleService;

    @PostMapping("/api/v1/sample")
    public Long save(@RequestBody SampleSaveRequestDto requestDto) {
        return sampleService.save(requestDto);
    }

    @GetMapping("/api/v1/samples")
    public List<SampleListResponseDto> findAllDesc() {
        return sampleService.findAllDesc();
    }

    @GetMapping("/api/v1/sample/{id}")
    public SampleResponseDto findById(@PathVariable Long id) {
        return sampleService.findById(id);
    }
}
