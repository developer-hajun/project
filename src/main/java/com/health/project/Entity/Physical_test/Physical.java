package com.health.project.Entity.Physical_test;


import com.health.project.Entity.Member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Physical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "physical_no")
    private Long no;
    private float A; //체전굴
    private float B; //좌전굴
    private float C; // 제자리 멀리뛰기
    private int sit_up;
    private float E; //왕복 달리기
    private float F; //서전트 점프
    private float G; // 핸드볼 던지기
    private float H; //메디신볼 던지기
    private float I; //Z런
    private float J; //100M달리기

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;
    public void setMember(Member member){
        this.member = member;
        member.getPhysicalList().add(this);
    }
}
