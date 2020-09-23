package pl.coderslab.charity.donation.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.category.service.CategoryService;
import pl.coderslab.charity.donation.entity.Donation;
import pl.coderslab.charity.donation.model.DonationFormModel;
import pl.coderslab.charity.donation.service.DonationService;
import pl.coderslab.charity.home.model.HomePageInfoModel;
import pl.coderslab.charity.institution.service.InstitutionService;

@Controller
public class DonationController {
    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    public DonationController(CategoryService categoryService, InstitutionService institutionService, DonationService donationService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping("/donate")
    public String donationForm(Model model){
        DonationFormModel donationFormModel = new DonationFormModel(institutionService.findAllInstitution(),categoryService.findAllCategories());
        model.addAttribute("donationmodel",donationFormModel);
        model.addAttribute("donation",new Donation());
        JSONPObject jsonpObject = new JSONPObject("institution",donationFormModel.getInstitutions());


        return "form";
    }
    @PostMapping("/donate")
    public String donationForm(@ModelAttribute Donation donation){
        donationService.saveDonation(donation);
        return "form-confirmation";

    }
}
