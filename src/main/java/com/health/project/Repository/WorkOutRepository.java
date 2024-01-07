package com.health.project.Repository;

import com.health.project.Entity.Member.Member;
import com.health.project.Entity.Workout.QWorkOut;
import com.health.project.Entity.Workout.WorkOut;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.health.project.Entity.Member.QMember.member;
import static com.health.project.Entity.Workout.QWorkOut.workOut;

@Repository
@Getter
public class WorkOutRepository{
    private final EntityManager em;
    private final JPAQueryFactory query;
    public WorkOutRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }
    public void save(WorkOut workOut){
        em.persist(workOut);
    }
    public List<WorkOut> findAll(){
        return query.selectFrom(workOut).fetch();
    }
    public Optional<WorkOut> findByNo(Long no){
        return Optional.ofNullable(em.find(WorkOut.class, no));
    }
    public Optional<WorkOut> findWithMember(Long no){
        WorkOut workOut1 = query.selectFrom(workOut).join(workOut.member, member).fetchJoin().fetchOne();
        return Optional.ofNullable(workOut1);
    }
}
