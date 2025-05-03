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
public class KioskDto {
    private Integer kioskId;
    private Long userId;
    private Integer kioskNumber;
    private LocalDateTime createdAt;
}
