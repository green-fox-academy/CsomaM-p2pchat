package com.greenfox.csomam.p2pchat.controllers;

import com.greenfox.csomam.p2pchat.models.Message;
import com.greenfox.csomam.p2pchat.models.Log;
import com.greenfox.csomam.p2pchat.models.User;
import com.greenfox.csomam.p2pchat.repositories.LogRepo;
import com.greenfox.csomam.p2pchat.services.MessageService;
import com.greenfox.csomam.p2pchat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @Autowired
    LogRepo logRepo;

    @ModelAttribute
    protected void initLog(HttpServletRequest request) {
        logRepo.save(new Log(request));
    }

    @RequestMapping({"/index", "/", ""})
    public String indexPage(Model model) {
        model.addAttribute("users", userService.listAll());
        return "index";
    }

    @RequestMapping("/enter")
    public String add(Model model) {
        model.addAttribute("newuser", new User());
        return "enter";
    }

    @PostMapping("/createuser")
    public String addPost(@ModelAttribute User newuser, Model model) {
        if (userService.getUserByName(newuser.getName()) != null) {
            model.addAttribute("errorMessage", "Username already exists!");
            model.addAttribute("newuser", new User());
            return "enter";
        } else if (newuser.getName().equals("")) {
            model.addAttribute("errorMessage", "The field cannot be empty");
            model.addAttribute("newuser", new User());
            return "enter";
        }
        userService.addUser(newuser);
        return "redirect:/index";
    }

    @RequestMapping("/info")
    public String printInfo(Model model) {
        model.addAttribute("logs", logRepo.findAll());
        return "info";
    }

    @GetMapping("/messageboard/{id}")
    public String showMessageBoard(Model model, @PathVariable() long id) {
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("newmessage", new Message());
        model.addAttribute("messages", messageService.listAll());
        return "messageboard";
    }

    @PostMapping("/createmessage/{id}")
    public String createMessage (@ModelAttribute Message newmessage, @PathVariable() long id) {
        newmessage.setUsername(userService.getUser(id).getName());
        messageService.addMessage(newmessage);
        return "redirect:/messageboard/{id}";
    }
}
