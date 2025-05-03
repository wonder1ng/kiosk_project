package com.example.kiosk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "menu_option")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuOptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_option_id", columnDefinition = "SMALLINT UNSIGNED")
    private Integer menuOptionId;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private MenuEntity menu;

    @Column(name = "radio", nullable = false, columnDefinition = "BOOLEAN DEFAULT 1")
    private Boolean radio;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(63)")
    private String name;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "modified_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime modifiedAt;

    @ManyToOne
    @JoinColumn(name = "menu_status_id", nullable = false)
    private MenuStatusEntity menuStatus;
}
