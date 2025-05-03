package com.example.kiosk.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptionDetailDto {
    private Integer optionDetailId;
    private Integer menuOptionId;
    private Integer menuId;
    private Integer price;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Short menuStatusId;
}