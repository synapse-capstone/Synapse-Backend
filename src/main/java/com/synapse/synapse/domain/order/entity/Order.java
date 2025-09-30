package com.synapse.synapse.domain.order.entity;

import com.synapse.synapse.domain.admin.entity.StoreInfo;
import com.synapse.synapse.domain.order.model.OrderType;
import com.synapse.synapse.domain.order.model.Status;
import com.synapse.synapse.domain.user.entity.User;
import com.synapse.synapse.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //매장 정보 (하나의 가게는 여러 주문을 가질 수 있음)
    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name ="storeId", nullable = false)
    private StoreInfo storeInfo;

    //한사용자 - 동시주문 가능
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderType orderType;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private Integer queueNumber;

}
