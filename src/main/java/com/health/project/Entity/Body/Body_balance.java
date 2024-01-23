package com.health.project.Entity.Body;

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

    public Body_balance(float right_arm, float left_arm, float body, float right_leg, float left_leg) {
        this.right_arm = right_arm;
        this.left_arm = left_arm;
        this.body = body;
        this.right_leg = right_leg;
        this.left_leg = left_leg;
    }
}
