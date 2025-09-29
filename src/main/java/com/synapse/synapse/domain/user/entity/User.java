package com.synapse.synapse.domain.user.entity;

import com.synapse.synapse.domain.speechdata.entity.SpeechData;
import com.synapse.synapse.domain.user.model.UserType;
import com.synapse.synapse.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Builder
@Table(name="user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 25)
    private UserType userType = UserType.USER;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private SpeechData speechData;

}
