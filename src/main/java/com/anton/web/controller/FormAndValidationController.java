package com.anton.web.controller;

import com.anton.service.daocontroller.UserDaoController;
import com.anton.service.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RequiredArgsConstructor
@Controller
public class FormAndValidationController {

    private final UserDaoController daoController;

    @ModelAttribute("userDto")
    public User addUserToModel() {
        return new User();
    }

    @ModelAttribute
    @GetMapping(path = "user-form")
    public String getUserForm() {
        return "user-form";
    }

    @PostMapping(path = "createUser")
    public String createUser(@Valid User user, BindingResult result, Model model) {
        List<FieldError> fieldErrors = result.getFieldErrors();
        if (fieldErrors.isEmpty()) {
            daoController.addUser(user);
            model.addAttribute("name", user.getFirstName());
            model.addAttribute("msg", "Hello");
            return "forward:/welcome";
        } else {
            model.addAttribute("msg", fieldErrors.toString());
            return "forward:/error";
        }
    }

    @PostMapping(path = "logIn")
    public String logInUser(@RequestParam String mail, @RequestParam String password, Model model) {
        User user = daoController.getUser(mail, password);
        if (user.getFirstName() == null) {
            model.addAttribute("msg", "Wrong login or password");
            return "forward:/error";
        } else {
            model.addAttribute("name", user.getFirstName());
            model.addAttribute("msg", "Hello");
            return "forward:/welcome";
        }
    }

    @PostMapping(value = "/welcome")
    public String forwardWelcomePage() {
        return "welcome";
    }

    @PostMapping(value = "/error")
    public String forwardErrorPage() {
        return "error";
    }

    @GetMapping(path = "index")
    public String getIndexPage() {
        return "index";
    }
}
