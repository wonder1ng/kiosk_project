package com.example.kiosk.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuOptionDto {
    private Integer menuOptionId;
    private Integer menuId;
    private Boolean radio;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Short menuStatusId;
}