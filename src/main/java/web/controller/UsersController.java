package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.models.User;
import web.services.UserService;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userService.getListUsers());
        return "index";
    }

    @GetMapping("/addUser")
    public String addUserForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/editUser/{id}")
    public String editUserForm(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit-user";
    }

    @PostMapping("/editUser")
    public String editUser(@ModelAttribute User user) {
        userService.edit(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(userService.getUser(id));
        return "redirect:/";
    }
}
