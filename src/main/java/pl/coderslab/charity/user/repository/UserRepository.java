package pl.coderslab.charity.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.user.entity.Role;
import pl.coderslab.charity.user.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    List<User> findAllByRoles(Role role);
    List<User> findAllByRoles(String role);
}
