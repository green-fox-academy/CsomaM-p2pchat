package com.greenfox.csomam.p2pchat.controllers;

import com.greenfox.csomam.p2pchat.models.User;
import com.greenfox.csomam.p2pchat.repositories.LogRepo;
import com.greenfox.csomam.p2pchat.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    LogRepo logRepo;

    @Autowired
    UserRepo userRepo;

    @RequestMapping("/")
    public String indexPage () {
        return "index";
    }

    @RequestMapping("/enter")
    public String add (Model model){
        model.addAttribute("newuser", new User());
        return "";
    }

    @PostMapping("/createuser")
    public String addPost(@ModelAttribute User newuser) {
        userRepo.save(newuser);
        return "redirect:/";
    }

}
