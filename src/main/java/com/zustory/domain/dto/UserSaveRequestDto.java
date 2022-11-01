package com.zustory.domain.dto;

import com.zustory.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String name;

    @Builder
    public UserSaveRequestDto(String name) {
        this.name = name;
    }

    public User toEntity() {
        return User.builder().name(name).build();
    }
}
