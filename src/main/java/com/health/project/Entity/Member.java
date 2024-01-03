package com.health.project.Entity;

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

    @Column(nullable = false,length = 20,name = "member_password")
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
    private List<Physical> physicalList = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Microorganism> microorganism = new ArrayList<>();
}
