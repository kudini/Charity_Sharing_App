package pl.coderslab.charity.donation.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.donation.entity.Donation;
import pl.coderslab.charity.donation.repository.DonationRepository;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService{
    DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public List<Donation> findAllDonations() {
        List<Donation> donationList=donationRepository.findAll();

        return donationList;
    }
}
