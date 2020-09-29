package pl.coderslab.charity.user.dto;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.user.entity.Role;
import pl.coderslab.charity.user.entity.User;

import java.util.Set;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private int enabled;
    private Set<Role> roles;
    private String firstName;
    private String lastName;

    public UserDto() {
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.getEnabled();
        this.roles = user.getRoles();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }
}
