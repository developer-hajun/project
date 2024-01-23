package com.health.project.Repository.physical;

import com.health.project.Entity.Physical_test.QTechnologyPhysical;
import com.health.project.Entity.Physical_test.TechnologyPhysical;
import com.health.project.Repository.Querydsl4RepositorySupport;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.health.project.Entity.Member.QMember.member;
import static com.health.project.Entity.Physical_test.QTechnologyPhysical.technologyPhysical;


@Repository
@Getter
public class TechnologyPhysicalRepositoryImpl extends Querydsl4RepositorySupport implements TechnologyPhysicalRepositoryCustom {
    private final JPAQueryFactory query;
    public TechnologyPhysicalRepositoryImpl(EntityManager em) {
        super(TechnologyPhysical.class);
        this.query = new JPAQueryFactory(em);
    }
    @Override
    public Tuple findAllAvg() {
        return query.select(
                QTechnologyPhysical.technologyPhysical.power.avg(),
                QTechnologyPhysical.technologyPhysical.powerMax.avg(),
                technologyPhysical.powerKg.avg(),
                technologyPhysical.SideStep.avg(),
                technologyPhysical.close_eye_right.avg(),
                technologyPhysical.close_eye_left.avg(),
                technologyPhysical.light_reaction.avg(),
                technologyPhysical.blaze_pot.avg()
        ).from(technologyPhysical).fetch().get(0);
    }
    @Override
    public Optional<TechnologyPhysical> findLastPhysical(Long no){
        TechnologyPhysical technologyPhysical1 = selectFrom(technologyPhysical)
                .join(member, member)
                .fetchJoin()
                .where(member.no.eq(no))
                .orderBy(technologyPhysical.no.desc())
                .limit(1)
                .fetchOne();
        return Optional.ofNullable(technologyPhysical1);
    }
}
