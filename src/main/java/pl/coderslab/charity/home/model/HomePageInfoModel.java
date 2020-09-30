package pl.coderslab.charity.home.model;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.institution.dto.InstitutionDto;
import pl.coderslab.charity.institution.entity.Institution;

import java.util.List;

@Getter
@Setter
public class HomePageInfoModel {


    private Long bags;
    private Long donations;
    private List<Institution> institutions;

    public HomePageInfoModel(Long bags, Long donations, List<Institution> institutions) {
        this.bags = bags;
        this.donations = donations;
        this.institutions = institutions;
    }
}
