package pl.coderslab.charity.institution.dto;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.institution.entity.Institution;

@Getter
@Setter
public class InstitutionDto {
    private Long id;
    private String name;
    private String description;

    public InstitutionDto() {
    }

    public InstitutionDto(Institution institution) {
        this.id = institution.getId();
        this.name = institution.getName();
        this.description = institution.getDescription();
    }
}
