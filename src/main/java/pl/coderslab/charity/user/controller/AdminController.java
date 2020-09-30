package pl.coderslab.charity.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.user.dto.UserDto;
import pl.coderslab.charity.user.entity.Role;
import pl.coderslab.charity.user.entity.User;
import pl.coderslab.charity.user.service.UserService;
import pl.coderslab.charity.user.service.UserServiceImpl;

@Controller
public class AdminController {
    private final Role ADMIN_ROLE;
    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
        ADMIN_ROLE = userService.findRoleByName("ROLE_ADMIN");
    }

    @GetMapping("/admin/panel")
    public String listAdminsPanel(Model model) {
        model.addAttribute("admins", userService.findAllByRoles(ADMIN_ROLE));
        return "admin-panel-list";
    }

    @GetMapping("/admin/panel/add")
    public String adminPanelAddGet() {
        return "admin-add";
    }

    @PostMapping("/admin/panel/add")
    public String adminPanelAddPost() {
        return "redirect:/admin/panel";
    }

    @GetMapping("/admin/{id}/edit")
    public String adminPanelEditGet(@PathVariable Long id, Model model) {
        boolean isAdmin = false;
        UserDto userDto = new UserDto(userService.findById(id));
        model.addAttribute("userDto", userDto);
        if (userDto.getRoles().contains(ADMIN_ROLE)) {
            isAdmin = true;
        }
        model.addAttribute("isAdmin", isAdmin);
        return "admin-add";
    }

    @PostMapping("/admin/{id}/edit")
    public String adminPanelEditPost(@ModelAttribute UserDto userDto) {

        return "redirect:/admin/panel";
    }

    @GetMapping("/admin/{id}/delete")
    public String adminPanelDelete(@PathVariable Long id) {
        User user = userService.findById(id);
        user.getRoles().remove(ADMIN_ROLE);
        userService.saveUser(user);
        return "redirect:/admin/panel";
    }
}
