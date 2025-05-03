package com.example.kiosk.dto;

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
public class SaleItemDto {
    private Long saleItemId;
    private Long saleId;
    private Integer menuId;
    private Short itemSequence;
    private Integer price;
    private Short quantity;
}
