package com.example.kiosk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "payment_method")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentMethodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_id", columnDefinition = "TINYINT UNSIGNED")
    private Short paymentMethodId;

    @Column(name = "method", nullable = false, columnDefinition = "VARCHAR(63)")
    private String method;
}