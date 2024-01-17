package com.health.project.Repository.workOut;

import com.health.project.Entity.Microorganism.Microbiome;
import com.health.project.Entity.Workout.WorkOut;
import com.health.project.Repository.Querydsl4RepositorySupport;
import com.health.project.Repository.microbiome.MicrobiomeRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.health.project.Entity.Member.QMember.member;
import static com.health.project.Entity.Microorganism.QMicrobiome.microbiome;
import static com.health.project.Entity.Microorganism.QMicroorganism.microorganism;
import static com.health.project.Entity.Workout.QWorkOut.workOut;


@Repository
@Getter
public class WorkOutRepositoryImpl extends Querydsl4RepositorySupport implements WorkOutRepositoryCustom {


    public WorkOutRepositoryImpl() {
        super(WorkOut.class);
    }
    @Override
    public Optional<WorkOut> findWithMember(Long no){
        WorkOut workOut1 = selectFrom(workOut).join(workOut.member, member).fetchJoin().fetchOne();
        return Optional.ofNullable(workOut1);
    }

}
