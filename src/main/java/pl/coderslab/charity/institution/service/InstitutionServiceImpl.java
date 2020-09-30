package pl.coderslab.charity.institution.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.institution.dto.InstitutionDto;
import pl.coderslab.charity.institution.entity.Institution;
import pl.coderslab.charity.institution.repository.InstitutionRepository;
import pl.coderslab.charity.user.dto.UserDto;

import java.util.ArrayList;
import java.util.List;
@Service
public class InstitutionServiceImpl implements InstitutionService {
    InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> findAllInstitution() {
        return institutionRepository.findAll();
    }

}
