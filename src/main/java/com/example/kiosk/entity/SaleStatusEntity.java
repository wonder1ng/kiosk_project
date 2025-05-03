package com.example.kiosk.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "sale_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_status_id", columnDefinition = "TINYINT UNSIGNED")
    private Short saleStatusId;

    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(63)")
    private String status;
}
