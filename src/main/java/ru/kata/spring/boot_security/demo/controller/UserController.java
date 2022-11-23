package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping(name = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user-page")
    public String oneUser(Model model, Principal principal) {
        model.addAttribute("oneUser", userService.findByUsername(principal.getName()));
        return "user-page";
    }
}
