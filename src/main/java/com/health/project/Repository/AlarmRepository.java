package com.health.project.Repository;

import com.health.project.Entity.Alarm.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmRepository extends JpaRepository<Alarm,Long>, AlarmRepositoryCustom {
}
