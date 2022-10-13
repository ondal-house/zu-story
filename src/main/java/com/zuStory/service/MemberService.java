package com.zuStory.service;

import com.zuStory.domain.dto.MemberSaveRequestDto;
import com.zuStory.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long save(MemberSaveRequestDto requestDto) {
        return memberRepository.save(requestDto.toEntity()).getId();
    }
}
