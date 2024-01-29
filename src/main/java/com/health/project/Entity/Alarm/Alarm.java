package com.health.project.Entity.Alarm;

import com.health.project.Entity.Member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

import static com.health.project.Entity.Member.QMember.member;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Alarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alarm_no")
    private Long no;

    private String detail;

    private Boolean view =false;

    @CreationTimestamp
    private LocalDateTime localDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;

    public Alarm(String detail) {
        this.detail = detail;
    }

    public void setMember(Member member) {
        this.member = member;
        member.getAlarms().add(this);
    }
}
