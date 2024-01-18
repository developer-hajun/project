package templates.임시제외.microbiome;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Microbiome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "microbiome_no")
    private Long no;

    private String name;



    private String explanation;

    @OneToMany(mappedBy = "microbiome")
    private List<Microorganism> microorganismList = new ArrayList<>();
}
