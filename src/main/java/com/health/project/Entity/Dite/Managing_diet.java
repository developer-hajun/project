package com.health.project.Entity.Dite;

import com.health.project.Entity.Member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Managing_diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dite_no", nullable = false)
    private Long no;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;

    @OneToMany(mappedBy = "diet")
    private List<Fat> fatList = new ArrayList<>();
    @OneToMany(mappedBy = "diet")
    private List<Carbohydrate> carbohydrates = new ArrayList<>();
    @OneToMany(mappedBy = "diet")
    private List<Protein> proteins = new ArrayList<>();
    @OneToMany(mappedBy = "diet")
    private List<Nutrients> nutrients = new ArrayList<>();
    public void setMember(Member member){
        this.member = member;
        member.getDiets().add(this);
    }

}
