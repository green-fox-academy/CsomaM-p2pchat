package com.greenfox.csomam.p2pchat.controllers;

import com.greenfox.csomam.p2pchat.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LogController {

    @Autowired
    LogService logService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public void log(HttpServletRequest request) {
        logService.checkEnvironment(request);
    }
}
