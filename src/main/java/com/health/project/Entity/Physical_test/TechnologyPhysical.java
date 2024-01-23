package com.health.project.Entity.Physical_test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.health.project.Entity.Member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TechnologyPhysical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technology_physical_no")
    private Long no;
    private float power;
    private float powerMax;
    private float powerKg;
    private float SideStep;
    private float close_eye_right;
    private float close_eye_left;
    private float light_reaction;
    private float blaze_pot;
    @CreationTimestamp
    private LocalDateTime localDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    @JsonIgnore
    private Member member;
    public void setMember(Member member){
        this.member = member;
        member.getTechnologyPhysicals().add(this);
    }

    public TechnologyPhysical(float power, float powerMax, float powerKg, float sideStep, float close_eye_right, float close_eye_left, float light_reaction, float blaze_pot) {
        this.power = power;
        this.powerMax = powerMax;
        this.powerKg = powerKg;
        this.SideStep = sideStep;
        this.close_eye_right = close_eye_right;
        this.close_eye_left = close_eye_left;
        this.light_reaction = light_reaction;
        this.blaze_pot = blaze_pot;
    }
}
