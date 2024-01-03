package com.health.project.Entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Body_balance {
    private float right_arm;
    private float left_arm;
    private float body;
    private float right_leg;
    private float left_leg;

}
