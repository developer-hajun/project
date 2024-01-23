package com.health.project;

import com.health.project.Entity.Physical_test.BasicPhysical;
import com.health.project.Entity.Physical_test.QBasicPhysical;
import com.health.project.Repository.physical.BasicPhysicalRepository;
import com.querydsl.core.Tuple;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class FCHECK {
    @Autowired BasicPhysicalRepository basicPhysicalRepository;
    @Autowired EntityManager em;
//    @Test
//    public void check(){
//        BasicPhysical basicPhysical = new BasicPhysical();
//        basicPhysical.setBack(50.1F);
//        BasicPhysical basicPhysical2 = new BasicPhysical();
//        basicPhysical2.setBack(50.1F);
//        BasicPhysical basicPhysical3 = new BasicPhysical();
//        basicPhysical3.setBack(50.1F);
//        BasicPhysical basicPhysical4 = new BasicPhysical();
//        basicPhysical4.setBack(50.1F);
//        em.persist(basicPhysical);
//        em.persist(basicPhysical2);
//        em.persist(basicPhysical3);
//        em.persist(basicPhysical4);
//        em.clear();
//        Tuple allAvg = basicPhysicalRepository.findAllAvg();
//        Double v = allAvg.get(QBasicPhysical.basicPhysical.Left_flat_60.avg());
//        System.out.println(v);
//    }

}
