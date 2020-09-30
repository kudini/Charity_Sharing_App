package pl.coderslab.charity.user.service;

import pl.coderslab.charity.user.entity.Role;
import pl.coderslab.charity.user.entity.User;

import java.util.List;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
    void modifyUser(User user);
    void saveUserWithNewPassword(User user);

    User findById(Long id);

    List<User> findAllByRoles(Role role);
    List<User> findAllUsers();
    Role findRoleByName(String roleName);
}
