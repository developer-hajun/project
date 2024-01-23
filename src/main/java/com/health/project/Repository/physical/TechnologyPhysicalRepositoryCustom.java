package com.health.project.Repository.physical;

import com.health.project.Entity.Physical_test.TechnologyPhysical;
import com.querydsl.core.Tuple;

import java.util.Optional;

public interface TechnologyPhysicalRepositoryCustom {
    Tuple findAllAvg();
    Optional<TechnologyPhysical> findLastPhysical(Long no);
}
