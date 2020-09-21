package pl.coderslab.charity.donation.model;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.category.entity.Category;
import pl.coderslab.charity.donation.entity.Donation;
import pl.coderslab.charity.institution.entity.Institution;

import java.util.List;

@Getter
@Setter
public class DonationFormModel {
    private List<Institution> institutions;
    private List<Category> categoryList;

    public DonationFormModel( List<Institution> institutions, List<Category> categoryList) {
        this.institutions = institutions;
        this.categoryList = categoryList;
    }
}
