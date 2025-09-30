package com.synapse.synapse.domain.menu.entity;

import com.synapse.synapse.domain.admin.entity.Admin;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@Table(name = "menu")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String menuName;

    //adminId (해당 상품(메뉴)를 등록한 관리자 번호)
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false, length = 200)
    private String imageUrl;

}
