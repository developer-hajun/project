package com.health.project.Repository.workOut;

import com.health.project.Entity.Microorganism.Microbiome;
import com.health.project.Entity.Workout.WorkOut;

import java.util.Optional;

public interface WorkOutRepositoryCustom {
    public Optional<WorkOut> findWithMember(Long no);


}
