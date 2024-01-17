package com.health.project.Entity.Workout;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.health.project.Entity.Member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

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

    public Fatigue(BodyPart part, int persistent) {
        this.part = part;
        this.persistent = persistent;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_no")
    @JsonIgnore
    private WorkOut workOut;

    public void setWorkOut(WorkOut workOut){
        this.workOut = workOut;
        workOut.getFatigues().add(this);
    }
}
