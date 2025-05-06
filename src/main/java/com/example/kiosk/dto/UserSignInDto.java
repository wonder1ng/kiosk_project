package com.example.kiosk.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSignInDto {
    private Short userRoleId;
    private String signId;
    private String phoneNumber;
    private String faxNumber;
    private String zipCode;
    private String streetAddress;
    private String detailAddress;
    private String companyName;
    private String branch;
    private String businessNumber;
}
