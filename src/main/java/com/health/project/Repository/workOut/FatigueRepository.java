package com.health.project.Repository.workOut;

import com.health.project.Entity.Physical_test.BasicPhysical;
import com.health.project.Entity.Workout.Fatigue;
import com.health.project.Entity.Workout.WorkOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FatigueRepository extends JpaRepository<Fatigue,Long> {
    @Query(value = "SELECT * FROM Fatigue WHERE MEMBER_NO = ?1 order by LOCAL_DATE_TIME DESC", nativeQuery = true)
    public List<Fatigue> findByMemberNo(Long no);
}