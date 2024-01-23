package com.health.project.Repository.physical;

import com.health.project.Entity.Physical_test.BasicPhysical;
import com.health.project.Repository.Querydsl4RepositorySupport;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.health.project.Entity.Member.QMember.member;
import static com.health.project.Entity.Physical_test.QBasicPhysical.basicPhysical;


@Repository
@Getter
public class BasicPhysicalRepositoryImpl extends Querydsl4RepositorySupport implements BasicPhysicalRepositoryCustom {
    private final JPAQueryFactory query;
    public BasicPhysicalRepositoryImpl(EntityManager em) {
        super(BasicPhysical.class);
        this.query = new JPAQueryFactory(em);

    }
    @Override
    public Tuple findAllAvg() {
        return query.select(
                basicPhysical.grap.avg(),
                basicPhysical.back.avg(),
                basicPhysical.Right_flat_60.avg(),
                basicPhysical.Left_flat_60.avg(),
                basicPhysical.Right_thigh_60.avg(),
                basicPhysical.Left_thigh_60.avg(),
                basicPhysical.sit_up.avg(),
                basicPhysical.push_up.avg(),
                basicPhysical.Right_flat_240.avg(),
                basicPhysical.Left_flat_240.avg(),
                basicPhysical.Right_thigh_240.avg(),
                basicPhysical.Left_thigh_240.avg(),
                basicPhysical.back_bending.avg(),
                basicPhysical.forward_bend.avg()
        ).from(basicPhysical).fetch().get(0);
    }
    @Override
    public Optional<BasicPhysical> findLastPhysical(Long no){
        BasicPhysical basicPhysical1 = selectFrom(basicPhysical)
                .join(member, member)
                .fetchJoin()
                .where(member.no.eq(no))
                .orderBy(basicPhysical.no.desc())
                .limit(1)
                .fetchOne();
        return Optional.ofNullable(basicPhysical1);
    }
}
