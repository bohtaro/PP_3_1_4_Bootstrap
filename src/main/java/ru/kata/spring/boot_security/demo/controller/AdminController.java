package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(name = "/admin")
public class AdminController {
    @Autowired
    private UserService userService;


    @GetMapping(value = "/index")
    public String getUsers(ModelMap model, Principal principal) {
        model.addAttribute("oneUser", userService.findByUsername(principal.getName()));
        model.addAttribute("user", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        model.addAttribute("roles", userService.getListRole());
        return "index";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.saveUser(user);
        return "redirect:/index";
    }
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/index";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/index";
    }
}
