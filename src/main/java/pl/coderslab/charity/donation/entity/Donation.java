package pl.coderslab.charity.donation.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.category.entity.Category;
import pl.coderslab.charity.donation.dto.DonationDto;
import pl.coderslab.charity.institution.entity.Institution;
import pl.coderslab.charity.user.entity.User;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User donor;
    private Integer quantity;
    @ManyToMany
    private List<Category> categories;
    @OneToOne
    private Institution institution;
    @NotBlank
    @Size(max=22,min = 9)
    private String phoneNumber;
    private String street;
    private String city;
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "bledny kod pocztowy")
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;
    private boolean pickedUp;

    public Donation() {
    }
    public Donation(DonationDto donationDto) {
        this.id = donationDto.getId();
        this.quantity = donationDto.getQuantity();
        this.donor = donationDto.getDonor();
        this.categories = donationDto.getCategories();
        this.institution = donationDto.getInstitution();
        this.phoneNumber = donationDto.getPhoneNumber();
        this.street = donationDto.getStreet();
        this.city = donationDto.getCity();
        this.zipCode = donationDto.getZipCode();
        this.pickUpDate = donationDto.getPickUpDate();
        this.pickUpTime = donationDto.getPickUpTime();
        this.pickUpComment = donationDto.getPickUpComment();
    }
}
