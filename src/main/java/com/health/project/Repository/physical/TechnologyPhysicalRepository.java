package com.health.project.Repository.physical;


import com.health.project.Entity.Physical_test.TechnologyPhysical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologyPhysicalRepository extends JpaRepository<TechnologyPhysical,Long>, TechnologyPhysicalRepositoryCustom {
    @Query(value = "SELECT * FROM TechnologyPhysical WHERE MEMBER_NO = ?1 order by LOCAL_DATE_TIME DESC", nativeQuery = true)
    public List<TechnologyPhysical> findByMemberNo(Long no);
}
