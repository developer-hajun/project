package com.health.project.Entity.Body;

import com.health.project.DTO.JoinDTO.Inbody.Body_balance_Join_Dto;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Body_balance {
    private float right_arm;
    private float left_arm;
    private float body;
    private float right_leg;
    private float left_leg;

    public Body_balance(Body_balance_Join_Dto balanceJoinDto) {
        this.right_arm = balanceJoinDto.getRight_arm();
        this.left_arm = balanceJoinDto.getLeft_arm();
        this.body = balanceJoinDto.getBody();
        this.right_leg = balanceJoinDto.getRight_leg();
        this.left_leg = balanceJoinDto.getLeft_leg();
    }
}
