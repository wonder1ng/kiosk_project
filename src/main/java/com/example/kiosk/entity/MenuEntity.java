package com.example.kiosk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "menu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id", columnDefinition = "SMALLINT UNSIGNED")
    private Integer menuId;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(63)")
    private String name;

    @Column(name = "image", columnDefinition = "VARCHAR(255) DEFAULT NULL")
    private String image;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "price", nullable = false, columnDefinition = "MEDIUMINT")
    private Integer price;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "modified_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime modifiedAt;

    @ManyToOne
    @JoinColumn(name = "menu_status_id", nullable = false)
    private MenuStatusEntity menuStatus;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;
}