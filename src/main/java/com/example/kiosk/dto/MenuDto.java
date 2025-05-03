package com.example.kiosk.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuDto {
    private Integer menuId;
    private String name;
    private String image;
    private String description;
    private Integer price;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Short menuStatusId;
    private Short categoryId;
}