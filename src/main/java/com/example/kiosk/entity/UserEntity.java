//package com.example.kiosk.entity;
//
//import com.example.kiosk.dto.UserDto;
//import com.example.kiosk.dto.UserRegisterDto;
//import com.example.kiosk.dto.UserSignInDto;
//import jakarta.persistence.*;
//import lombok.*;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Entity
//@Table(name = "user")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class UserEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id", columnDefinition = "BIGINT UNSIGNED")
//    private Long userId;
//
//    @ManyToOne
//    @JoinColumn(name = "user_role_id", nullable = false)
//    private UserRoleEntity userRole;
//
//    @Column(name = "sign_id", nullable = false, unique = true, columnDefinition = "VARCHAR(255)")
//    private String signId;
//
//    @Column(name = "password", nullable = false, columnDefinition = "CHAR(60)")
//    private String password;
//
//    @Column(name = "phone_number", nullable = false, columnDefinition = "CHAR(13)")
//    private String phoneNumber;
//
//    @Column(name = "fax_number", columnDefinition = "CHAR(13)")
//    private String faxNumber;
//
//    @Column(name = "zip_code", nullable = false, columnDefinition = "CHAR(5)")
//    private String zipCode;
//
//    @Column(name = "street_address", nullable = false, columnDefinition = "VARCHAR(63)")
//    private String streetAddress;
//
//    @Column(name = "detail_address", nullable = false, columnDefinition = "VARCHAR(63)")
//    private String detailAddress;
//
//    @Column(name = "company_name", nullable = false, columnDefinition = "VARCHAR(63)")
//    private String companyName;
//
//    @Column(name = "branch", nullable = false, columnDefinition = "VARCHAR(63)")
//    private String branch;
//
//    @Column(name = "business_number", nullable = false, columnDefinition = "CHAR(10)")
//    private String businessNumber;
//
//    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
//    private LocalDateTime createdAt;
//
//    public UserRegisterDto toSaveDto() {
//        return UserRegisterDto.builder()
//                .userRoleId(userRole.getUserRoleId())
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
//
////    private UserSignInDto tiGetDto(UserEntity entity) {
////        return UserDto.builder()
////                .userId(entity.getUserId())
////                .userRoleId(entity.getUserRoleId())
////                .signId(entity.getSignId())
////                .password(entity.getPassword())
////                .phoneNumber(entity.getPhoneNumber())
////                .faxNumber(entity.getFaxNumber())
////                .zipCode(entity.getZipCode())
////                .streetAddress(entity.getStreetAddress())
////                .detailAddress(entity.getDetailAddress())
////                .companyName(entity.getCompanyName())
////                .branch(entity.getBranch())
////                .businessNumber(entity.getBusinessNumber())
////                .createdAt(entity.getCreatedAt())
////                .build();
////    }
//}

package com.example.kiosk.entity;

import com.example.kiosk.dto.UserRegisterDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "BIGINT UNSIGNED")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_role_id", nullable = false)
    private UserRoleEntity userRole;

    @Column(name = "sign_id", nullable = false, unique = true, columnDefinition = "VARCHAR(255)")
    private String signId;

    @Column(name = "password", nullable = false, columnDefinition = "CHAR(60)")
    private String password;

    @Column(name = "phone_number", nullable = false, columnDefinition = "CHAR(13)")
    private String phoneNumber;

    @Column(name = "fax_number", columnDefinition = "CHAR(13)")
    private String faxNumber;

    @Column(name = "zip_code", nullable = false, columnDefinition = "CHAR(5)")
    private String zipCode;

    @Column(name = "street_address", nullable = false, columnDefinition = "VARCHAR(63)")
    private String streetAddress;

    @Column(name = "detail_address", nullable = false, columnDefinition = "VARCHAR(63)")
    private String detailAddress;

    @Column(name = "company_name", nullable = false, columnDefinition = "VARCHAR(63)")
    private String companyName;

    @Column(name = "branch", nullable = false, columnDefinition = "VARCHAR(63)")
    private String branch;

    @Column(name = "business_number", nullable = false, columnDefinition = "CHAR(10)")
    private String businessNumber;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    // --- UserDetails 구현 부분 ---
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // 권한이 필요하면 여기에 구현
    }

    @Override
    public String getUsername() {
        return signId; // 로그인에 사용할 ID 필드
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 계정 만료 여부 (false면 로그인 불가)
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 계정 잠김 여부
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 비밀번호 만료 여부
    }

    @Override
    public boolean isEnabled() {
        return true; // 계정 활성화 여부
    }
}
