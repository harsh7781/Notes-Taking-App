package com.harshal.Notes_Taking_App.controller;

import com.harshal.Notes_Taking_App.entity.User;
import com.harshal.Notes_Taking_App.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/save-user")
    public String saveUser(@ModelAttribute User user, HttpSession session) {

        //existsBy Finder Method
        //boolean userExistOrNot = this.userService.emailExistOrNot(user.getEmail());

        User userExistOrNot = this.userService.getUserByEmail(user.getEmail());

        if(userExistOrNot != null) {
            session.setAttribute("message", "User already exist!");
        }
        else {
            User saveUser = this.userService.saveUser(user);

            if(saveUser != null) {
                session.setAttribute("message", "User registered successfully!");
            }
            else {
                session.setAttribute("message", "Something went wrong!");
            }
        }

        System.out.println(user);

        return "redirect:/register";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

}
