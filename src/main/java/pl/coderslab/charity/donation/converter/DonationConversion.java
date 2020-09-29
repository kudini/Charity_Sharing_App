package pl.coderslab.charity.donation.converter;

import pl.coderslab.charity.donation.dto.DonationDto;
import pl.coderslab.charity.donation.entity.Donation;

public class DonationConversion {
    public static DonationDto convertDonationToDonationDto(Donation donation) {
        return new DonationDto(donation);
    }

    public static Donation convertDonationDtoToDonation(DonationDto donationDto) {
        return new Donation(donationDto);
    }
}
