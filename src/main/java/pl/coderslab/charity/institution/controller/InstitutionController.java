package pl.coderslab.charity.institution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.category.service.CategoryService;
import pl.coderslab.charity.donation.service.DonationService;
import pl.coderslab.charity.home.model.HomePageInfoModel;
import pl.coderslab.charity.institution.dto.InstitutionDto;
import pl.coderslab.charity.institution.entity.Institution;
import pl.coderslab.charity.institution.service.InstitutionService;

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
    public String instituionPanel(Model model) {
        model.addAttribute("info", new HomePageInfoModel(donationService.countQuantity(), donationService.countDonations(), institutionService.findAllInstitution()));
        return "institutions";
    }

    @GetMapping("/institution/{id}")
    public String instituionDetails(@PathVariable Long id, Model model) {
        model.addAttribute("institution", institutionService.findById(id));
        return "institutions_details";
    }

    @GetMapping("/institution/{id}/edit")
    public String editInstitutionGet(@PathVariable Long id, Model model) {
        model.addAttribute("institutionDto",new InstitutionDto(institutionService.findById(id)));
        return "institution-add";
    }

    @PostMapping("/institution/{id}/edit")
    public String editInstitutionPost(@PathVariable Long id, @ModelAttribute InstitutionDto institutionDto) {
        institutionService.save(new Institution(institutionDto));
        return "institution-add";
    }

    @GetMapping("/institution/{id}/delete")
    public String deleteInstitution(@PathVariable Long id, Model model) {
        institutionService.delete(institutionService.findById(id));
        return "redirect:/institution";
    }

    @GetMapping("/institution/add")
    public String addInstitutionGet(Model model) {
        model.addAttribute("institutionDto",new InstitutionDto());
        return "institution-add";
    }

    @PostMapping("/institution/add")
    public String addInstitutionPost(@ModelAttribute InstitutionDto institutionDto) {
        institutionService.save(new Institution(institutionDto));
        return "institution-add";
    }

}
