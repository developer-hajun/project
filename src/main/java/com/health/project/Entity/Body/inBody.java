package com.health.project.Entity.Body;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.health.project.Entity.Member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter(value = AccessLevel.PROTECTED)
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
    @JsonIgnore
    private Member member;

    public void setMember(Member member){
        this.member = member;
        member.getInBodies().add(this);
    }

    public inBody(Body_Composition composition, Muscle_fat muscle_fat, Obesity_diagnosis obesity_diagnosis, Body_balance body_balance) {
        this.composition = composition;
        this.muscle_fat = muscle_fat;
        this.obesity_diagnosis = obesity_diagnosis;
        this.body_balance = body_balance;
    }
}
