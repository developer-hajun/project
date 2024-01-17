package com.health.project.Entity.Dite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.health.project.Entity.Member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Fat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fat_no",nullable = false)
    private Long no;
    private String name;
    private int content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diet_no")
    @JsonIgnore
    private Managing_diet diet;

    public void setDiet(Managing_diet diet){
        this.diet = diet;
        diet.getFatList().add(this);
    }
}
