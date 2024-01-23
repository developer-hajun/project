package com.health.project.Repository.Dite;

import com.health.project.Entity.Dite.Managing_diet;
import com.health.project.Repository.Querydsl4RepositorySupport;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.health.project.Entity.Dite.QManaging_diet.managing_diet;
import static com.health.project.Entity.Member.QMember.member;


@Repository
@Getter
public class DiteRepositoryImpl extends Querydsl4RepositorySupport implements DiteRepositoryCustom {
    public DiteRepositoryImpl() {
        super(Managing_diet.class);
    }

    @Override
    public List<List<String>> findLast3Dite(Long no){
        return select(managing_diet.food_name).from(managing_diet)
                .join(member, member)
                .fetchJoin()
                .where(member.no.eq(no))
                .orderBy(managing_diet.localDateTime.desc())
                .limit(3)
                .fetch();
    }
}
