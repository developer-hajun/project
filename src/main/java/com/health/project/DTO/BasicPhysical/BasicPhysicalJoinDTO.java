package com.health.project.DTO.BasicPhysical;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class BasicPhysicalJoinDTO {
    private float grap; //악력
    private float back; //근력
    private float Right_flat_60;//우대퇴폄근60
    private float Left_flat_60; //좌대퇴평근60
    private float Right_thigh_60; //우대퇴굽힙근60
    private float Left_thigh_60; //좌대퇴굽힙근60
    private float sit_up; //윗몸 일으키기
    private float push_up; //팔굽혀펴기
    private float Right_flat_240; //우대퇴폄근240
    private float Left_flat_240; //좌대퇴평근240
    private float Right_thigh_240; //우대퇴굽힙근240
    private float Left_thigh_240; //좌대퇴굽힙근240
    private float back_bending; //체후굴
    private float forward_bend; //좌전굴
}
