package pl.coderslab.charity.donation.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.donation.entity.Donation;

import java.util.List;

@Service
public interface DonationService {
    List<Donation> findAllDonations();
    Long countDonations();
    Long countQuantity();
}
