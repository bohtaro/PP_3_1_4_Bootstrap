package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(Long id);

    User findById(Long id);
    public User findByUsername(String username);

    void updateUser(User user);

    List<Role> listRoles();
}
