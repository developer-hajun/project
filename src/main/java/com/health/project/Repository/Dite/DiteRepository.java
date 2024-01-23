package com.health.project.Repository.Dite;

import com.health.project.Entity.Dite.Managing_diet;
import com.health.project.Entity.Microorganism.Microorganism;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiteRepository extends JpaRepository<Managing_diet,Long>,DiteRepositoryCustom {
    @Query(value = "SELECT * FROM MANAGING_DIET WHERE MEMBER_NO = ?1 order by LOCAL_DATE_TIME DESC", nativeQuery = true)
    public List<Managing_diet> findByMemberNo(Long no);

}
