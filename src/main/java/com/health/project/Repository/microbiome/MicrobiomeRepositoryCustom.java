package com.health.project.Repository.microbiome;

import com.health.project.Entity.Member.Member;
import com.health.project.Entity.Microorganism.Microbiome;

import java.util.Optional;

public interface MicrobiomeRepositoryCustom {
    public Optional<Microbiome> findWithMicroorganism(Long no);


}
