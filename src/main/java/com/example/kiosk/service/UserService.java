package com.example.kiosk.service;

import com.example.kiosk.dto.UserJoinDto;
import com.example.kiosk.entity.UserEntity;
import com.example.kiosk.entity.UserRoleEntity;
import com.example.kiosk.repository.UserRepository;
import com.example.kiosk.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(UserJoinDto dto) {
        if (userRepository.existsBySignId(dto.getSignId())) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }

        UserRoleEntity role = userRoleRepository.findById(dto.getUserRoleId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 역할 ID입니다."));

        UserEntity user = UserEntity.builder()
                .userRole(role)
                .signId(dto.getSignId())
                .password(passwordEncoder.encode(dto.getPassword()))
                .phoneNumber(dto.getPhoneNumber())
                .faxNumber(dto.getFaxNumber())
                .zipCode(dto.getZipCode())
                .streetAddress(dto.getStreetAddress())
                .detailAddress(dto.getDetailAddress())
                .companyName(dto.getCompanyName())
                .branch(dto.getBranch())
                .businessNumber(dto.getBusinessNumber())
                .build();

        userRepository.save(user);
    }
}
