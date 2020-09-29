package pl.coderslab.charity.donation.dto;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.category.entity.Category;
import pl.coderslab.charity.donation.entity.Donation;
import pl.coderslab.charity.institution.entity.Institution;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class DonationDto {
    private Long id;
    private Integer quantity;
    private List<Category> categories;
    private Institution institution;
    private String phoneNumber;
    private String street;
    private String city;
    private String zipCode;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;

    public DonationDto() {
    }

    public DonationDto(Long id, Integer quantity, List<Category> categories, Institution institution, String phoneNumber, String street, String city, String zipCode, LocalDate pickUpDate, LocalTime pickUpTime, String pickUpComment) {
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
