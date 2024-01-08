package com.health.project.Repository.physical;


import com.health.project.Entity.Physical_test.Physical;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhysicalRepository extends JpaRepository<Physical,Long> {
}
