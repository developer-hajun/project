package templates.임시제외.microbiome;

import com.health.project.DTO.SerachCondition.MicrobiomeSearchCondition;
import com.health.project.Entity.Microorganism.Microbiome;

import java.util.List;
import java.util.Optional;

public interface MicrobiomeRepositoryCustom {
    public Optional<Microbiome> findWithMicroorganism(Long no);
    public List<Microbiome> WhereParam(MicrobiomeSearchCondition condition);
}
