package com.example.kiosk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id", columnDefinition = "TINYINT UNSIGNED")
    private Short userRoleId;

    @Column(name = "role", nullable = false, columnDefinition = "VARCHAR(255)")
    private String role;
}