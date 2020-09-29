package pl.coderslab.charity.institution.converter;

import pl.coderslab.charity.institution.dto.InstitutionDto;
import pl.coderslab.charity.institution.entity.Institution;

public class InstitutionConversion {
    public static Institution convertInstitutionDtoToInstitution(InstitutionDto institutionDto){
        return new Institution(institutionDto);
    }
    public static InstitutionDto convertInstitutionToInstitutionDto(Institution institution){
        return new InstitutionDto(institution);
    }
}
