package pl.coderslab.charity.institution.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.institution.entity.Institution;
import pl.coderslab.charity.institution.repository.InstitutionRepository;

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

    @Override
    public Institution findById(Long id) {
        return institutionRepository.findById(id).get();
    }

    @Override
    public void delete(Institution institution) {
        institutionRepository.delete(institution);
    }

    @Override
    public void save(Institution institution) {
        institutionRepository.save(institution);
    }

}
