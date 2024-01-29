package com.health.project.Repository;

import com.health.project.Entity.Alarm.Alarm;

import java.util.List;

public interface AlarmRepositoryCustom {
    List<Alarm> findByMember_no(Long no);
    Boolean findNotview(Long no);
}
