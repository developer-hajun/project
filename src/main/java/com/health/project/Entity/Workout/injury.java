package com.health.project.Entity.Workout;

import com.health.project.Entity.Member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

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

    public injury(BodyPart part, String injuryName, int persistent) {
        this.part = part;
        this.injuryName = injuryName;
        this.persistent = persistent;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_no")
    private WorkOut workOut;

    public void setWorkOut(WorkOut workOut){
        this.workOut = workOut;
        workOut.getInjuryList().add(this);
    }
}
