package com.health.project.Repository.inbody;


import com.health.project.Entity.Body.inBody;
import com.health.project.Entity.Microorganism.Microorganism;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface
InBodyRepository extends JpaRepository<inBody,Long>,InbodyRepositoryCustom{
    @Query(value = "SELECT * FROM INBODY WHERE MEMBER_NO = ?1 order by LOCAL_DATE_TIME DESC", nativeQuery = true)
    public List<inBody> findByMemberNo(Long no);
}
