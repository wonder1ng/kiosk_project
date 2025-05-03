package com.example.kiosk.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_role")
@Getter
//@Setter는 update커스텀 메소드로 만든다.
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte userRoleId;
    @Column(name = "role")
    private String role;
}