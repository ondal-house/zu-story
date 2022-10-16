package com.zustory.service;

import com.zustory.domain.dto.SampleListResponseDto;
import com.zustory.domain.dto.SampleResponseDto;
import com.zustory.domain.dto.SampleSaveRequestDto;
import com.zustory.domain.sample.Sample;
import com.zustory.domain.sample.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SampleService {

    private final SampleRepository sampleRepository;

    @Transactional
    public Long save(SampleSaveRequestDto requestDto) {
        return sampleRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<SampleListResponseDto> findAllDesc() {
        return sampleRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream()
                .map(SampleListResponseDto::new)
                .collect(Collectors.toList());
    }
    
    @Transactional(readOnly = true)
    public SampleResponseDto findById(Long id) {
        Sample sample = sampleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 sample입니다. id:" + id));
        return new SampleResponseDto(sample);
    }
}
