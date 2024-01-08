package com.health.project.Repository.microorganism;

import com.health.project.Entity.Microorganism.Microbiome;
import com.health.project.Entity.Microorganism.Microorganism;

import java.util.Optional;

public interface MicroorganismRepositoryCustom {
    public Optional<Microorganism> findWithMicrobiome(Long no);
    public Optional<Microorganism> findWithMember(Long no);


}
