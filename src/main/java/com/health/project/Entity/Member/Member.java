package com.health.project.Entity.Member;

import com.health.project.Entity.Body.inBody;
import com.health.project.Entity.Dite.Managing_diet;
import com.health.project.Entity.Microorganism.Microorganism;
import com.health.project.Entity.Physical_test.BasicPhysical;
import com.health.project.Entity.Physical_test.TechnologyPhysical;
import com.health.project.Entity.Workout.Fatigue;
import com.health.project.Entity.Workout.WorkOut;
import com.health.project.Entity.Workout.Injury;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no",nullable = false)
    private Long no;

    @Column(nullable = false,length = 20,name = "member_id",unique = true)
    private String id;

    @Column(nullable = false,name = "member_password")
    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("user")
    private MemberRoll roll;

    @Embedded
    private Performance performance;

    public Member(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    @OneToMany(mappedBy = "member")
    private List<BasicPhysical> basicPhysicalList = new ArrayList<>(); //기초체력
    @OneToMany(mappedBy = "member")
    private List<TechnologyPhysical> technologyPhysicals  = new ArrayList<>(); //기술체력
    @OneToMany(mappedBy = "member")
    private List<Microorganism> microorganism = new ArrayList<>(); //미생물
    @OneToMany(mappedBy = "member")
    private List<Managing_diet> diets = new ArrayList<>(); //식단
    @OneToMany(mappedBy = "member")
    private List<WorkOut> workOuts = new ArrayList<>();//운동
    @OneToMany(mappedBy = "member")
    private List<inBody> inBodies = new ArrayList<>();//신체조성
    @OneToMany(mappedBy = "member")
    private List<Injury> injuries = new ArrayList<>();//부상
    @OneToMany(mappedBy = "member")
    private List<Fatigue> fatigues = new ArrayList<>();//피로도

}
