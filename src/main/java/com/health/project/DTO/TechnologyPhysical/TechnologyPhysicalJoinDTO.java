package com.health.project.DTO.TechnologyPhysical;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TechnologyPhysicalJoinDTO {
    private float power;
    private float powerMax;
    private float powerKg;
    private float SideStep;
    private float close_eye_right;
    private float close_eye_left;
    private float light_reaction;
    private float blaze_pot;
}
