package pl.coderslab.charity.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.donation.dto.DonationDto;
import pl.coderslab.charity.user.dto.UserDto;
import pl.coderslab.charity.user.entity.Role;
import pl.coderslab.charity.user.entity.User;
import pl.coderslab.charity.user.service.UserService;

import java.util.HashSet;

@Controller
public class AdminController {
    private  UserService userService;
    private final Role ADMIN_ROLE = new Role("ROLE_ADMIN");

    public AdminController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/admin/panel")
    public String listAdminsPanel(){
        return "admin-panel-list";
    }
    @GetMapping("/admin/panel/add")
    public String adminPanelAddGet(){
        return "admin-add";
    }
    @PostMapping("/admin/panel/add")
    public String adminPanelAddPost(){
        return "redirect:/admin/panel";
    }
    @GetMapping("/admin/{id}/edit")
    public String adminPanelEditGet(@PathVariable Long id, Model model){
        boolean isAdmin=false;
        UserDto userDto = new UserDto(userService.findById(id));
        model.addAttribute("userDto",userDto);
        if(userDto.getRoles().contains(ADMIN_ROLE)){
            isAdmin=true;
        }
        model.addAttribute("isAdmin",isAdmin);
        return "admin-add";
    }
    @PostMapping("/admin/{id}/edit")
    public String adminPanelEditPost(@ModelAttribute UserDto userDto){

        return "redirect:/admin/panel";
    }
    @GetMapping("/admin/{id}/delete")
    public String adminPanelDelete(@PathVariable Long id){
        User user = userService.findById(id);
        user.getRoles().remove(ADMIN_ROLE);
        userService.saveUser(user);
        return "redirect:/admin/panel";
    }
}
