package com.example.kiosk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "menu_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_status_id", columnDefinition = "TINYINT UNSIGNED")
    private Short menuStatusId;

    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(63)")
    private String status;
}