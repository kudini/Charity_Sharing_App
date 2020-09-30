package pl.coderslab.charity.institution.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.institution.entity.Institution;

import java.util.List;
@Service
public interface InstitutionService {
    public List <Institution> findAllInstitution();
    public Institution findById(Long id);
}
