package com.greenfox.csomam.p2pchat.services;

import com.greenfox.csomam.p2pchat.models.Log;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LogService {

    public void checkEnvironment(HttpServletRequest request) {
        if (System.getenv("CHAT_APP_LOGLEVEL").equals("INFO")) {
            System.out.println(new Log(request).toString());
        } else if (System.getenv("CHAT_APP_LOGLEVEL").equals("ERROR")) {
            System.err.println(new Log(request).toString());
        }
    }

}
