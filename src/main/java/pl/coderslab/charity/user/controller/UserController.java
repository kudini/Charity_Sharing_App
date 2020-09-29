package pl.coderslab.charity.user.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.user.dto.LoginDto;
import pl.coderslab.charity.user.dto.RegistrationDto;
import pl.coderslab.charity.user.entity.User;
import pl.coderslab.charity.user.model.CurrentUser;
import pl.coderslab.charity.user.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registrationGet(Model model) {
        model.addAttribute("registrationDto", new RegistrationDto());
        return "register";
    }

    @PostMapping("/register")
    public String registrationPost(@ModelAttribute RegistrationDto registrationDto) {
        User user = new User();
        if (registrationDto.getPassword().equals(registrationDto.getPassword2())) {
            user.setUsername(registrationDto.getEmail());
            user.setPassword(registrationDto.getPassword());
            userService.saveUser(user);
            return "redirect:login";
        } else {
            return "register";
        }
    }

    @GetMapping("/admin")
    @ResponseBody

    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername();
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("login", new LoginDto());
        return "login";
    }

}
