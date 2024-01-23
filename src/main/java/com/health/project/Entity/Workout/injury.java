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
public class injury {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "injury_no",nullable = false)
    private Long no;

    @Enumerated(EnumType.STRING)
    private BodyPart part;

    private String injuryName;

    private int persistent;
    @CreationTimestamp
    private LocalDateTime localDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    @JsonIgnore
    private Member member;
    public injury(BodyPart part, String injuryName, int persistent) {
        this.part = part;
        this.injuryName = injuryName;
        this.persistent = persistent;
    }
    public void setMember(Member member){
        this.member = member;
        member.getInjuries().add(this);
    }
}
