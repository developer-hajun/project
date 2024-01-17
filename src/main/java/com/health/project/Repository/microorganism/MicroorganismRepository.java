package com.health.project.Repository.microorganism;

import com.health.project.Entity.Microorganism.Microorganism;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MicroorganismRepository extends JpaRepository<Microorganism,Long>,MicroorganismRepositoryCustom {
    @Query(value = "SELECT * FROM MICROORGANISM WHERE MEMBER_NO = ?1", nativeQuery = true)
    public List<Microorganism> findByMemberNo(Long no);
    public Optional<Microorganism> findByName(String name);
}

