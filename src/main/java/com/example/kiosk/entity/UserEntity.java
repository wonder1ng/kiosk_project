package com.example.kiosk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
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
}














// DTO 클래스도 원하시면 다음으로 이어서 제공해드릴게요!
