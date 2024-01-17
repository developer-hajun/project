package com.health.project.Entity.Workout;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.health.project.Entity.Member.Member;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class WorkOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_no",nullable = false)
    private Long no;

    @Enumerated(EnumType.STRING)
    private WorkOutTime workOutTime;

    @Enumerated(EnumType.STRING)
    private WorkoutType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    @JsonIgnore
    private Member member;

    @OneToMany(mappedBy = "workOut")
    private List<injury> injuryList = new ArrayList<>();

    @OneToMany(mappedBy = "workOut")
    private List<Fatigue> fatigues = new ArrayList<>();
    public void setMember(Member member){
        this.member = member;
        member.getWorkOuts().add(this);
    }
}
