package com.health.project.Repository.microorganism;


import com.health.project.Entity.Microorganism.Microorganism;

import java.util.List;
import java.util.Optional;

public interface MicroorganismRepositoryCustom {
    public Optional<Microorganism> findWithMemberandId(Long no,String name);
    public List<Microorganism> findWithMember(Long no);


}
