package com.example.kiosk.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserJoinDto {
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
}