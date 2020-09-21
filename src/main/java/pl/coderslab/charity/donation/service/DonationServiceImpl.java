package pl.coderslab.charity.donation.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.donation.entity.Donation;
import pl.coderslab.charity.donation.repository.DonationRepository;

import java.util.List;
import java.util.function.LongFunction;

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

    @Override
    public Long countDonations() {
        return donationRepository.count();
    }

    @Override
    public Long countQuantity() {
        Long result =donationRepository.countQuantity();
        if(result==null){
            return 0l;
        }
        return result;
    }
}
