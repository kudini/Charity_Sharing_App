package pl.coderslab.charity.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDto {
    private String email;
    private String password;
    private String password2;

    public RegistrationDto() {
    }

    public RegistrationDto(String email, String password, String password2) {
        this.email = email;
        this.password = password;
        this.password2 = password2;
    }
}
