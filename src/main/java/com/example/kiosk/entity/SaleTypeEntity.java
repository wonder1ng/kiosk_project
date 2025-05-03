package com.example.kiosk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sale_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_type_id", columnDefinition = "TINYINT UNSIGNED")
    private Short saleTypeId;

    @Column(name = "type", nullable = false, columnDefinition = "VARCHAR(63)")
    private String type;
}