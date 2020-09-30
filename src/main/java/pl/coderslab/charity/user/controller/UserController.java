package pl.coderslab.charity.user.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.user.dto.RegistrationDto;
import pl.coderslab.charity.user.dto.UserDto;
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
            user.setFirstName(registrationDto.getFirstName());
            user.setLastName(registrationDto.getLastName());
            user.setUsername(registrationDto.getEmail());
            user.setPassword(registrationDto.getPassword());
            userService.saveUser(user);
            return "redirect:login";
        } else {
            return "register";
        }
    }

    @PostMapping("/profile/edit")
    public String profileEditPost(@AuthenticationPrincipal CurrentUser currentUser,@ModelAttribute UserDto userDto) {
        User user = userService.findById(currentUser.getUser().getId());
         user.setLastName(userDto.getLastName());
         user.setFirstName(userDto.getFirstName());
         user.setUsername(userDto.getUsername());
        userService.saveUser(user);
        //todo change password
        return "redirect:/profile";
    }


    @GetMapping("/profile/edit")
    public String profileEdit(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        User user = userService.findById(currentUser.getUser().getId());
        UserDto userDto = new UserDto(user);
        model.addAttribute("userDto",userDto);
        return "edit_user";
    }

    @GetMapping("/profile")
    public String profileGet(@AuthenticationPrincipal CurrentUser currentUser,Model model) {
        model.addAttribute("user",userService.findById(currentUser.getUser().getId()));
        return "profile";
    }

    @GetMapping("/admin")
    @ResponseBody

    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername() + entityUser.getRoles();
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/test")
    @ResponseBody

    public String currentUserName(Authentication authentication) {

        return authentication.getPrincipal().toString();

    }

}
