package com.example.kiosk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "option_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptionDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_detail_id", columnDefinition = "MEDIUMINT UNSIGNED")
    private Integer optionDetailId;

    @ManyToOne
    @JoinColumn(name = "menu_option_id", nullable = false)
    private MenuOptionEntity menuOption;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private MenuEntity menu;

    @Column(name = "price", nullable = false, columnDefinition = "MEDIUMINT")
    private Integer price;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "modified_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime modifiedAt;

    @ManyToOne
    @JoinColumn(name = "menu_status_id", nullable = false)
    private MenuStatusEntity menuStatus;
}