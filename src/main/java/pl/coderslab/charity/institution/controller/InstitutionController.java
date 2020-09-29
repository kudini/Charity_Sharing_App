package pl.coderslab.charity.institution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.institution.entity.Institution;
import pl.coderslab.charity.institution.service.InstitutionService;

@Controller
public class InstitutionController {
    private final InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }
    @GetMapping("/institution")
    public String instituionPanel(Model model){
        return "institution-panel";
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
