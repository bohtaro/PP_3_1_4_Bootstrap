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

import java.util.List;

@Controller
@RequestMapping(name = "/admin")
public class AdminController {
    @Autowired
    private UserService userService;


    @GetMapping(value = "/admin/user_list")
    public String getUsers(ModelMap model) {
        model.addAttribute("user", userService.getAllUsers());
        return "users_list";
    }
    @GetMapping("/admin/new")
    public String newUserPage(Model model) {
        User user = new User();
        List<Role> listRoles = userService.listRoles();
        model.addAttribute("listRoles", listRoles);
        model.addAttribute("user", user);

        return "new_user";
    }
    @PostMapping(value = "/admin/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "redirect:/admin/user_list";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/user_list";
    }

    @GetMapping("/admin/edit/{id}")
    public ModelAndView editUserPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit");
        User user = userService.findById((long) id);
        List<Role> listRoles = userService.listRoles();
        mav.addObject("listRoles", listRoles);
        mav.addObject("user", user);

        return mav;
    }

    @PostMapping(value = "/admin/update")
    public String saveChangeUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);

        return "redirect:/admin/user_list";
    }
}
