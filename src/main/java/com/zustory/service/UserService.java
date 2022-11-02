package com.zustory.service;

import com.zustory.domain.dto.UserSaveRequestDto;
import com.zustory.domain.user.UserRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveRequestDto requestDto) {
        return userRepository.save(requestDto.toEntity()).getId();
    }
}
