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


@Controller
public class HomeController {

    DonationService donationService;
    InstitutionService institutionService;

    public HomeController(DonationService donationService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    private int sumAllGifts(){

        return donationService.findAllDonations().size();
    }
    private Institution[] institutionsInDatabase(){

        return institutionService.findAllInstitution().toArray(new Institution[0]);
    }
    private int sumAllBags(){
        return donationService.findAllDonations().stream()
                .mapToInt(Donation::getQuantity)
                .sum();
    }


    @RequestMapping("/")
    public String homeAction(Model model){

        model.addAttribute("info",new HomePageInfoModel(sumAllBags(),sumAllGifts(),institutionsInDatabase()));
        return "index";
    }
}
