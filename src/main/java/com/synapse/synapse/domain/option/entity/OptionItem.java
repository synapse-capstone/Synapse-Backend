package com.synapse.synapse.domain.option.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@Table(name = "option_item")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // optionItemId

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "option_category_id", nullable = false)
    private OptionCategory optionCategory;

    @Column(nullable = false, length = 50)
    private String optionItemName;

    @Column(nullable = false)
    private Integer price;
}
