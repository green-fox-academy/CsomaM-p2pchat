package com.greenfox.csomam.p2pchat.controllers;

import com.greenfox.csomam.p2pchat.models.ChatMessage;
import com.greenfox.csomam.p2pchat.models.Log;
import com.greenfox.csomam.p2pchat.models.User;
import com.greenfox.csomam.p2pchat.repositories.LogRepo;
import com.greenfox.csomam.p2pchat.repositories.MessageRepo;
import com.greenfox.csomam.p2pchat.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    LogRepo logRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    MessageRepo messageRepo;

    @ModelAttribute
    protected void initLog(HttpServletRequest request) {
        logRepo.save(new Log(request));
    }

    @RequestMapping({"/index", "/"})
    public String indexPage(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "index";
    }

    @RequestMapping("/enter")
    public String add(Model model) {
        model.addAttribute("newuser", new User());
        return "enter";
    }

    @PostMapping("/createuser")
    public String addPost(@ModelAttribute User newuser, Model model) {
        if (userRepo.findFelhasznalo(newuser.getName()) != null) {
            model.addAttribute("errorMessage", "Username already exists!");
            model.addAttribute("newuser", new User());
            return "enter";
        } else if (newuser.getName().equals("")) {
            model.addAttribute("errorMessage", "The field cannot be empty");
            model.addAttribute("newuser", new User());
            return "enter";
        }
        userRepo.save(newuser);
        return "redirect:/messageboard/{}";
    }

    @RequestMapping("/info")
    public String printInfo(Model model) {
        model.addAttribute("logs", logRepo.findAll());
        return "info";
    }

    @RequestMapping("/messageboard")
    public String showMessageBoard(Model model) {
        model.addAttribute("newmessage", new ChatMessage());
        model.addAttribute("messages", messageRepo.findAll());
        return "messageboard";
    }

    @PostMapping("/createmessage")
    public String createMessage (@ModelAttribute ChatMessage newmessage) {
        newmessage.setMessageBy("Marci");
        messageRepo.save(newmessage);
        return "redirect:/";
    }


}
