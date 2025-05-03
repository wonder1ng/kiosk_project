package com.example.kiosk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "sale")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id", columnDefinition = "INT UNSIGNED")
    private Long saleId;

    @ManyToOne
    @JoinColumn(name = "kiosk_id", nullable = false)
    private KioskEntity kiosk;

    @Column(name = "price", nullable = false, columnDefinition = "MEDIUMINT")
    private Integer price;

    @Column(name = "payment_response", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean paymentResponse;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "completed_at", columnDefinition = "DATETIME")
    private LocalDateTime completedAt;

    @Column(name = "received_at", columnDefinition = "DATETIME")
    private LocalDateTime receivedAt;

    @Column(name = "cancel", nullable = false, columnDefinition = "BOOLEAN DEFAULT 0")
    private Boolean cancel;

    @ManyToOne
    @JoinColumn(name = "sale_status_id", nullable = false)
    private SaleStatusEntity saleStatus;

    @ManyToOne
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethodEntity paymentMethod;

    @ManyToOne
    @JoinColumn(name = "sale_type_id", nullable = false)
    private SaleTypeEntity saleType;
}