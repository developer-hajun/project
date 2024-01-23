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
public class BasicPhysical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basic_physical_no")
    private Long no;
    private float grap; //악력
    private float back; //근력
    private float Right_flat_60;//우대퇴폄근60
    private float Left_flat_60; //좌대퇴평근60
    private float Right_thigh_60; //우대퇴굽힙근60
    private float Left_thigh_60; //좌대퇴굽힙근60
    private float sit_up; //윗몸 일으키기
    private float push_up; //팔굽혀펴기
    private float Right_flat_240; //우대퇴폄근240
    private float Left_flat_240; //좌대퇴평근240
    private float Right_thigh_240; //우대퇴굽힙근240
    private float Left_thigh_240; //좌대퇴굽힙근240
    private float back_bending; //체후굴
    private float forward_bend; //좌전굴

    @CreationTimestamp
    private LocalDateTime localDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    @JsonIgnore
    private Member member;
    public void setMember(Member member){
        this.member = member;
        member.getBasicPhysicalList().add(this);
    }
    public BasicPhysical(float grap, float back, float right_flat_60, float left_flat_60, float right_thigh_60, float left_thigh_60, float sit_up, float push_up, float right_flat_240, float left_flat_240, float right_thigh_240, float left_thigh_240, float back_bending, float forward_bend) {
        this.grap = grap;
        this.back = back;
        this.Right_flat_60 = right_flat_60;
        this.Left_flat_60 = left_flat_60;
        this.Right_thigh_60 = right_thigh_60;
        this.Left_thigh_60 = left_thigh_60;
        this.sit_up = sit_up;
        this.push_up = push_up;
        this.Right_flat_240 = right_flat_240;
        this.Left_flat_240 = left_flat_240;
        this.Right_thigh_240 = right_thigh_240;
        this.Left_thigh_240 = left_thigh_240;
        this.back_bending = back_bending;
        this.forward_bend = forward_bend;
    }
}
