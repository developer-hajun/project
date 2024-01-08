package com.health.project.Repository.inbody;


import com.health.project.Entity.Body.inBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InBodyRepository extends JpaRepository<inBody,Long> {
}
