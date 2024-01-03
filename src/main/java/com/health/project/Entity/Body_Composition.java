package com.health.project.Entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Body_Composition {
    private float water;
    private float protein;
    private float mineral;
    private float fat;
}
