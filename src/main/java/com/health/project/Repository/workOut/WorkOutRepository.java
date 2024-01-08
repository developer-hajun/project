package com.health.project.Repository.workOut;

import com.health.project.Entity.Member.Member;
import com.health.project.Entity.Workout.QWorkOut;
import com.health.project.Entity.Workout.WorkOut;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOutRepository extends JpaRepository<WorkOut,Long>,WorkOutRepositoryCustom {
}