package com.health.project.Repository.physical;


import com.health.project.Entity.Physical_test.BasicPhysical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasicPhysicalRepository extends JpaRepository<BasicPhysical,Long>,BasicPhysicalRepositoryCustom {
    @Query(value = "SELECT * FROM BASICPHYSICAL WHERE MEMBER_NO = ?1 order by LOCAL_DATE_TIME DESC", nativeQuery = true)
    public List<BasicPhysical> findByMemberNo(Long no);
}
