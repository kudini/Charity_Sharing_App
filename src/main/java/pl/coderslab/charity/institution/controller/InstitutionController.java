package pl.coderslab.charity.institution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.category.service.CategoryService;
import pl.coderslab.charity.donation.service.DonationService;
import pl.coderslab.charity.home.model.HomePageInfoModel;
import pl.coderslab.charity.institution.service.InstitutionService;
import pl.coderslab.charity.institution.service.InstitutionServiceImpl;

@Controller
public class InstitutionController {
    private final InstitutionService institutionService;
    private final CategoryService categoryService;
    private final DonationService donationService;

    public InstitutionController(InstitutionService institutionService, CategoryService categoryService, DonationService donationService) {
        this.institutionService = institutionService;
        this.categoryService = categoryService;
        this.donationService = donationService;
    }
    @GetMapping("/institution")
    public String instituionPanel(Model model){
        model.addAttribute("info",new HomePageInfoModel( donationService.countQuantity(), donationService.countDonations(),institutionService.findAllInstitution()));
        return "institutions";
    }
    @GetMapping("/institution/{id}/edit")
    public String editInstitutionGet(@PathVariable Long id, Model model){
        return "institution-add";
    }
    @PostMapping("/institution/{id}/edit")
    public String editInstitutionPost(@PathVariable Long id, Model model){
        return "institution-add";
    }
    @GetMapping("/institution/{id}/delete")
    public String deleteInstitution(@PathVariable Long id,Model model){
        return "redirect:/institution";
    }
    @GetMapping("/institution/add")
    public String addInstitutionGet(Model model){
        return "institution-add";
    }
    @PostMapping("/institution/add")
    public String addInstitutionPost(Model model){
        return "institution-add";
    }

}
