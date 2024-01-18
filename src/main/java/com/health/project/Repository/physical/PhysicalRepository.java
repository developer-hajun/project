package com.health.project.Repository.physical;


import com.health.project.Entity.Microorganism.Microorganism;
import com.health.project.Entity.Physical_test.Physical;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhysicalRepository extends JpaRepository<Physical,Long> {
    @Query(value = "SELECT * FROM PHYSICAL WHERE MEMBER_NO = ?1", nativeQuery = true)
    public List<Physical> findByMemberNo(Long no);
}
