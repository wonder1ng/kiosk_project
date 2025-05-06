package com.example.kiosk.entity;

import com.example.kiosk.dto.UserRegisterDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
//@Setter는 update커스텀 메소드로 만든다.
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sign_id")
    private String signId;
    @Column(name = "password")
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "fax_number")
    private String faxNumber;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "detail_address")
    private String detailAddress;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "branch")
    private String branch;
    @Column(name = "business_number")
    private String businessNumber;

    @Column(name = "created_at")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

//    public UserRegisterDto toSaveDto(){
//        return UserRegisterDto.builder()
//                .id(id)
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
//                .build();
//    }
}