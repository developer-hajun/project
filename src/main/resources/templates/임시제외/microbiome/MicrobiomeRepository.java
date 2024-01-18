package templates.임시제외.microbiome;

import com.health.project.Entity.Microorganism.Hazard;
import com.health.project.Entity.Microorganism.Microbiome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MicrobiomeRepository extends JpaRepository<Microbiome,Long>,MicrobiomeRepositoryCustom {
    public Optional<Microbiome> findByName(String name);
    public List<Microbiome> findByHazard(Hazard hazard);

}