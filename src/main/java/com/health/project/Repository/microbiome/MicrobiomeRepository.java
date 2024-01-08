package com.health.project.Repository.microbiome;

import com.health.project.Entity.Microorganism.Microbiome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicrobiomeRepository extends JpaRepository<Microbiome,Long>,MicrobiomeRepositoryCustom {
}