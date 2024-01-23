package com.health.project.Repository.workOut;

import com.health.project.Entity.Workout.Fatigue;
import com.health.project.Entity.Workout.Injury;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InjuryRepository extends JpaRepository<Injury,Long> {
    @Query(value = "SELECT * FROM INJURY WHERE MEMBER_NO = ?1 order by LOCAL_DATE_TIME DESC", nativeQuery = true)
    public List<Injury> findByMemberNo(Long no);
}