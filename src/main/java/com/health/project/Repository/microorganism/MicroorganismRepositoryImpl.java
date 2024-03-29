package com.health.project.Repository.microorganism;

import com.health.project.Entity.Microorganism.Microorganism;
import com.health.project.Repository.Querydsl4RepositorySupport;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import static com.health.project.Entity.Member.QMember.member;
import static com.health.project.Entity.Microorganism.QMicroorganism.microorganism;


@Repository
@Getter
public class MicroorganismRepositoryImpl extends Querydsl4RepositorySupport implements MicroorganismRepositoryCustom {

    public MicroorganismRepositoryImpl() {
        super(Microorganism.class);
    }

    @Override
    public List<Microorganism> findWithMember(Long no) {
        return selectFrom(microorganism).join(microorganism.member, member).fetchJoin().where(member.no.eq(no)).fetch();
    }
    public Optional<Microorganism> findWithMemberandId(Long no,String name){
        Microorganism microorganism1 = selectFrom(microorganism).join(microorganism.member, member).fetchJoin().where(member.no.eq(no), microorganism.name.eq(name)).fetchOne();
        return Optional.ofNullable(microorganism1);
    }

}
