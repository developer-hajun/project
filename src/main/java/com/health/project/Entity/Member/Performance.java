package com.health.project.Entity.Member;

import jakarta.persistence.Embeddable;
import org.hibernate.annotations.ColumnDefault;

@Embeddable
public class Performance {
    @ColumnDefault("0")
    private float height;
    @ColumnDefault("0")
    private float weight;
    @ColumnDefault("0")
    private int deadLift;
    @ColumnDefault("0")
    private int squat;
    @ColumnDefault("0")
    private int benchPress;
}
