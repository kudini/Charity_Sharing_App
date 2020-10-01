package pl.coderslab.charity.donation.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.category.entity.Category;
import pl.coderslab.charity.donation.entity.Donation;
import pl.coderslab.charity.institution.entity.Institution;
import pl.coderslab.charity.user.entity.User;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class DonationDto {
    private Long id;
    private User donor;
    private Integer quantity;
    private List<Category> categories;
    private Institution institution;
    private String phoneNumber;
    private String street;
    private String city;
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;

    public DonationDto() {
    }

    public DonationDto(Donation donation) {
        this.id = donation.getId();
        this.quantity = donation.getQuantity();
        this.categories = donation.getCategories();
        this.institution = donation.getInstitution();
        this.phoneNumber = donation.getPhoneNumber();
        this.street = donation.getStreet();
        this.city = donation.getCity();
        this.zipCode = donation.getZipCode();
        this.pickUpDate = donation.getPickUpDate();
        this.pickUpTime = donation.getPickUpTime();
        this.pickUpComment = donation.getPickUpComment();
    }
}
