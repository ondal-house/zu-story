package com.zustory.domain.controller;

import com.zustory.domain.dto.UserSaveRequestDto;
import com.zustory.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/v1/user")
    public Long save(@RequestBody UserSaveRequestDto requestDto) {
        return userService.save(requestDto);
    }
}
