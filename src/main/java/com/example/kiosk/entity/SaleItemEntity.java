package com.example.kiosk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sale_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_item_id", columnDefinition = "BIGINT UNSIGNED")
    private Long saleItemId;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private SaleEntity sale;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private MenuEntity menu;

    @Column(name = "item_sequence", nullable = false, columnDefinition = "TINYINT UNSIGNED")
    private Short itemSequence;

    @Column(name = "price", nullable = false, columnDefinition = "MEDIUMINT")
    private Integer price;

    @Column(name = "quantity", nullable = false, columnDefinition = "TINYINT UNSIGNED DEFAULT 1")
    private Short quantity;
}