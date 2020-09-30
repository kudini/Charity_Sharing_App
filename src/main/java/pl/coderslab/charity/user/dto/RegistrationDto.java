package pl.coderslab.charity.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String password2;
}
