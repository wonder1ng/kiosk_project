package com.example.kiosk.dto;

import com.example.kiosk.entity.UserEntity;
import com.example.kiosk.entity.UserRoleEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterDto {
//        private Long userId;
    private Short userRoleId;
    private String signId;
    private String password;
    private String phoneNumber;
    private String faxNumber;
    private String zipCode;
    private String streetAddress;
    private String detailAddress;
    private String companyName;
    private String branch;
    private String businessNumber;
    private LocalDateTime createdAt;

//    public UserEntity toSaveEntity() {
//        return UserEntity.builder()
//                .userRole(userRoleId)
//                .signId(signId)
//                .password(password)
//                .phoneNumber(phoneNumber)
//                .faxNumber(faxNumber)
//                .zipCode(zipCode)
//                .streetAddress(streetAddress)
//                .detailAddress(detailAddress)
//                .companyName(companyName)
//                .branch(branch)
//                .businessNumber(businessNumber)
//                .createdAt(createdAt)
//                .build();
//    }
}