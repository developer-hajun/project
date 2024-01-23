package com.health.project.Entity.Dite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.health.project.Entity.Member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
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
    @JsonIgnore
    private Member member;

    @CreationTimestamp
    private LocalDateTime localDateTime;

    @ElementCollection
    private List<String> food_name;
    public void setMember(Member member){
        this.member = member;
        member.getDiets().add(this);
    }

    public Managing_diet(List<String> food_name) {
        this.food_name = food_name;
    }
    //    @OneToMany(mappedBy = "diet")
//    private List<Fat> fatList = new ArrayList<>();
//    @OneToMany(mappedBy = "diet")
//    private List<Carbohydrate> carbohydrates = new ArrayList<>();
//    @OneToMany(mappedBy = "diet")
//    private List<Protein> proteins = new ArrayList<>();
//    @OneToMany(mappedBy = "diet")
//    private List<Nutrients> nutrients = new ArrayList<>();
}
