package com.health.project.Repository.workOut;

import com.health.project.Entity.Workout.WorkOut;

import java.util.List;

public interface WorkOutRepositoryCustom {
    public List<WorkOut> findWorkOut(Long no);


}
