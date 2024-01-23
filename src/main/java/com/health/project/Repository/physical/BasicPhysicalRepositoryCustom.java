package com.health.project.Repository.physical;

import com.health.project.Entity.Physical_test.BasicPhysical;
import com.querydsl.core.Tuple;

import java.util.Optional;

public interface BasicPhysicalRepositoryCustom{
    Tuple findAllAvg();
    Optional<BasicPhysical> findLastPhysical(Long no);
}
