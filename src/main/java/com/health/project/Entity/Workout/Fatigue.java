package com.health.project.Entity.Workout;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.health.project.Entity.Member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Fatigue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Fatigue_no",nullable = false)
    private Long no;

    @Enumerated(EnumType.STRING)
    private BodyPart part;

    private int persistent;

    @CreationTimestamp
    private LocalDateTime localDateTime;
    public Fatigue(BodyPart part, int persistent) {
        this.part = part;
        this.persistent = persistent;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    @JsonIgnore
    private Member member;
    public void setMember(Member member){
        this.member = member;
        member.getFatigues().add(this);
    }
}
