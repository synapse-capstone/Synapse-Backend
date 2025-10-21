package com.synapse.synapse.domain.admin.menu.entity;

import com.synapse.synapse.domain.admin.Admin;
import com.synapse.synapse.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@Table(name = "menu")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //adminId (해당 상품(메뉴)를 등록한 관리자 번호)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false, length = 50)
    private String menuName;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false, length = 200)
    private String imageUrl;

    @Builder.Default
    @Column(nullable = false)
    private boolean isAvailable = true; //메뉴 판매 가능 여부

    @Builder.Default
    @Column(nullable = false)
    private boolean isDeleted = false; //soft delete

    //qrCodeUrl

    //AI 추천 프롬프트
    @Column(length = 1000)
    private String aiPromptForRecommendation;
}
