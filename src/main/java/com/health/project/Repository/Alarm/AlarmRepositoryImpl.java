package com.health.project.Repository.Alarm;
import com.health.project.Entity.Alarm.Alarm;
import com.health.project.Repository.Querydsl4RepositorySupport;
import java.util.List;
import static com.health.project.Entity.Alarm.QAlarm.alarm;
import static com.health.project.Entity.Member.QMember.member;

public class AlarmRepositoryImpl extends Querydsl4RepositorySupport implements AlarmRepositoryCustom {
    public AlarmRepositoryImpl() {
        super(Alarm.class);
    }
    @Override
    public List<Alarm> findByMember_no(Long no) {
        return selectFrom(alarm).join(alarm.member,member).fetchJoin().orderBy(alarm.localDateTime.desc()).where(member.no.eq(no)).fetch();
    }
    @Override
    public Boolean findNotview(Long no) {
        Long count = select(alarm.count()).from(alarm).join(alarm.member, member).fetchJoin().where(member.no.eq(no), alarm.view.eq(false)).fetchOne();
        if(0 < count) return true;
        else return false;
    }
}
