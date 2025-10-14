package com.synapse.synapse.domain.option.entity;


import com.synapse.synapse.domain.admin.Admin;
import com.synapse.synapse.domain.menu.entity.Menu;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Getter
@Builder
@Table(name = "option_category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // optionCategoryId

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

    @Column(nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "optionCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OptionItem> optionItems = new ArrayList<>();
}
