package pl.coderslab.charity.institution.entity;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.institution.dto.InstitutionDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    public Institution() {
    }

    public Institution(InstitutionDto institutionDto) {
        this.id = institutionDto.getId();
        this.name = institutionDto.getName();
        this.description = institutionDto.getDescription();
    }
}
