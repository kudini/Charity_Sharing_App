package pl.coderslab.charity.donation.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.category.entity.Category;
import pl.coderslab.charity.donation.dto.DonationDto;
import pl.coderslab.charity.institution.entity.Institution;

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
    @NotBlank
    private Integer quantity;
    @ManyToMany
    @NotEmpty
    private List<Category> categories;
    @OneToOne
    @NotEmpty
    private Institution institution;
    @NotBlank
    @Size(max=22,min = 9)
    private String phoneNumber;
    @NotEmpty
    private String street;
    @NotEmpty
    private String city;
    @NotEmpty
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "bledny kod pocztowy")
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;

    public Donation() {
    }

    public Donation(Long id, @NotBlank Integer quantity, @NotEmpty List<Category> categories, @NotEmpty Institution institution, @NotBlank @Size(max = 22, min = 9) String phoneNumber, @NotEmpty String street, @NotEmpty String city, @NotEmpty @Pattern(regexp = "\\d{2}-\\d{3}", message = "bledny kod pocztowy") String zipCode, @PastOrPresent LocalDate pickUpDate, LocalTime pickUpTime, String pickUpComment) {
        this.id = id;
        this.quantity = quantity;
        this.categories = categories;
        this.institution = institution;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
    }
    public Donation(DonationDto donationDto) {
        this.id = donationDto.getId();
        this.quantity = donationDto.getQuantity();
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
