package com.health.project.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class inBody {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inBody_no")
    private Long no;

    @Embedded
    private Body_Composition composition;
    @Embedded
    private Muscle_fat muscle_fat;
    @Embedded
    private Obesity_diagnosis obesity_diagnosis;
    @Embedded
    private Body_balance body_balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;
}
