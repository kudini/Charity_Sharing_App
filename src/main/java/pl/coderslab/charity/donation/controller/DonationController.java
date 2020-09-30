package pl.coderslab.charity.donation.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.category.service.CategoryService;
import pl.coderslab.charity.donation.converter.DonationConversion;
import pl.coderslab.charity.donation.dto.DonationDto;
import pl.coderslab.charity.donation.entity.Donation;
import pl.coderslab.charity.donation.model.DonationFormModel;
import pl.coderslab.charity.donation.service.DonationService;
import pl.coderslab.charity.institution.service.InstitutionService;
import pl.coderslab.charity.user.model.CurrentUser;

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
    public String donationForm(Model model) {
        DonationFormModel donationFormModel = new DonationFormModel(institutionService.findAllInstitution(), categoryService.findAllCategories());
        model.addAttribute("donationmodel", donationFormModel);
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/donate")
    public String donationForm(@AuthenticationPrincipal CurrentUser currentUser, @ModelAttribute Donation donation) {
        donation.setDonor(currentUser.getUser());
        donationService.saveDonation(donation);
        return "form-confirmation";

    }
}
