package pl.coderslab.charity.donation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.donation.entity.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation,Long> {
}