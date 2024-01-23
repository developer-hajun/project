package com.health.project.Entity.Workout;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.health.project.Entity.Member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.sound.sampled.Port;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WorkOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_no",nullable = false)
    private Long no;

    @CreationTimestamp
    private LocalDateTime localDateTime;

    @Enumerated(EnumType.STRING)
    private WorkoutType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    @JsonIgnore
    private Member member;

    public void setMember(Member member){
        this.member = member;
        member.getWorkOuts().add(this);
    }

    public WorkOut(WorkoutType type) {
        this.type = type;
    }
}
