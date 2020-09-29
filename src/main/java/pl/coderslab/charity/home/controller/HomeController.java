package pl.coderslab.charity.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.entity.Donation;
import pl.coderslab.charity.donation.service.DonationService;
import pl.coderslab.charity.donation.service.DonationServiceImpl;
import pl.coderslab.charity.home.model.HomePageInfoModel;
import pl.coderslab.charity.institution.entity.Institution;
import pl.coderslab.charity.institution.service.InstitutionService;

import java.util.List;


@Controller
public class HomeController {

    DonationService donationService;
    InstitutionService institutionService;

    public HomeController(DonationService donationService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    private long sumAllGifts(){
        return donationService.countDonations();
    }
    private List<Institution> institutionsInDatabase(){

        return institutionService.findAllInstitution();
    }
    private Long sumAllBags(){
        return donationService.countQuantity();
    }


    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("info",new HomePageInfoModel(sumAllBags(),sumAllGifts(),institutionsInDatabase()));
        return "index";
    }
    @RequestMapping("/403")
    public String accesDenied(){
        return "index";
    }

}
