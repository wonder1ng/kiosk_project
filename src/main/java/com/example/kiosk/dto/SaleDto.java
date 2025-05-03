package com.example.kiosk.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDto {
    private Long saleId;
    private Integer kioskId;
    private Integer price;
    private Boolean paymentResponse;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;
    private LocalDateTime receivedAt;
    private Boolean cancel;
    private Short saleStatusId;
    private Short paymentMethodId;
    private Short saleTypeId;
}
