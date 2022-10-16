package com.zuStory.domain.dto;

import com.zuStory.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSaveRequestDto {
    private String name;

    @Builder
    public MemberSaveRequestDto(String name) {
        this.name = name;
    }

    public Member toEntity() {
        return Member.builder().name(name).build();
    }
}
